
package civitas;
import java.util.ArrayList;

public class Casilla {
 
    private static final int VALOR_DEF = 0;
    
    private static final float FACTORALQUILERCALLE = 1.0f;
    private static final float FACTORALQUILERCASA = 1.0f;
    private static final float FACTORALQUILERHOTEL = 4.0f;
     
    
    private String nombre;
    private float precioCompra, precioEdificar, precioBaseAlquiler;
    private int numCasas, numHoteles;

    private TipoCasilla tipo;
    private Jugador propietario;
    private MazoSorpresas mazo;
    private Sorpresa sorpresa;

    public int cantidadCasasHoteles(){
        return numCasas+numHoteles;
    }

    Casilla( TipoCasilla tipo , String nombre){
        init();
        this.tipo = tipo;
        this.nombre = nombre;
    }

    Casilla( TipoCasilla tipo, String nombre, float precioCompra, float precioEdificar, float precioBaseAlquiler){
        init();
        this.tipo = tipo;
        this.nombre = nombre;
        this.precioCompra = precioCompra;
        this.precioEdificar = precioEdificar;
        this.precioBaseAlquiler = precioBaseAlquiler;
    }
    
    Casilla( TipoCasilla tipo, String nombre, MazoSorpresas mazo){
        init();
        this.tipo = tipo;
        this.nombre = nombre;
        this.mazo = mazo;
    }
    boolean comprar(Jugador jugador){
        propietario = jugador;
        return propietario.paga(getPrecioCompra());
    }

    boolean construirCasa(Jugador jugador){
        jugador.paga(this.getPrecioEdificar());
        numCasas++;
        return true;  
    }
    
    boolean construirHotel(Jugador jugador){
        jugador.paga(this.getPrecioEdificar());
        numHoteles++;
        return true;      
    }
    
    boolean derruirCasas(int numero, Jugador jugador){
       if(esEsteElPropietario(jugador) && numCasas >= numero){
            numCasas = numCasas-numero;
            return true;
       }
       
       else return false;
    }  

    public boolean esEsteElPropietario(Jugador jugador){
        return jugador == propietario;  
    }

    int getNumCasas(){
        return numCasas;
    }
    
    int getNumHoteles(){
        return numHoteles;
    }
    
    float getPrecioAlquilerCompleto(){
        return (precioBaseAlquiler*(FACTORALQUILERCALLE+
                                    numCasas*FACTORALQUILERCASA+
                                    numHoteles*FACTORALQUILERHOTEL));
    }
    
    float getPrecioCompra(){
        return precioCompra;
    }
    
    float getPrecioEdificar(){
        return precioEdificar;
    }

    void informe (int iactual, ArrayList<Jugador> todos){
        Diario.getInstance().ocurreEvento("  " + todos.get(iactual).getNombre() + 
                            " ha caido en la casilla " + toString());
    }

    private void init(){
        precioCompra = VALOR_DEF;
        precioBaseAlquiler = VALOR_DEF;
        precioEdificar = VALOR_DEF;
        numCasas = VALOR_DEF;
        numHoteles = VALOR_DEF;
        propietario = new Jugador("");
    }

    void recibeJugador(int iactual, ArrayList<Jugador> todos)
    {
        if(tipo == TipoCasilla.CALLE)
            recibeJugador_calle(iactual, todos);
        else if(tipo == TipoCasilla.SORPRESA)
            recibeJugador_sorpresa(iactual, todos);
        else
            informe(iactual, todos);
        
    }
    
    private void recibeJugador_calle(int iactual, ArrayList<Jugador> todos){
       informe(iactual, todos);
       Jugador jugador = todos.get(iactual);

       if(!tienePropietario()){
           jugador.puedeComprarCasilla();
       }
       else
           tramitarAlquiler(todos.get(iactual));
    }
    
    private void recibeJugador_sorpresa(int iactual, ArrayList<Jugador> todos){
        Sorpresa sorpresa = mazo.siguiente();
        informe(iactual,todos);
        sorpresa.aplicarAJugador(iactual,todos);
        
    }

    public boolean tienePropietario(){
        return (!"".equals(propietario.getNombre()));
    }

    
    public String toString(){
        String cad = "";
        
        if(this.tipo == TipoCasilla.CALLE && tienePropietario()){
            cad = this.nombre ;
        }
        
        else if(this.tipo == TipoCasilla.CALLE && !tienePropietario()){
            cad = this.tipo + " "+ this.nombre + ". Precios: Compra: " +
                this.precioCompra + ", Edificar: " + this.precioEdificar + 
                ", Alquiler base: " + this.precioBaseAlquiler + ", Casas: " +
                this.numCasas + ", Hoteles: " + this.numHoteles + "\n";
        }
        
        else cad = this.nombre + "\n";
            
        return cad;
        
    }

    public void tramitarAlquiler(Jugador jugador){
        if(tienePropietario() && !esEsteElPropietario(jugador))
        {
            jugador.pagaAlquiler(getPrecioAlquilerCompleto());
            this.propietario.recibe(getPrecioAlquilerCompleto());
        }
    }
       
}  
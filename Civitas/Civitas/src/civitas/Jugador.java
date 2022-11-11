
package civitas;
import java.util.ArrayList;

public class Jugador implements Comparable <Jugador> {
    
    protected static int CasasMax = 4;
    protected static int CasasPorHotel = 4;
    protected static int HotelesMax = 4;
    protected static float PasoPorSalida = 1000;
    
    private static float SaldoInicial = 7500;
    
    private int casillaActual;
    private String nombre;
    private boolean puedeComprar;
    private float saldo;
    private ArrayList<Casilla> propiedades = new ArrayList<>();
  
    int cantidadCasasHoteles(){
        int cantidad = 0;
        for (Casilla propiedad : propiedades){
            cantidad = cantidad + propiedad.getNumCasas() +
                        propiedad.getNumHoteles();
        }
        
        return cantidad;
    }
    
    public int compareTo(Jugador otro){
        return Float.compare(otro.saldo, saldo);
    }
    
    public boolean comprar(Casilla titulo){
        boolean result = false;
        
        if(puedeComprar){
            float precio = titulo.getPrecioCompra();
            if(puedoGastar(precio)){
                result = titulo.comprar(this);
                propiedades.add(titulo);

                Diario.getInstance().ocurreEvento(("El jugador " + this + 
                        " compra la propiedad " + titulo ));
                puedeComprar = false;
            }
            
            else{
                Diario.getInstance().ocurreEvento("El jugador " + this +
                        " no tiene saldo para comprar la propiedad " + titulo );
            }
        }
            
        
        return result;
    }
    
    boolean construirCasa(int ip){
        boolean result = false;
        boolean existe = existeLaPropiedad(ip);
        if (existe){
            Casilla propiedad = propiedades.get(ip);
            boolean puedoEdificar = puedoEdificarCasa(propiedad);
            if(puedoEdificar){
                result = propiedad.construirCasa(this);
                Diario.getInstance().ocurreEvento("El jugador " + nombre + 
                        " contruye casa en la propiedad " + ip);
            }
        }
        return result;
    }
            
    boolean construirHotel(int ip){
        boolean result = false;
        if(existeLaPropiedad(ip)){
            Casilla propiedad = propiedades.get(ip);
            boolean puedoEdificarHotel = puedoEdificarHotel(propiedad);
            
            if(puedoEdificarHotel){
                result = propiedad.construirHotel(this);
                propiedad.derruirCasas(CasasPorHotel, this);
                Diario.getInstance().ocurreEvento("El jugador " + getNombre() + 
                        " construye hotel en la propiedad " + ip);
                
            }   
        }
        return result; 
    }

    boolean enBancarrota(){
        return saldo < 0;
    }
    
    private boolean existeLaPropiedad(int ip){
        return 0 <= ip && ip <= propiedades.size();
    }

    private static int getCasasMax(){
        return CasasMax;
    }

    static int getCasasPorHotel() {
        return CasasPorHotel;
    }

    public int getCasillaActual() {
        return casillaActual;
    }
        
    private static int getHotelesMax() {
        return HotelesMax;
    }

    public String getNombre() {
        return nombre;
    }

    private float getPremioPasoSalida(){
        return this.saldo + PasoPorSalida;
    }
    
    public ArrayList<Casilla> getPropiedades(){
        return propiedades;
    }
    
    boolean getPuedeComprar(){
        return puedeComprar;
    }

    public float getSaldo(){
        return saldo;
    }

    Jugador(String nombre){
        this.nombre = nombre;
        this.saldo = SaldoInicial;
        this.casillaActual = 0;
        this.puedeComprar = true;
    }

    protected Jugador(Jugador otro){
        this.nombre = otro.nombre;
        this.saldo = otro.saldo;
        this.casillaActual = otro.casillaActual;
        this.puedeComprar = otro.puedeComprar;
    }

    boolean modificarSaldo(float cantidad){
        saldo += cantidad;
        Diario diario = Diario.getInstance();
        if(cantidad > 0)    
            diario.ocurreEvento("  " + nombre + 
                                " ha incrementado su saldo: +" + cantidad);
        else
            diario.ocurreEvento("  " + nombre + 
                                " ha decrecrementado su saldo: " + cantidad); 
        return true;
    }
    
    boolean moverACasilla(int numCasilla){
        casillaActual = numCasilla;
        puedeComprar = false;
        
        Diario.getInstance().ocurreEvento("  " + nombre + 
                        " se ha movido a la casilla nº " + (casillaActual+1));
        
        return true;
    }
    
    boolean paga(float cantidad){
        return modificarSaldo(cantidad*(-1));
    }
    
    boolean pagaAlquiler(float cantidad){
        return paga(cantidad);
    }
    
    boolean pasaPorSalida(){
        recibe(PasoPorSalida);
        
        Diario.getInstance().ocurreEvento("  " + nombre + " ha pasado por "
                            + "la salida");
        
        return true;
    }

    boolean puedeComprarCasilla(){
        puedeComprar = true;
        return puedeComprar;
    }
    
    
    private boolean puedoEdificarCasa(Casilla propiedad){
        boolean puedoEdificarCasa = false;
        float precioEdificar = propiedad.getPrecioEdificar();

        if (puedoGastar(precioEdificar) && propiedad.getNumCasas() < getCasasMax())
            puedoEdificarCasa = true;
        
        return puedoEdificarCasa;   
    }
    
    private boolean puedoEdificarHotel(Casilla propiedad){
        boolean puedoEdificarHotel = false;
        float precio = propiedad.getPrecioEdificar();
            
        if (puedoGastar(precio))
            if(propiedad.getNumHoteles() < getHotelesMax() && 
                    propiedad.getNumCasas() >= getCasasPorHotel())
                puedoEdificarHotel = true;
        
        return puedoEdificarHotel;
    }
    
    private boolean puedoGastar(float precio){
        return (saldo >= precio);
    }

    boolean recibe(float cantidad){
        return modificarSaldo(cantidad);
    }

    boolean tieneAlgoQueGestionar(){
        boolean tiene = true;
        
        if (propiedades == null)
            tiene = false;
        
        return tiene;
    }

    public String toString(){
        return ("  " + getNombre() + 
                " se encuentra en la casilla " + (getCasillaActual()+1) +
                " y tiene un saldo de " + getSaldo());      
    }
}



package civitas;
import java.util.ArrayList;

public class Sorpresa {
    
    private String texto;
    private int valor;
    
    private MazoSorpresas mazo;
    private TipoSorpresa tipo;
 
    void aplicarAJugador(int actual, ArrayList<Jugador> todos){
        if(tipo == TipoSorpresa.PAGARCOBRAR)
            aplicarAJugador_pagarCobrar(actual, todos);
        else
            aplicarAJugador_porCasaHotel(actual, todos);
    }
    
    private void aplicarAJugador_pagarCobrar(int actual, ArrayList<Jugador> todos){
        informe(actual, todos);
        todos.get(actual).modificarSaldo(valor);
    }
    
    private void aplicarAJugador_porCasaHotel(int actual,ArrayList<Jugador> todos){
        informe(actual, todos);
        todos.get(actual).modificarSaldo
                        (valor*todos.get(actual).cantidadCasasHoteles());
    }
    

    private void informe(int actual, ArrayList<Jugador> todos){
        Diario diario = Diario.getInstance();
        diario.ocurreEvento("Se le ha aplicado una sorpresa al jugador " 
                            + todos.get(actual).getNombre() + "");
    }
    
    
    Sorpresa(TipoSorpresa tipo, String texto, int valor){
        this.tipo = tipo;
        this.texto = texto;
        this.valor = valor;
    }
    
 
    public String toString(){
        return texto;
    }
}

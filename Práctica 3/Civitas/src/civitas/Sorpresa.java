package civitas;
import java.util.ArrayList;

public class Sorpresa {    
    private boolean jugadorCorrecto(int actual, ArrayList<Jugador> todos)
    {
        return todos.size()>actual;
    }
    
    private void informe(int actual, ArrayList<Jugador> todos)
    {
        if (jugadorCorrecto(actual, todos))
            Diario.getInstance().ocurreEvento("Aplicando sorpresa("+toString()+") a "
                                               +todos.get(actual).getNombre());
    }

    protected void aplicarAJugador(int actual, ArrayList<Jugador> todos)
    {
        if (this.jugadorCorrecto(actual, todos)) {
            this.informe(actual, todos);
        }
    }
    protected void aplicarAJugador_pagarCobrar(int actual, ArrayList<Jugador> todos)
    {
        if (this.jugadorCorrecto(actual, todos)) {
            this.informe(actual, todos);
        }
    }
    protected void aplicarAJugador_porCasaHotel(int actual, ArrayList<Jugador> todos)
    {
        if (this.jugadorCorrecto(actual, todos)) {
            this.informe(actual, todos);
        }
    }
}


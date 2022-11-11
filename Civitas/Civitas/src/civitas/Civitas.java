
package civitas;
import java.util.ArrayList;

import controladorCivitas.Controlador;
import vistaTextualCivitas.*;

public class Civitas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ArrayList<String> jugadores = new ArrayList<>();
        jugadores.add("A");
        jugadores.add("B");
        jugadores.add("C");
        jugadores.add("D");
          
        CivitasJuego juego = new CivitasJuego(jugadores, false);
        VistaTextual vista = new VistaTextual(juego);
        Controlador controlador = new Controlador(juego,vista);
        controlador.juega();
    }
    
}

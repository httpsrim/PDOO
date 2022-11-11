/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegohombreslobo;
import java.util.ArrayList;
/**
 *
 * @author ijd00002
 */
public class JuegoHombresLobo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Jugador> jugadores =new ArrayList<>();
        boolean sigue = true;
        int rond = 1;
        Ronda ronda = new Ronda(rond,jugadores);
        Juego juego = new Juego(jugadores, ronda);
        Jugador Baloo = new Jugador("Baloo",TipoJugador.LOBO);
        Jugador Artic = new Jugador("Artic", TipoJugador.LOBO);
        Jugador Apolo = new Jugador("Apolo",TipoJugador.ALDEANO);
        Jugador Triunfo = new Jugador("Triunfo",TipoJugador.ALDEANO);
        Jugador Colono = new Jugador("Colono",TipoJugador.ALDEANO);
        Jugador Luna = new Jugador("Luna", TipoJugador.BRUJO);
        jugadores.add(Baloo); //0
        jugadores.add(Artic); //1
        jugadores.add(Apolo); //2
        jugadores.add(Triunfo); //3
        jugadores.add(Colono); //4
        jugadores.add(Luna); //5
        while(sigue){
           if(rond % 2 == 0){
               System.out.println("Es de día");
                juego.siguienteRonda(ronda);
           }
           else{
               System.out.println("Es de noche");
               juego.siguienteRonda(ronda);

           }
            rond++;
            if(!jugadores.contains(Baloo) && !jugadores.contains(Apolo)){
                System.out.println("Fin del Juego,ganan los aldeanos");
                sigue = false;
            }
            else if(!jugadores.contains(Luna) && !jugadores.contains(Colono) && !jugadores.contains(Apolo) && !jugadores.contains(Triunfo)){
                sigue = false;
                System.out.println("FIn del juego, ganan los lobos");
            }
            else
               sigue = true;
        }
    }
    
}

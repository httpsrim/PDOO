/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegohombreslobo;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author ijd00002
 */
public class Juego {
     private Scanner in = new Scanner(System.in);
    int id;
    ArrayList<Jugador> nombres = new ArrayList<>();
    Jugador jugador;
    Ronda ronda;
    public Juego(ArrayList<Jugador> nombres, Ronda id){
        this.nombres = nombres;
        ronda = new Ronda(this.id, this.nombres);
    }
    public void siguienteRonda(Ronda anterior){
        ronda = new Ronda(id,anterior);
        System.out.println("¿Que jugador quieres matar?");
        for(int i = 0;i < nombres.size();i++)
            System.out.println(i + " " + nombres.get(i));
        int iden = in.nextInt();
        jugador = nombres.get(iden);
        Eleccion elecciones = new Eleccion(jugador,ronda);
        jugador.addEleccion(elecciones);
        jugador.morir();
        if(jugador.getTipo() == TipoJugador.LOBO){
            nombres.remove(jugador);
        }
        if(jugador.getTipo() == TipoJugador.ALDEANO){
            System.out.println("¿Quieres revivirlo? 1: si, 0: no");
            int salvar = in.nextInt();
            if(salvar == 1){
                jugador.revivir();
            }
            else{
                nombres.remove(jugador);
            }
        }
        
    }
}

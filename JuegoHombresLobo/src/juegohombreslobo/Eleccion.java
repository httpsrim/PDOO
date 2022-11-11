/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegohombreslobo;

/**
 *
 * @author ijd00002
 */
public class Eleccion {
    Jugador jugador;
    Ronda ronda;
    public Eleccion(Jugador jugador,Ronda ronda){
        this.jugador = jugador;
        this.ronda = ronda;
    }
    
    public Jugador getJugador(){
        return jugador;
    }
    
    public Ronda getRonda(){
        return ronda;
    }
}

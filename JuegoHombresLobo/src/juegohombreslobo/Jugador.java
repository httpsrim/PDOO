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
public class Jugador {    
    private Scanner in = new Scanner(System.in);
    int AldeanosVivos;
    int LobosVivos;
    private String nombre;
    private boolean vivo;
    TipoJugador tipo;
    ArrayList<Eleccion> elecciones = new ArrayList<>();
    public Jugador(String nom, TipoJugador tip){
        this.nombre = nom;
        this.tipo = tip;
        vivo = true;
        if(this.tipo == TipoJugador.BRUJO || this.tipo == TipoJugador.ALDEANO)
            AldeanosVivos++;
        else
            LobosVivos++;
    
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    public TipoJugador getTipo(){
        return this.tipo;
    }
    
    int getAldeanosVivos(){
        return AldeanosVivos;
    }
    
    int getLobosVivos(){
        return LobosVivos;
    }
    
    public void addEleccion(Eleccion eleccion){
        elecciones.add(eleccion);
    }
    
    public void morir(){
        this.vivo = false;
        if(this.tipo == TipoJugador.LOBO)
            LobosVivos--;
        else
            AldeanosVivos--;
    }
    
    public void revivir(){
        this.vivo = true;
        AldeanosVivos++;
    }
}

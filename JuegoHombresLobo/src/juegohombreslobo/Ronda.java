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
public class Ronda {
   int id;
   private ArrayList<Eleccion> elecciones;
   private ArrayList<Jugador> jugadores = new ArrayList<>();
   
   public Ronda(int ID,ArrayList<Jugador> jugadores){
       this.id = ID;
       elecciones = new ArrayList<>();
       this.jugadores = jugadores;
   }
 
  public Ronda(int ID, Ronda anterior){
      this.id = ID;
      this.elecciones = anterior.elecciones;
      this.jugadores = anterior.jugadores;
  }

  
  public int getId(){
      return this.id;
  }
  
  public void matar(Jugador jugador){
      jugador.morir();
  }
  
  public void salvar(Jugador jugador){
      jugador.revivir();
  }
  
  public ArrayList<Eleccion> getElecciones(){
    return elecciones;
  }
  public ArrayList<String> getResultados(){
      ArrayList<String> resultados = new ArrayList<>();
      resultados.add("Vamos por la ronda " + this);
      resultados.add("Jugadores: " + jugadores.toString());
      return resultados;
  }
}

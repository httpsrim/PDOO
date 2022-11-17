/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejerciciosjavap4;
import java.util.ArrayList;
import java.util.Collections;
/**
 *
 * @author USUARIO
 */
public class EjerciciosJavaP4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Casilla casilla = new Casilla("Calle Albaricoque");
        CasillaCalle calle = new CasillaCalle("Calle pae",3);
        //Con esta definicion da error:
        //ArrayList<Casilla> tablero = new ArrayList();
        ArrayList<CasillaCalle> tablero = new ArrayList<>();
        Casilla casilla2 = new Casilla("Calle 2");
        CasillaCalle casilla1 = new CasillaCalle("Calle1",0);
    //EJERCICIO 1-3
      /* 
        System.out.println(casilla);
        casilla.recibeJugador();
        System.out.println(calle);
        calle.recibeJugador();*/
      //EJERCICIO 4  
      /*
        //da error  
         casilla.construirCasa();
          //no da error
           calle.construirCasa();
        */
      //EJERCICIO 4 pt2
      /*
      tablero.add(calle);
        tablero.get(0).construirCasa();
      */
      //EJERCICIO 4 pt3
      System.out.println("Casilla 1");
      casilla1.recibeJugador();
      System.out.println("Casilla 2");
      casilla2.recibeJugador();
    }
    
}

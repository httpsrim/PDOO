/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejerciciosjavap4;

/**
 *
 * @author USUARIO
 */
public class CasillaCalle extends Casilla {
    private int numCasas;

    public CasillaCalle(String nom, int casas) {
        super(nom);
        this.numCasas = casas;
    }
    
    public boolean recibeJugador(){
        //Ejercicio 2
        /*
        System.out.println("Soy una casilla calle y he recibido un jugador");
        return true;*/
        
        //Ejercicio 2
        if(super.recibeJugador()){  //reutilizando código del padre
            System.out.println("y ademas soy una calle");
            return true;
        }
        else{
            return false;
        }
    }   
    
    public void construirCasa(){
        numCasas++;
        System.out.println("Hay " + numCasas + " casas");
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package civitas;
import java.util.ArrayList;
/**
 *
 * @author inesp
 */
public class Hotel {
    public String nombre = " ";
    public String ciudad = " ";
    public int estrellas = 0;
    public int numReservas = 0;
    private static int NUM_HOTELES;
    private long tlf = 0;
    private String nombreDir = "";
    private String nom = "";
    private String DNI= "";
    private String entrada = "";
    private String salida = "";
    private int numHab = 0;
    private int pers = 0;
    Reserva[] reservas;
    ArrayList<Habitacion> habitaciones;
    Habitacion hab = new Habitacion(numHab, pers);
    Director director = new Director(nombreDir,tlf);
    Cliente cliente = new Cliente(DNI,nom);
    Reserva reserva = new Reserva(entrada,salida,cliente,this,hab);

    public Hotel(String hotel, String ciud, int estrell){
        nombre = hotel;
        ciudad = ciud;
        estrellas = estrell;
    }
    public int getNUM_HOTELES(){
        return NUM_HOTELES;
    }
  /*   public Director setDirector(Director dire){
        director = dire;
    }
    public Director getDirector(){
        return director.getNombre();
    }*/
    public void addReservas(Reserva reserva){
        numReservas++;
        reservas[numReservas].add(reserva);
        cliente.addReserva(reserva);
    }

    public int getReservs(){
        return cliente.getReservas();
    }
    /*public boolean addEmpleados(Empleados empleados){

    }*/
    public int getHabitacionEstrella(){
        int reser = 0;
        int demandado = 0;
        int[] contador = new int [habitaciones.size()];

        for(int i = 1; i <= reservas.length;i++){
            int num_hab = reservas[i].getHabitacion().getNumero();
            contador[i] += 1;
        }
        for(int i = 0; i <= reservas.length;i++){
            if(contador[i] > demandado){
               reser = contador[i];
               demandado = i;
            }
        }
        return demandado;
    }
}       


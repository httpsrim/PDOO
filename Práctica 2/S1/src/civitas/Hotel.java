/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package civitas;
import civitas.Director;
import civitas.Reserva;
import civitas.Cliente;
/**
 *
 * @author inesp
 */
public class Hotel {
    private String nombre;
    private String ciudad;
    private int estrellas;
    private static int NUM_HOTELES;
    private long tlf = 0;
    private String nombreDir = "";
    private String nom = "";
    private String DNI= "";
    private String entrada = "";
    private String salida = "";
    Reserva[] reservas;
    private int numReservas = 0;
    Director director = new Director(nombreDir,tlf);
    Cliente cliente = new Cliente(DNI,nom);
    Reserva reserva = new Reserva(entrada,salida,cliente,this);

    public Hotel(String hotel, String ciud, int estrell){
        nombre = hotel;
        ciudad = ciud;
        estrellas = estrell;
        NUM_HOTELES++;
    }
    public int getNUM_HOTELES(){
        return NUM_HOTELES;
    }
    public void setDirector(Director dire){
        director = dire;
    }
    public String getDirector(){
        return director.getNombre();
    }
    public void addReservas(Cliente cliente, String fechaEntrada, String fechaSalida){
        numReservas++;
        Reserva reserv = new Reserva(fechaEntrada,fechaSalida,cliente,this);
        this.reserva.add(reserva);
        cliente.addReserva(reserv);
    }
    public void quitReservas(Cliente cliente, String fechaEntrada, String fechaSalida){
        Reserva reserv[] = null;
        for(int i = 0; i < numReservas; i++){
            if(cliente == reservas[i].cliente && fechaEntrada == reservas[i].getFechaEntrada() && fechaSalida == reservas[i].getFechaSalida()){
            }
            else{
                reserv[i] = reservas[i];
            }
        }
        numReservas = 0;
        for(int i = 0 ; i < numReservas; i++){
            reservas[i] = reserv[i];
            numReservas++;
        }
    }
    
    }       
    public int getReservs(){
        return cliente.getReservas();
    }
}

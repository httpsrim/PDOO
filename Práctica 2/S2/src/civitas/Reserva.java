/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package civitas;
//import java.util.ArrayList;
/**
 *
 * @author inesp
 */
public class Reserva {
    private String fechaEntrada;
    private String fechaSalida;
    private String nombre = "";
    private String ciudad = " ";
    private String nom = " ";
    private String DNI = " ";
    private int estrellas = 0;
    public int numReservas = 0; 
    int numHabitacion = 0;
    int personas = 0;
    Reserva[] reservas;
    Habitacion hab = new Habitacion(numHabitacion, personas);
    Cliente cliente = new Cliente(DNI,nom);
    Hotel hotel = new Hotel(nombre,ciudad,estrellas);
    public Reserva(String entrada, String salida,Cliente clien,Hotel hot, Habitacion habitacion ){
        fechaEntrada = entrada;
        fechaSalida = salida;
        hotel = hot;
        cliente = clien;
        hab = habitacion;
    }
    public String getFechaEntrada(){
        return this.fechaEntrada;
    }
    public String getFechaSalida(){
        return this.fechaSalida;
    }
    public Cliente getCliente(){
        return this.cliente;
    }
    public Habitacion getHabitacion(){
        return hab;
    }
    public void add(Reserva r){
        reservas[numReservas+1] = r;
        numReservas++;
    }
 /*    public void quit(Cliente cliente,String fechaEntrada,String fechaSalida){//desde el inicio hasta el nº de reservas, cuando coincida con el buscado se borra
        Reserva reserv;
        for(int i = 0; i < numReservas; i++){
            if(cliente == reservas[i].cliente && fechaEntrada == reservas[i].fechaEntrada && fechaSalida == reservas[i].fechaSalida){
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
    }*/
}
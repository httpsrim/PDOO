/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package civitas;
import civitas.Hotel;
import civitas.Cliente;
import java.util.ArrayList;
/**
 *
 * @author inesp
 */
public class Reserva {
    private String fechaEntrada;
    private String fechaSalida;
    String nombre = "";
    String ciudad = " ";
    String nom = " ";
    String DNI = " ";
    int estrellas = 0;
    Reserva[] reservas;
    int numReservas = 0;
    Cliente cliente = new Cliente(DNI,nom);
    Hotel hotel = new Hotel(nombre,ciudad,estrellas);
    public Reserva(String entrada, String salida,Cliente clien,Hotel hot){
        fechaEntrada = entrada;
        fechaSalida = salida;
        hotel = hot;
        cliente = clien;
    }
    public String getFechaEntrada(){
        return fechaEntrada;
    }
    public String getFechaSalida(){
        return fechaSalida;
    }
    public Cliente getCliente(){
        return cliente;
    }
    public void add(Reserva r){
        reservas[numReservas+1] = r;
        numReservas++;
    }
    public void quit(Cliente cliente,String fechaEntrada,String fechaSalida){//desde el inicio hasta el nº de reservas, cuando coincida con el buscado se borra
        Reserva reserv[] = null;
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
    }
}
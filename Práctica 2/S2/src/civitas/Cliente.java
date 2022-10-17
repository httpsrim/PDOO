/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package civitas;
/**
 *
 * @author inesp
 */
public class Cliente {
    private String dni;
    private String nombre;
    private String entrada = "";
    private String salida = "";
    private String nom = "";
    private String ciudad = "";
    private int estrellas = 0;
    private int numReservas = 0;
    private int numHabitacion = 0;
    private int personas = 0;
    Reserva[] reservas;
    Habitacion hab = new Habitacion(numHabitacion,personas);
    Hotel hotel = new Hotel(nom,ciudad,estrellas);
    Reserva reserva = new Reserva(entrada,salida, this,hotel,hab);
    public Cliente(String DNI, String nom){
        dni = DNI;
        nombre = nom;
    }

    public String getNombre(){
        return nombre;
    }
    public void addReserva(Reserva r){
        reserva.add(r);
        this.numReservas++;
    }
    public String getDNI(){
        return this.dni;
    }
   /* public void quitReserva(Cliente cliente,String fechaEntrada,String fechaSalida){
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
    }*/
    
    public int getReservas(){
        return numReservas;
    }
}

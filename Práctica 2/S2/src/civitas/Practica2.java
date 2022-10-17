package civitas;
/**
 * @author inesp
 */

public class Practica2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String nom = "Hotelito";
        String ciudad = "Mi casa";
        String nom_cliente_1 = "Juan";
        String dni_1 = "1345B";
        String nom_cliente_2 = "Pepe";
        String dni_2 = "19450K";
        String nom_cliente_3 = "Zapato";
        String dni_3 = "0987E";
        String entrada_1 = "12/4/12";
        String entrada_2 = "21/5/21";
        String entrada_3 = "1/2/12";
        String salida_1 = "16/4/12";
        String salida_2 = "25/5/21";
        String salida_3 = "2/2/12";
        int estrellas = 4;
        int num_hab_1 = 1;
        int personas_1 = 2;
        int num_hab_2 = 1;
        int personas_2 = 3;
        int num_hab_3 = 4;
        int personas_3 = 1;

        Hotel hotel = new Hotel(nom, ciudad, estrellas);

        Cliente cliente_1 = new Cliente(dni_1, nom_cliente_1);
        Cliente cliente_2 = new Cliente(dni_2, nom_cliente_2);
        Cliente cliente_3 = new Cliente(dni_3, nom_cliente_3);

        Habitacion hab_1 = new Habitacion(num_hab_1, personas_1);
        Habitacion hab_2 = new Habitacion(num_hab_2, personas_2);
        Habitacion hab_3 = new Habitacion(num_hab_3, personas_3);

        Reserva reserva_1 = new Reserva(entrada_1, salida_1,cliente_1, hotel, hab_1);
        Reserva reserva_2 = new Reserva(entrada_2, salida_2, cliente_2, hotel,hab_2);
        Reserva reserva_3 = new Reserva(entrada_3, salida_3,cliente_3 , hotel, hab_3);
 
        hotel.addReservas(reserva_3);
        hotel.addReservas(reserva_2);
        hotel.addReservas(reserva_1);
        System.out.println(hotel.getHabitacionEstrella());
    }
}


package ejercicios;

import ejerciciosjava.Parcela;

/**
 *
 * @author Inés Jiménez 
 * 2ºD, Subgrupo D1.
 */
public class EjerciciosJava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Parcela sitio1 = new Parcela("Juan Pablo",123,236,542,1,1);
        Parcela sitio2 = sitio1;
       /* Parcela sitio3 = new Parcela("Hola",1,1,1,1,1);
        Parcela sitio4 = new Parcela("Hola",1,1,1,1,1);
        Parcela sitio5 = new Parcela("Hola",2,4,56,77,2);
        Parcela sitio6 = new Parcela("a",2,4,5,6,7);
        System.out.println("El sitio " + sitio1.getNombre() + " tiene de alquiler base " + sitio1.getPrecioAlquilerCompleto() + "euros, con " + sitio1.getNumCasas() + " casas y " + sitio1.getNumHoteles() + " hoteles");
        System.out.println("Construyendo hoteles...");
        System.out.println("Tiene de alquiler total: " + sitio1.getPrecioAlquilerCompleto());
        sitio1.construirHotel();
        sitio1.construirHotel();
        System.out.println("Construyendo casas...");
        sitio1.construirCasa();
        sitio1.construirCasa();
        System.out.println("Tiene ahora de alquiler " + sitio1.getPrecioAlquilerCompleto());
        System.out.println("iguales en identidad y estado:");
        System.out.println(sitio1.igualdadIdentidad(sitio2));
        System.out.println(sitio1.igualdadEstado(sitio2));
        System.out.println("iguales en estado:");
        System.out.println(sitio3.igualdadIdentidad(sitio4));
        System.out.println(sitio3.igualdadEstado(sitio4));
        System.out.println("No iguales:");
        System.out.println(sitio5.igualdadIdentidad(sitio6));
        System.out.println(sitio5.igualdadEstado(sitio6));*/
        boolean descuento_ = true;
        int porc = 42;
        System.out.println(sitio1.getPrecioAlquilerCompleto(descuento_, porc));
        descuento_ = false;
        porc = 34;
        System.out.println(sitio1.getPrecioAlquilerCompleto(descuento_, porc));
    }
    
}


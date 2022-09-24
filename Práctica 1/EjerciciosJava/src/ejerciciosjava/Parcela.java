/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejerciciosjava;

/**
 *@author Inés Jiménez
 * 2ºD D1
 */
public class Parcela {
    /**
     * Datos de la clase Parcela, son privados.
     */
    private String nombre;
    private float precioCompra,precioEdificar,precioBaseAlquiler;
    private int numCasas,numHoteles;
    /**
     * Constructor de la clase Parcela
    */
    public Parcela(String Nombre,float precio_compra,float precio_edificar,     
            float precio_base_alquiler, int num_casas, int num_hoteles){ 
        nombre = Nombre;
        precioCompra = precio_compra;
        precioEdificar = precio_edificar;
        precioBaseAlquiler = precio_base_alquiler;
        numCasas = num_casas;
        numHoteles = num_hoteles;
    }
    
    /**
     * métodos get:
     */
    public String getNombre(){
        return this.nombre;
    }
    public float getPrecioCompra(){
        return this.precioCompra;
    }
    public float getPrecioEdificar(){
        return this.precioEdificar;
    }
    public int getNumCasas(){
        return this.numCasas;
    }
    public int getNumHoteles(){
        return this.numHoteles;
    }
    /**
     * devuelve el precio del alquiler.
    */
    public double getPrecioAlquilerCompleto(){
        double precio = 0;
        precio = precioBaseAlquiler*(1+numCasas+numHoteles*4);
        return precio;
    }
    
    /**
     * sobrecarga del método getPrecioAlquilerCompleto()
     */
    public double getPrecioAlquilerCompleto(boolean descuento, int porcentaje){
        double precio = 0;
        double porc = porcentaje;
        if(descuento == true){
            precio = precioBaseAlquiler*(1+numCasas+numHoteles*4);
            precio = precio * (1-(porc/100));
        }
        else{
            precio = precioBaseAlquiler*(1+numCasas+numHoteles*4);
        }
        return precio;
    }
    /**
     * construir casas
     * @return true, siempre devuelve true
    */
    
    public boolean construirCasa(){
        numCasas++;
        return true;                                                           
    }
    
    /**
     * construir hoteles
     * @return true, siempre devuelve true
     */
    public boolean construirHotel(){
        numHoteles++;
        return true;                                                            
    }
    
    public boolean igualdadIdentidad (Parcela otraParcela){
        boolean identidad = false;
        if(otraParcela == this)
            identidad = true;
        return identidad;
    }
    
    public boolean igualdadEstado (Parcela otraParcela){
              boolean estado = false;
        if(otraParcela.nombre.equals(this.nombre)){
            if(otraParcela.numCasas == this.numCasas){
               if(otraParcela.numHoteles == this.numHoteles){
                   if(otraParcela.precioBaseAlquiler == this.precioBaseAlquiler){
                       if(otraParcela.precioCompra == this.precioCompra){
                           if(otraParcela.precioEdificar == this.precioEdificar){
                               estado = true;
                           }
                       }
                   }
               }
            }
        }
        return estado;
    }
}

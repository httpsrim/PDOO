/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package civitas;

/**
 *
 * @author inesp
 */
public class Director {
    private String nombre;
    private long telefono;
    public Director(String nom, long tlf){
        this.nombre = nom;
        this.telefono = tlf;
    }
    public String getNombre(){
        return nombre;
    }
    public long getTelefono(){
        return this.telefono;
    }
}

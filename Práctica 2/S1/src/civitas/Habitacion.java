package civitas;
public class Habitacion {
    private int numero = 0;
    private int capacidad = 0;

    public Habitacion(int num,int cap){
        capacidad = cap;
        numero = num;
    }
    public int getCapacidad(){
        return this.capacidad;
    }
    
    public int getNumero(){
        return this.numero;
    }
}

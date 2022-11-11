
package civitas;

import java.util.ArrayList;

public class Tablero {
    
    private static final int CASILLAS_TOTALES = 20;
    private static final int VALOR_DEF = 0;
    
    private boolean porSalida;
    
    private ArrayList<Casilla> casillas;

    void añadeCasilla(Casilla casilla){
        casillas.add(casilla);

    }
    
    boolean computarPasoPorSalida(){
        boolean salida = porSalida;
        porSalida = false;
        return salida;
    }
    
    private boolean Correcto(int numCasilla){
        return (VALOR_DEF<=numCasilla && numCasilla < CASILLAS_TOTALES);
    }

    
    public Casilla getCasilla(int numCasilla){
        Casilla casilla = null;
        
        if(Correcto(numCasilla)) 
            casilla = casillas.get(numCasilla);
        
        return casilla;
    }
    
    public ArrayList<Casilla> getCasillas(){
        return casillas;
    }

    int nuevaPosicion(int actual, int tirada){
        int pos = actual;
        pos += tirada;
        
        if(pos >= CASILLAS_TOTALES) {
            pos = pos % CASILLAS_TOTALES;
            porSalida = true;
        }
        return pos;    
    }

   
    Tablero(){
        casillas = new ArrayList<>();
        casillas.add(new Casilla(TipoCasilla.DESCANSO,"Salida"));
        
        porSalida = false;
    }
    
}

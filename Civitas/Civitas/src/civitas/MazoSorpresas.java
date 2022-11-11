
package civitas;
import java.util.ArrayList;
import java.util.Collections;

public class MazoSorpresas {
    
    private static final int NUM_CARTAS = 10;
    
    private boolean barajada;
    private int usadas;
    private boolean debug;
    
    private ArrayList<Sorpresa> sorpresas;
    

    private void init(){
        sorpresas = new ArrayList<>();
        barajada = false;
        usadas = 0;
    }
    
    MazoSorpresas(boolean debug){
        init();
        this.debug = debug;
        
    }
    
    MazoSorpresas(){
        init();
        debug = false;
    }
    
    void alMazo(Sorpresa s){
        if(!barajada)
            sorpresas.add(s);
    }

    Sorpresa siguiente(){
        if (!barajada || usadas == NUM_CARTAS)
           if(!debug){
               Collections.shuffle(sorpresas);
               usadas = 0;
               barajada = true;
           }
        
        usadas ++;
        
        Sorpresa s = sorpresas.get(0);
        sorpresas.remove(0);
        sorpresas.add(s);
        
        return s;
    }
}

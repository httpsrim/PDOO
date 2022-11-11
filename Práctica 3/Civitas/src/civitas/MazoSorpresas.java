package civitas;

import java.util.ArrayList;
import java.util.Collections;

public class MazoSorpresas {
    private Boolean barajada;
    private Boolean debug;
    private Sorpresa ultimaSorpresa;
    private int usadas;
    private ArrayList<Sorpresa> sorpresas;


    protected MazoSorpresas(Boolean debug) {
        this.debug = debug;
        init();
        if (debug == true) {
            Diario.getInstance().ocurreEvento("true");
        }
    }

    protected MazoSorpresas() {
        init();
        debug = false;
    }

    private void init() {
        sorpresas = new ArrayList<>();
        barajada = false;
        usadas = 0;
    }
    
    protected void alMazo(Sorpresa sorpresa) {
        if (barajada == false) {
            sorpresas.add(sorpresa);
        }
    }


    protected Sorpresa siguiente() {
        if (barajada == false || usadas == sorpresas.size()) {
            if (debug == false) {
                Collections.shuffle(sorpresas);
                usadas = 0;
                barajada = true;
            }

        }
        usadas++;
        ultimaSorpresa = sorpresas.get(0);
        sorpresas.remove(0);
        sorpresas.add(ultimaSorpresa);
        return ultimaSorpresa;
    }

}
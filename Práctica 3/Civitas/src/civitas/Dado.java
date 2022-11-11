package civitas;

import java.util.Random;

public class Dado{
    private Random random;
    private boolean debug = false;
    private static final Dado instance = new Dado();
    private int ultimoResultado;
    private int VALORDEBUG = 1;
    private int VALORESDADO = 6;
    
    protected static Dado getInstance() { 
        return instance; 
    }
    
    protected int tirar(){
        int resultado;
        if(debug == false)
            resultado = random.nextInt(VALORESDADO)+VALORDEBUG;
        else 
            resultado = 1;

        ultimoResultado = resultado;
        return resultado;
    }
       
    protected int quienEmpieza(int n){
        return  random.nextInt(n);
    }
    
    protected int getUltimoResultado(){
        return ultimoResultado;
    }
   
    public void setDebug(Boolean d) {
        debug = d;
        if(debug==true)
            Diario.getInstance().ocurreEvento("true");
        else 
            Diario.getInstance().ocurreEvento("false");
    }
   
}

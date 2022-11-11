
package civitas;
import java.util.Random;

class Dado {
    
    private static int VALORDEBUG = 1;
    private static int VALORESDADO = 6;
    private static Dado instance = new Dado();
    
    private Random random = new Random();
    private int ultimoResultado;
    private boolean debug;
    
    Dado(){
        debug = false;
    }
 

    static public Dado getInstance(){
        return instance;
    }
    
    int getUltimoResultado(){
        return ultimoResultado;
    }
    

    public void setDebug(boolean debug){
        this.debug = debug;
    }

    int quienEmpieza(int n){
        return random.nextInt(n);
    }
    
          
    int tirar(){
        if(debug==false) 
            ultimoResultado = random.nextInt(6) + 1;
        else ultimoResultado = 1;
        
        return ultimoResultado;
    }
}

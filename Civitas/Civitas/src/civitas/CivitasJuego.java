
package civitas;
import java.util.ArrayList;
import java.util.Collections;

public class CivitasJuego {
    
    private int indiceJugadorActual;
    
    private Tablero tablero;
    private ArrayList<Jugador> jugadores = new ArrayList<>();
    private MazoSorpresas mazo;
    
    private OperacionJuego operacion;
    private GestorEstados gestor;
    private EstadoJuego estado;
    
    private void avanzaJugador(){
        Jugador jugadorActual = getJugadorActual();
        float saldo = jugadorActual.getSaldo();
        int posicionActual = jugadorActual.getCasillaActual();
        int tirada = Dado.getInstance().tirar();
        int posicionNueva = tablero.nuevaPosicion(posicionActual, tirada);
        Casilla casilla = tablero.getCasilla(posicionNueva);
        contabilizarPasosPorSalida();
        jugadorActual.moverACasilla(posicionNueva);
        casilla.recibeJugador(indiceJugadorActual, jugadores);
        
    }


    
    CivitasJuego(ArrayList<String> nombres, boolean debug){
        jugadores = new ArrayList<>();
        for(String nombre : nombres)
            jugadores.add(new Jugador(nombre)); 
        
        gestor = new GestorEstados();
        estado = gestor.estadoInicial();
        
        Dado dado = Dado.getInstance(); 
        dado.setDebug(debug);
        
        indiceJugadorActual = dado.quienEmpieza(4);
        
        mazo = new MazoSorpresas(debug);
        
        tablero = new Tablero();
        inicializaTablero(mazo);
        inicializaMazoSorpresas();
        
    }
    
  
    public boolean comprar(){
       boolean res = false;
       Jugador jugadorActual = getJugadorActual();
       int numCasillaActual = jugadorActual.getCasillaActual();
       Casilla casilla = tablero.getCasilla(numCasillaActual);
       res = jugadorActual.comprar(casilla);
       return res;
    }
    
    public boolean construirCasa(int ip){
        return getJugadorActual().construirCasa(ip);
    }
    
    public boolean construirHotel(int ip){
        return getJugadorActual().construirHotel(ip);
    }

     
    private void contabilizarPasosPorSalida(){
        if (tablero.computarPasoPorSalida())
            jugadores.get(indiceJugadorActual).pasaPorSalida();
    }

    public boolean finalDelJuego(){
        boolean fin = false;
        for(Jugador jugador : jugadores){
            if(jugador.enBancarrota() == true)
                fin = true;
        }
        
        return fin;
    }
    
    
    public int getIndiceJugadorActual(){
        return indiceJugadorActual;
    }
    
    public Jugador getJugadorActual(){
        return jugadores.get(indiceJugadorActual);
    }
    
    public ArrayList<Jugador> getJugadores(){
        return jugadores;
    }
    
    public Tablero getTablero(){
        return tablero;
    }


    
    private void inicializaMazoSorpresas(){
        mazo.alMazo(new Sorpresa(TipoSorpresa.PAGARCOBRAR,"Sorpresa_1", 100));
        mazo.alMazo(new Sorpresa(TipoSorpresa.PAGARCOBRAR,"Sorpresa_1", 500));
        mazo.alMazo(new Sorpresa(TipoSorpresa.PAGARCOBRAR,"Sorpresa_1", 1000));
        mazo.alMazo(new Sorpresa(TipoSorpresa.PAGARCOBRAR,"Sorpresa_1", -100));
        mazo.alMazo(new Sorpresa(TipoSorpresa.PAGARCOBRAR,"Sorpresa_1", -500));
        mazo.alMazo(new Sorpresa(TipoSorpresa.PAGARCOBRAR,"Sorpresa_1", -1000));
        mazo.alMazo(new Sorpresa(TipoSorpresa.PORCASAHOTEL,"Sorpresa_2", 100));
        mazo.alMazo(new Sorpresa(TipoSorpresa.PORCASAHOTEL,"Sorpresa_2", 1000));
        mazo.alMazo(new Sorpresa(TipoSorpresa.PORCASAHOTEL,"Sorpresa_2", -100));
        mazo.alMazo(new Sorpresa(TipoSorpresa.PORCASAHOTEL,"Sorpresa_2", -1000));

    }
    private void inicializaParking(MazoSorpresas mazo){
        tablero.añadeCasilla(new Casilla(TipoCasilla.DESCANSO, "parking"));
    }
    private void inicializaTablero(MazoSorpresas mazo){
        tablero.añadeCasilla(new Casilla(TipoCasilla.CALLE, "Velázquez", 60, 20, 50));
        tablero.añadeCasilla(new Casilla(TipoCasilla.CALLE, "Salamanca", 80, 30, 100));
        tablero.añadeCasilla(new Casilla(TipoCasilla.CALLE,"Castellana", 100, 40, 200));
        tablero.añadeCasilla(new Casilla(TipoCasilla.CALLE,"Tirso de M.", 120, 50, 300));
        tablero.añadeCasilla(new Casilla(TipoCasilla.SORPRESA,"Sorpresa", mazo));
        tablero.añadeCasilla(new Casilla(TipoCasilla.CALLE,"Lavapiés", 140, 60, 400));
        tablero.añadeCasilla(new Casilla(TipoCasilla.CALLE,"Goya", 150, 70, 500));
        tablero.añadeCasilla(new Casilla(TipoCasilla.SORPRESA,"Sorpresa", mazo));
        tablero.añadeCasilla(new Casilla(TipoCasilla.CALLE,"Mataelpino", 200, 80, 600));
        tablero.añadeCasilla(new Casilla(TipoCasilla.DESCANSO,"Puro relax"));
        tablero.añadeCasilla(new Casilla(TipoCasilla.CALLE,"Leganitos", 220, 90, 700));
        tablero.añadeCasilla(new Casilla(TipoCasilla.CALLE,"Serrano", 240, 100, 800));
        tablero.añadeCasilla(new Casilla(TipoCasilla.CALLE,"P. del Prado", 260, 110, 900));
        tablero.añadeCasilla(new Casilla(TipoCasilla.SORPRESA,"Sorpresa", mazo));
        tablero.añadeCasilla(new Casilla(TipoCasilla.CALLE,"Valdelatas", 280, 120, 1000));
        tablero.añadeCasilla(new Casilla(TipoCasilla.CALLE,"Méndez A.", 300, 130, 1100));
        tablero.añadeCasilla(new Casilla(TipoCasilla.SORPRESA,"Sorpresa", mazo));
        tablero.añadeCasilla(new Casilla(TipoCasilla.CALLE,"O'Donell", 350, 140, 1200));
        tablero.añadeCasilla(new Casilla(TipoCasilla.CALLE,"San Jerónimo", 400, 150, 1300));
    }


    
    private void pasarTurno(){
        indiceJugadorActual = (indiceJugadorActual+1) % 4;

    }

    
    public ArrayList<Jugador> ranking(){
        Collections.sort(jugadores, Jugador::compareTo);
        return jugadores;
    }

    public OperacionJuego siguientePaso(){
        Jugador jugadorActual = getJugadorActual();
        operacion = gestor.siguienteOperacion(jugadorActual, estado);
        
        if(operacion == OperacionJuego.PASAR_TURNO){
            pasarTurno();
            siguientePasoCompletado(operacion);
        }
        
        if(operacion == OperacionJuego.AVANZAR){
            avanzaJugador();
            siguientePasoCompletado(operacion);
        }
        
        return operacion;
    }
    
    public void siguientePasoCompletado(OperacionJuego operacion){
        estado = gestor.siguienteEstado(jugadores.get(indiceJugadorActual), estado, operacion);
    }

    private void PasosPorSalida(Jugador jugadorActual) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
        
            
}

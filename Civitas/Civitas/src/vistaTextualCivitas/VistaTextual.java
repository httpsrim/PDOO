package vistaTextualCivitas;

import civitas.Casilla;
import civitas.CivitasJuego;
import civitas.Diario;
import civitas.OperacionJuego;
import controladorCivitas.Respuesta;
import civitas.OperacionInmobiliaria;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;



public class VistaTextual implements Vista {
  
    
  private static String separador = "=====================";
  int iGestion   = -1;
  int iPropiedad = -1;
  private Scanner in;
  
  CivitasJuego juegoModel;
  
  public VistaTextual (CivitasJuego juegoModel) {
    in = new Scanner (System.in);
    this.juegoModel=juegoModel;
  }
  
  
           
 public  void pausa() {
    System.out.print ("\nPulsa una tecla");
    in.nextLine();
  }

  int leeEntero (int max, String msg1, String msg2) {
    Boolean ok;
    String cadena;
    int numero = -1;
    do {
      System.out.print (msg1);
      cadena = in.nextLine();
      try {  
        numero = Integer.parseInt(cadena);
        ok = true;
      } catch (NumberFormatException e) { 
        System.out.println (msg2);
        ok = false;  
      }
      if (ok && (numero < 0 || numero >= max)) {
        System.out.println (msg2);
        ok = false;
      }
    } while (!ok);

    return numero;
  }

  int menu (String titulo, ArrayList<String> lista) {
    String tab = "  ";
    int opcion;
    System.out.println (titulo);
    for (int i = 0; i < lista.size(); i++) {
      System.out.println (tab+i+"-"+lista.get(i));
    }

    opcion = leeEntero(lista.size(),
                          "\n"+tab+"Elige una opción: ",
                          tab+"Valor erróneo");
    return opcion;
  }
  
  @Override
  public void actualiza(){
    String propiedades = "";
    System.out.println(separador);
    if(this.juegoModel.getJugadorActual().getPropiedades().isEmpty()) {
            propiedades ="No tiene propiedades\n";
      } else 
              for(int i = 0; i < this.juegoModel.getJugadorActual().getPropiedades().size(); i++){
                   propiedades += this.juegoModel.getJugadorActual().getPropiedades().get(i).toString();        
        }
    if(!juegoModel.finalDelJuego()){
        int indice = juegoModel.getJugadorActual().getCasillaActual();
        int casillaActual = juegoModel.getJugadorActual().getCasillaActual();
        
        propiedades = propiedades + "Casilla actual: " + casillaActual;

    }   
  }
      
     
  @Override
  public Respuesta comprar(){
    int opcion = menu ("\n¿Quieres comprarla?",
                        new ArrayList<> (Arrays.asList("NO","SI") ) 
                      );
    return (Respuesta.values()[opcion]);
  }
  
  @Override
  public OperacionInmobiliaria elegirOperacion(){
    ArrayList<String> propiedades = new ArrayList<>();
      for(int i = 0 ; i < juegoModel.getJugadorActual().getPropiedades().size();i++){
              propiedades.add(juegoModel.getJugadorActual().getPropiedades().get(i).toString());
          }
      int gestion,propiedad;
      gestion = menu("¿Cque quieres hacer?",new ArrayList<> (Arrays.asList("-> CONSTRUIR_CASA","-> CONSTRUIR_HOTEL","-> TERMINAR")));
      switch(gestion){
        case 0:
         propiedad = menu("¿cual propiedad?",propiedades);
         this.iPropiedad = propiedad;
         return OperacionInmobiliaria.CONSTRUIR_CASA;
        case 1:
          
          propiedad = menu("¿cual propiedad?",propiedades);
          this.iPropiedad = propiedad;
          return OperacionInmobiliaria.CONSTRUIR_HOTEL;
        case 2:
          return OperacionInmobiliaria.TERMINAR;
        default:
          return null;
      }
  }
  
  @Override
  public int elegirPropiedad(){
    return this.iPropiedad;
  }
  @Override
  public void mostrarSiguienteOperacion(OperacionJuego operacion){
      String tab = "Siguiente operacion: " + operacion.toString();
      System.out.println(tab);
  }
  
  @Override
  public void mostrarEventos(){
      while(Diario.getInstance().eventosPendientes())
          System.out.println(Diario.getInstance().leerEvento());
  }

}

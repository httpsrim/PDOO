package civitas;

/**
 * @author Inés Jiménez
 */
public class Casilla {
    /**
     *@author Inés Jiménez
     * 2ºD D1
     */
        private String nombre;
        private float precioCompra,precioEdificar,precioBaseAlquiler;
        private int numCasas,numHoteles;
        private static float FACTORALQUILERCALLE = 1;
        private static float FACTORALQUILERCASA = 1;
        private static float FACTORALQUILERHOTEL = 4;
        protected String getNombre(){
            return this.nombre;
        }
        protected float getPrecioCompra(){
            return this.precioCompra;
        }
        protected float getPrecioEdificar(){
            return this.precioEdificar;
        }
        protected int getNumCasas(){
            return this.numCasas;
        }
        protected int getNumHoteles(){
            return this.numHoteles;
        }
        /**
         * devuelve el precio del alquiler.
        */
        protected double getPrecioAlquilerCompleto(){
            double precio = 0;
            precio = precioBaseAlquiler*(FACTORALQUILERCALLE+numCasas*FACTORALQUILERCASA+numHoteles*FACTORALQUILERHOTEL);
            return precio;
        }

        protected boolean construirCasa(){
            numCasas++;
            return true;                                                           
        }

        protected boolean construirHotel(){
            numHoteles++;
            return true;                                                            
        }

        protected void informe(int iactual, Jugador todos){}
        public void init(){}
        protected void recibeJugador(int iacutal,Jugador todos){}
        private void recibeJugador_calle(int iactual,Jugador todos){}
        private void recibeJugador_sorpresa_(int iactual, Jugador todos){}
}

package civitas;

public class GestionInmobiliaria {
    private OperacionInmobiliaria operacion;
    private int id;

    public GestionInmobiliaria(OperacionInmobiliaria operacion, int id) {
        this.operacion = operacion;
        this.id = id;
    }

    public OperacionInmobiliaria getOperacion() {
        return operacion;
    }

    public int getId() {
        return id;
    }
    
}

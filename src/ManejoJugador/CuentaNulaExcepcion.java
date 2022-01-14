package ManejoJugador;

public class CuentaNulaExcepcion extends Exception {
    /*Excepción personalizada que devuelve un mensaje correspondiente al error*/
    public CuentaNulaExcepcion() {
        super("Esa cuenta no existe");
    }
}

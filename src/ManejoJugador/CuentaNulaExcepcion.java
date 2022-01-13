package ManejoJugador;

public class CuentaNulaExcepcion extends Exception{
    public CuentaNulaExcepcion(){
        super("Esa cuenta no existe");
    }
}

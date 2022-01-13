package ManejoJugador;

public class SobrescrituraExcepcion extends Exception{
    public SobrescrituraExcepcion(){
        super("Esa cuenta ya existe");
    }
}

package domain;

public class Partida {
    private String nombreJugador;
    private String resultado;
    private int puntos;
    private String ronda;

    /*La clase partida se usa para guardar momentaneamente los datos de la partida en progreso.*/
    public Partida(){
    }

    public Partida(String nombre){
        this.nombreJugador = nombre;
    }

    public void setPuntos(int puntos){
        this.puntos = puntos;
    }

    public String getNombreJugador() {
        return nombreJugador;
    }

    public void setNombreJugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }

    public int getPuntos() {
        return puntos;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public String getRonda() {
        return ronda;
    }

    public void setRonda(String ronda) {
        this.ronda = ronda;
    }

    @Override
    public String toString() {
        return nombreJugador+"xx"+resultado+"xx"+puntos+"xx"+ronda;
    }
}

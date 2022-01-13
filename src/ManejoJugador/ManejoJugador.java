package ManejoJugador;

import static ManejoDatos.ManejoDatos.*;
import domain.Jugador;

public class ManejoJugador {

    public void Registrar(Jugador jugador) throws SobrescrituraExcepcion {
        if(!buscar("Jugadores.txt", jugador.getNombre())) {
            escribir(jugador.getNombre(), "Jugadores.txt", true);
            crear("Historial"+jugador.getNombre()+".txt");
        }else{
            throw new SobrescrituraExcepcion();
        }
    }

    public void Ingresar(String nombreJugador) throws CuentaNulaExcepcion {
        if(buscar("Jugadores.txt", nombreJugador)){
            crear("JugadorActual.txt");
            escribir(nombreJugador, "JugadorActual.txt", false);
        }else{
            throw new CuentaNulaExcepcion();
        }
    }


}

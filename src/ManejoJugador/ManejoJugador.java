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

    public static int contarPuntos(String nombreJugador){
     int lineas = contarLineas("Historial"+nombreJugador+".txt");
     int puntos = 0;
     for(int i = 1; i<=lineas; i++){
         puntos = puntos + Integer.parseInt(leerParte(leerLinea("Historial"+nombreJugador+".txt", i), 3));
     }
     return puntos;
     }
    public static int contarGanadas(String nombreJugador){
        int lineas = contarLineas("Historial"+nombreJugador+".txt");
        int ganadas = 0;
        for(int i = 1; i<=lineas; i++){
            if((leerParte(leerLinea("Historial"+nombreJugador+".txt", i), 2).equalsIgnoreCase("Ganada"))){
                ganadas++;
            }
        }
        return ganadas;
    }


}

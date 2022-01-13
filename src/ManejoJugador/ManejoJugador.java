package ManejoJugador;

import static ManejoDatos.ManejoDatos.*;
import domain.Jugador;

public class ManejoJugador {

    /*Aqui hay metodos generales para el manejor de jugadores y su informacion*/

    /*El método Registrar solicita como parámetro un nombre y corrobora si aun no esta
     * registrado en los archivos. En ese caso, escribe su nombre para que ya este registrado
     * y le crea un archivo historial para guardar su progreso de aquí en adelante*/

    public void Registrar(String nombreJugador) throws SobrescrituraExcepcion {
        if(!buscar("Jugadores.txt", nombreJugador)) {
            escribir(nombreJugador, "Jugadores.txt", true);
            crear("Historial"+nombreJugador+".txt");
        }else{
            throw new SobrescrituraExcepcion();
        }
    }
    /*El método Ingresar solicita como parámetro un nombre y corrobora si esta registrado.
     * En ese caso, lo escribe en el archivo JugadorActual.txt*/
    public void Ingresar(String nombreJugador) throws CuentaNulaExcepcion {
        if(buscar("Jugadores.txt", nombreJugador)){
            crear("JugadorActual.txt");
            escribir(nombreJugador, "JugadorActual.txt", false);
        }else{
            throw new CuentaNulaExcepcion();
        }
    }

    /*El método contarPuntos utiliza varios métodos de ManejoDatos para contar los puntos
     * de todas las partidas en el historial de un jugador*/
    public static int contarPuntos(String nombreJugador){
     int lineas = contarLineas("Historial"+nombreJugador+".txt");
     int puntos = 0;
     for(int i = 1; i<=lineas; i++){
         puntos = puntos + Integer.parseInt(leerParte(leerLinea("Historial"+nombreJugador+".txt", i), 3));
     }
     return puntos;
     }

     /*El método contarGanadas utiliza varios métodos de ManejoDatos para contar la cantidad de partidas
     * que el jugador ganó*/
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

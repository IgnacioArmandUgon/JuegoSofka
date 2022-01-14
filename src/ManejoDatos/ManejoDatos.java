package ManejoDatos;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import static java.nio.charset.StandardCharsets.UTF_8;

public class ManejoDatos {
    /*Aqui hay metodos generales para el manejo de datos en los archivos del programa.
     * Todos estos metodos son Static, para poder hacer import static de la clase y asi
     * prescindir de instanciar un objeto para usarlos*/

    public static void crear(String nombreArchivo) {
        String ruta = "data/"+nombreArchivo;
        File archivo = new File(ruta);
        try {
            PrintWriter salida = new PrintWriter(archivo);
            salida.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace(System.out);
        }
    }

    public static boolean existe(String nombreArchivo) {
        String ruta = "data/"+nombreArchivo;
        File archivo = new File(ruta);
        return archivo.exists();
    }

    public static void escribir(String s, String nombreArchivo, boolean anexar) {
        String ruta = "data/"+nombreArchivo;
        File archivo = new File(ruta);
        try {
            PrintWriter salida = new PrintWriter(new FileWriter(archivo, anexar));
            if (!s.equalsIgnoreCase("")) {
                salida.println(s);
            } else {
                System.out.println("Nombre invalido, intente de nuevo");
            }
            salida.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace(System.out);
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }

    }

    public static boolean buscar(String nombreArchivo, String buscar) {
        String ruta = "data/"+nombreArchivo;
        File archivo = new File(ruta);
        boolean existe = false;
        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            String linea = entrada.readLine();
            while (linea != null) {
                if (buscar.equalsIgnoreCase(linea)) {
                    existe = true;
                    break;
                }
                linea = entrada.readLine();
            }
            entrada.close();
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
        return existe;
    }

    public static int contarLineas(String nombreArchivo) {
        String ruta = "data/"+nombreArchivo;
        File archivo = new File(ruta);
        BufferedReader entrada = null;
        try {
            entrada = new BufferedReader(new FileReader(archivo));
            int lineas = 0;
            try {
                String linea = entrada.readLine();
                while (linea != null) {
                    linea = entrada.readLine();
                    lineas++;
                }
                return lineas;
            } catch (IOException e) {
                e.printStackTrace(System.out);
                return 0;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace(System.out);
            return 0;
        }
    }

    /*El método leerParte recibe como parámetro una línea de texto y un índice.
     * En base a unos separadores que hay en los archivos de texto, que en este caso
     * son "xx", el método separa la línea en partes y devuelve la correspondiente
     * al índice solicitado.
     * Ademas, convierte el texto el estandar ISO a el UTF-8 para poder
     *  ver tildes y demas caracteres especiales*/
    public static String leerParte(String s, int index) {
        String[] detalles = s.split("xx");
        return s = new String(detalles[index - 1].getBytes(Charset.forName("ISO-8859-1")), Charset.forName("UTF-8"));
    }

    public static String leerLinea(String nombreArchivo, int index) {
        String ruta = "data/"+nombreArchivo;
        File archivo = new File(ruta);
        BufferedReader entrada = null;
        String linea = null;
        try {
            entrada = new BufferedReader(new FileReader(archivo));
            for (int i = 1; i <= index; i++) {
                linea = entrada.readLine();
            }
            return linea;
        } catch (FileNotFoundException e) {
            e.printStackTrace(System.out);
            return "";
        } catch (IOException e) {
            e.printStackTrace(System.out);
            return "";
        }
    }
}


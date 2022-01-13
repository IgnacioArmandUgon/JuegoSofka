package ManejoDatos;

import java.io.*;

public class ManejoDatos {

    public static void crear(String nombreArchivo){
        File archivo = new File(nombreArchivo);
        try {
            PrintWriter salida = new PrintWriter(archivo);
            salida.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace(System.out);
        }
    }
    public static boolean existe(String nombreArchivo) {
        File archivo = new File(nombreArchivo);
        return archivo.exists();
    }

    public static void escribir(String s, String nombreArchivo, boolean anexar) {
        File archivo = new File(nombreArchivo);
        try {
            PrintWriter salida = new PrintWriter(new FileWriter(archivo, anexar));
            if (!s.equalsIgnoreCase("")) {
                salida.println(s);
            }else{
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
        File archivo = new File(nombreArchivo);
        boolean existe = false;
        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            String linea = entrada.readLine();
            while(linea != null) {
                if(buscar.equalsIgnoreCase(linea)){
                    existe = true;
                    break;
                }
                linea = entrada.readLine();
            }
            entrada.close();
        } catch (IOException e)  {
            e.printStackTrace(System.out);
        }
        return existe;
    }

    public static int contarLineas(String nombreArchivo){
        File archivo = new File(nombreArchivo);
        BufferedReader entrada = null;
        try {
            entrada = new BufferedReader(new FileReader(archivo));
            int lineas = 0;
            try {
                String linea = entrada.readLine();
                while(linea != null){
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

    public static String leerParte(String s, int index) {
        String[] detalles = s.split("xx");
        return detalles[index-1];
    }

    public static String leerLinea(String nombreArchivo, int index){
        File archivo = new File(nombreArchivo);
        BufferedReader entrada = null;
        String linea = null;
        try{
            entrada = new BufferedReader(new FileReader(archivo));
            for(int i = 1; i<=index; i++){
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


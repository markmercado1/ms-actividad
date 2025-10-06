package org.aguzman.pooexcepciones.ejemplo;
import java.io.IOException;

public class Ejercicio2 {
    public static void main(String[] args) {
        try {
            leerArchivo(false);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void leerArchivo(boolean existe) throws IOException {
        if (!existe) {
            throw new IOException("El archivo no existe");
        }
        System.out.println("Archivo leído correctamente");
    }
}
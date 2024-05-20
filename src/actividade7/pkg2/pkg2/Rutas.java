/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package actividade7.pkg2.pkg2;

import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;

/**
 *
 * @author castr
 */
public class Rutas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try (Scanner s = new Scanner(System.in)) {
            String directorio;
            String nombreArchivo;
            System.out.println("Porgrama de información sobre archivos");
            System.out.println("Indica el nombre del archivo a buscar: ");
            nombreArchivo = s.nextLine();
            System.out.println("Indica el directorio en el que se encuentra ese archivo: ");
            directorio = s.nextLine();
            Path ruta = Paths.get(directorio, nombreArchivo);
            File fichero = ruta.toFile();
            try {
                if (fichero.exists()) {
                    System.out.println("Nombre del fichero: " + nombreArchivo);
                    System.out.println("Directorio padre: " + fichero.getParent());
                    System.out.println("Ruta absoluta: " + fichero.getAbsolutePath());
                    System.out.println("Ruta relativa: " + fichero.getPath());

                    String readArchive = new String(Files.readAllBytes(ruta));
                    int contador = 0;

                    for (char letra : readArchive.toCharArray()) {
                        if (letra == 'a' || letra == 'A') {
                            contador++;
                        }
                    }
                    System.out.println("El archivo contiene " + contador + " letras 'a'");
                } else {
                    fichero.createNewFile();
                    System.out.println("Se ha creado el fichero " + nombreArchivo + " en " + directorio);

                }
            } catch (IOException e) {
            }
        }
    }

}

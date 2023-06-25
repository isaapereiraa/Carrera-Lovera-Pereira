/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;
import Estructuras.Hashtable;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author soyis
 */
public class Csv {

    public class EstadoToHash {
        public static void main(String[] args) {
            File file = new File("Estado.csv");
            Hashtable hash = new Hashtable();

            try {
                Scanner scanner = new Scanner(file);
                while (scanner.hasNextLine()) {
                    String[] data = scanner.nextLine().split(",");
                    String key = data[0];
                    Integer value = Integer.valueOf(data[1]);
                    hash.put(key, value);
                }
                scanner.close();
            } catch (FileNotFoundException e) {
                System.out.println("Archivo no encontrado: " + e.getMessage());
            }

            System.out.println("Hashtable: " + hash);
        }
    }

}

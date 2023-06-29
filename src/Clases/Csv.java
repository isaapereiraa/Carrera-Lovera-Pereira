/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;
import Estructuras.ABB;
import Estructuras.ArrayList;
import Estructuras.Hashtable;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *Esta clase se encarga de las lecturas de los archivos csv y de guardar los datos en el hashtable y ABB
 * @author soyis
 */
public class Csv {
    
    
    
    public static void leerEstado(Hashtable<Estado> clientes) throws FileNotFoundException, IOException{
        try (BufferedReader br = new BufferedReader(new FileReader("test\\Estado.csv"))){
            String linea;
            linea = br.readLine();
            while ((linea = br.readLine()) != null){
                String[] datos = linea.split(",");
                int hab = Integer.parseInt(datos[0]);
                String fullname = datos[1] + datos[2];
                String nombre = datos[1];
                String apellido = datos[2];
                String correo = datos[3];
                String genero = datos[4];
                String celular = datos[5];
                String llegada = datos[6];
                Estado estado = new Estado(hab, nombre, apellido, correo, genero, celular, llegada);
                clientes.put(fullname, estado);
                Global.setHash(clientes);

            }
        } catch (IOException e){
            System.out.println("Archivo no encontrado");
        }
    }
    
    public static void leerHabitaciones(ArrayList<Estado> clientes) throws FileNotFoundException, IOException{
        Hashtable hash = new Hashtable();
        try (BufferedReader br = new BufferedReader(new FileReader("test\\Habitaciones.csv"))){
            String linea;
            linea = br.readLine();
            while ((linea = br.readLine()) != null){
                String[] datos = linea.split(",");
                int hab = Integer.parseInt(datos[0]);
                String nombre = datos[1];
                String apellido = datos[2];
                Estado llamada = new Estado(hab, nombre, apellido);
                clientes.add(llamada);
//                hash.put(client, hab);
            }
        } catch (IOException e){
            System.out.println("Archivo no encontrado");
        }
    }
    
    public static void leerHistorico(ArrayList<Estado> clientes) throws FileNotFoundException, IOException{
        Hashtable hash = new Hashtable();
        try (BufferedReader br = new BufferedReader(new FileReader("test\\Historico.csv"))){
            String linea;
            linea = br.readLine();
            while ((linea = br.readLine()) != null){
                String[] datos = linea.split(",");
                int hab = Integer.parseInt(datos[0]);
                String nombre = datos[1];
                String apellido = datos[2];
                Estado llamada = new Estado(hab, nombre, apellido);
                clientes.add(llamada);
                
            }
        } catch (IOException e){
            System.out.println("Archivo no encontrado");
        }
    }
    
    /**
     *
     * @param clientes
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static void leerReservas(ABB clientes) throws FileNotFoundException, IOException{
        
        try (BufferedReader br = new BufferedReader(new FileReader("test\\Reservas.csv"))){
            String linea;
            linea = br.readLine();
            while ((linea = br.readLine()) != null){
                String[] datos = linea.split(",");
                String cedula = datos[0]+datos[1]+datos[2];
                String nombre = datos[3];
                String apellido = datos[4];
                String correo = datos[5];
                String genero = datos[6];
                String tipo_hab = datos[7];
                String celular = datos[8];
                String llegada = datos[9];
                String salida = datos[10];
                Reservas llamada = new Reservas(cedula, nombre, apellido, correo, genero, tipo_hab, celular, llegada, salida);
                
                String keyCedula = llamada.getCedula();
                String num = keyCedula.replaceAll(",", "");
                String numero = Global.removeDoubleQuotes(num);
                int num_cedula = Integer.parseInt(Global.removeDoubleQuotes(numero));
                clientes.insert(num_cedula, llamada);
                Global.setABB(clientes);
             

            }
        } catch (IOException e){
            System.out.println("Archivo no encontrado");
        }
    }
    


}

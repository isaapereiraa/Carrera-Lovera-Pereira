/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;
import Estructuras.ABB;
import Estructuras.Hashtable;
import Estructuras.Nodo;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *Esta clase se encarga de las lecturas de los archivos csv y de guardar los datos en el hashtable y ABB
 * @author  isabella, adrian, alejandra
 */
public class Csv {
    
    
    
    public static void leerEstado(Hashtable<Estado> clientes) throws FileNotFoundException, IOException{
        String filePath = "test" + File.separator + "Estado.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))){
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
                Nodo est = new Nodo(estado);
                clientes.put(fullname, est);
                Global.setHash(clientes);

            }
        } catch (IOException e){
            System.out.println("Archivo no encontrado");
        }
    }
    
    public static void leerHabitaciones(Hashtable <Habitacion> habitacion) throws FileNotFoundException, IOException{
        try (BufferedReader br = new BufferedReader(new FileReader("test\\Habitaciones.csv"))){
            String linea;
            linea = br.readLine();
            while ((linea = br.readLine()) != null){
                String[] datos = linea.split(",");
                int num_hab = Integer.parseInt(datos[0]);
                String tipo_hab = datos[1];
                String piso = datos[2];
                Habitacion habinfo = new Habitacion(num_hab, tipo_hab, piso);
                Nodo hab1 = new Nodo(habinfo);
                habitacion.put(datos[0], hab1);
                Global.setHash(habitacion);
            }
        } catch (IOException e){
            System.out.println("Archivo no encontrado");
        }
    }
     
    public static void leerHistorico(ABB historial) throws FileNotFoundException, IOException{
        String filePath = "test" + File.separator + "Historico.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))){
            String linea;
            // Se lee la primera línea para omitirla, ya que es la cabecera del archivo.
            br.readLine();
            while ((linea = br.readLine()) != null){
                String[] datos = linea.split(",");
                // Se verifica que el arreglo datos tenga al menos 7 elementos antes de acceder a ellos.
                if (datos.length >= 9) {
                    String cedula1 = datos[0].replaceAll("\"", "");
                    String cedula2 = datos[1];
                    String cedula3 = datos[2].replaceAll("\"", "");
                    String cedulaTotal;
                    if(datos.length <=8){
                        cedulaTotal = cedula1 + cedula2;
                    }else{
                        cedulaTotal = cedula1 + cedula2 + cedula3;
                    } 
                    int cedula = Integer.parseInt(cedulaTotal);
                    String nombre = datos[3];
                    String apellido = datos[4];
                    String email = datos[5];
                    String genero = datos[6];
                    String llegada = datos[7];
                    int num_hab = Integer.parseInt(datos[8]);
                    Historico llamada = new Historico(cedula, nombre, apellido, email, genero, llegada, num_hab);
                    historial.insert(cedula, llamada);
                    Global.setAbb1(historial);
                }
            }
        } catch (FileNotFoundException e){
            System.out.println("Archivo no encontrado");
        } catch (IOException e){
            System.out.println("Error al leer el archivo");
        }
    }
    
    /**
     *
     * @param clientes
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static void leerReservas(ABB clientes) throws FileNotFoundException, IOException{
        String filePath = "test" + File.separator + "Reservas.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))){
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

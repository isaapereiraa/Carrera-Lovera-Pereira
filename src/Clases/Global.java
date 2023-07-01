/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;
import Estructuras.Hashtable;
import Estructuras.ABB;

/**
 *Clases y metodos que van a servir a lo largo de todo el proyecto
 * @author  isabella, adrian, alejandra
 */
public class Global {
    private static Hashtable hashtable;
    private static ABB abb;
    
    /**
     * 
     * @return hashtable
     */
    public static Hashtable getHash() {
        return hashtable;
    }
    
    /**
     *  @param hashtable
     */
    public static void setHash(Hashtable hashtable) {
        Global.hashtable = hashtable;
    }
    
    /**
     * 
     * @return ABB
     */
    public static ABB getABB() {
        return abb;
    }
    
    /**
     *  @param abb
     */
    public static void setABB(ABB abb) {
        Global.abb = abb;
    }
    
    /**
     * Verifica si una cadena de texto corresponde al valor de un numero entero
     * @param texto
     * @return 
     */
    public static boolean isNumeric(String texto){
        if (texto == null || texto.length() == 0){
            return false;
        }
        
        try {
            Integer.valueOf(texto);
            return true;
        } catch (NumberFormatException e){
            return false;
        }
    }
    
    /**
     * Elimina las doble comillas de un string 
     * @param input
     * @return 
     */
    public static String removeDoubleQuotes(String input){
        StringBuilder sb = new StringBuilder();
        char[] tab = input.toCharArray();
        for (char current : tab){
            if (current!='"'){
                sb.append(current);
            }
        }
        return sb.toString();
    } 
    
    /**
     * Esta funcion se encarga de capitalizar un string
     * @param palabra
     * @return 
     */
    public static String capitalizar(String palabra) {
    if (palabra == null || palabra.isEmpty()) {
        return palabra;
    } else {
       return palabra.substring(0, 1).toUpperCase() + palabra.substring(1);
    }
    }   
    
    
}

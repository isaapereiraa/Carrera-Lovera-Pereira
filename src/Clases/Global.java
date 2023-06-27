/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;
import Estructuras.Hashtable;

/**
 *
 * @author soyis
 */
public class Global {
    private static Hashtable hashtable;
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
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

import Clases.Estado;
import Clases.Habitacion;

/**
 *Esta clase se encarga de todo lo relacionado a la tabla de dispersion y la implementacion de sus primitivas
 * @author  isabella, adrian, alejandra
 * @param <T>
 * 
 */
public class Hashtable<T> {
    private final int size = 35;
    private final Entry[] table = new Entry[size];


    static class Entry <T> {
        String key;
        Nodo<T> value;
        Entry next;

        /**
         * Constructor
         * @param key
         * @param value 
         */
        public Entry(String key, Nodo <T> value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }

        public void setKey(String key) {
            this.key = key;
        }
        
    }

    /**
     * Agrega objetos a la tabla
     * @param key
     * @param value 
     */
    public void put(String key, Nodo <T> value) {
        int hash = (key.hashCode() & 0x7fffffff) % size;
        Entry entry = table[hash];

        if (entry == null) {
            table[hash] = new Entry(key, value);
        } else {
            while (entry.next != null && !entry.key.equals(key)) {
                entry = entry.next;
            }
            if (entry.key.equals(key)) {
                entry.value = value;
            } else {
                entry.next = new Entry(key, value);
            }
        }
    }

    /**
     * Dada una llave "key", se puede obtener el valor siempre que se encuentre en la tabla
     * @param key
     * @return 
     */
        public Nodo<T> get(String key) {
        int hash = (key.hashCode() & 0x7fffffff) % size;
        Entry entry = table[hash];

        while (entry != null && !entry.key.equals(key)) {
            entry = entry.next;
        }

        if (entry == null) {
            return null;
        } else {
            return entry.value;
        }
    }
      
     /**
     * Retorna una lista con las claves de la tabla hash
     * @return
     */
    public List<T> getKeys() {
        List<T> keys = new List<>();
        
        for (Entry entry : table) {
            while (entry != null) {
                Nodo <Estado> nodo = entry.value ;
                keys.insertLast((T)nodo.getData().getHabitacion());
                entry = entry.next;
            }
        }
        return keys;
    }
    
         /**
     * Retorna una lista con las claves de la tabla hash
     * @param tipo_hab
     * @return
     */
    public List<T> getKeys1(String tipo_hab) {
        List<T> keys = new List<>();
        
        for (Entry entry : table) {
            while (entry != null) {
                
                Nodo <Habitacion> nodo = entry.value ;
                String aux = nodo.getData().getTipo();
                if (aux.equals(tipo_hab)){
                keys.insertLast((T)nodo.getData().getNumero());
                }
                entry = entry.next;
            }
        }
        return keys;
    }
    
    /**
     * Para verificar si una llave se encuentra o no en la tabla
     * @param key
     * @return 
     */
    public boolean containsKey(String key) {
        int hash = (key.hashCode() & 0x7fffffff) % size;
        Entry entry = table[hash];

        while (entry != null && !entry.key.equals(key)) {
            entry = entry.next;
        }

        return entry != null;
    }

    /**
     * Elimina un elemento de la tabla
     * @param key 
     */
    public void remove(String key) {
        int hash = (key.hashCode() & 0x7fffffff) % size;
        Entry entry = table[hash];

        if (entry == null) {
        } else {
            if (entry.key.equals(key)) {
                table[hash] = entry.next;
            } else {
                Entry prev = entry;
                entry = entry.next;
                while (entry != null && !entry.key.equals(key)) {
                    prev = entry;
                    entry = entry.next;
                }
                if (entry == null) {
                } else {
                    prev.next = entry.next;
                }
            }
        }
    }
 
}

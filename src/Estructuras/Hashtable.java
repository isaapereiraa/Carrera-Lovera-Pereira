/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

import Clases.Estado;

/**
 *Esta clase se encarga de todo lo relacionado a la tabla de dispersion y la implementacion de sus primitivas
 * @author  isabella, adrian, alejandra
 * @param <T>
 * 
 */
public class Hashtable<T> {
    private final int size = 35;
    private final Entry[] table = new Entry[size];


    static class Entry {
        String key;
        Estado value;
        Entry next;

        /**
         * Constructor
         * @param key
         * @param value 
         */
        public Entry(String key, Estado value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    /**
     * Agrega objetos a la tabla
     * @param key
     * @param value 
     */
    public void put(String key, Estado value) {
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
    public Estado get(String key) {
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

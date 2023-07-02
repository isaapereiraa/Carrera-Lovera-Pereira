/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

import Clases.Historico;

/**
 *
 * @author  isabella, adrian, alejandra
 */
public class ArrayList <T>{
    private T[] array;
    private int size;
    private int capacity;

    /**
     * Constructor
     */
    public ArrayList() {
        this.array = (T[]) new Object[500];
        this.size = 0;
        this.capacity = 500;
    }

    /**
     * Añade un elemento al final del ArrayList
     * @param element
     */
       public void add(T element) {
       if (size == capacity) {
           extendCapacity();
       }
       array[size] = element;
       size++;
   }
    /**
     * Remueve el elemento en la posición indicada
     * @param index
     */
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        size--;
    }

    /**
     * Retorna el elemento en la posición indicada
     * @param index
     * @return
     */
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return array[index];
    }

    /**
     * Retorna el tamaño del ArrayList
     * @return
     */
    public int size() {
        return size;
    }

    /**
     * Retorna si el ArrayList está vacío o no
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Extiende la capacidad del ArrayList
     */
    private void extendCapacity() {
        T[] newArray = (T[]) new Object[capacity * 2];
        for (int i = 0; i < size; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
        capacity *= 2;
    }

    public String elementsToString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(array[i].toString()).append("\n");
        }
        return sb.toString();
    }

}

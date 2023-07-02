/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *Esta clase maneja el constructor, getters y setters de los datos de las habitaciones
 * @author  isabella, adrian, alejandra
 */
public class Habitacion {
    private int numero;
    private String tipo;
    private String piso;
    
    /**
     * Constructor de la clase Habitacion.
     * 
     * @param numero el número de la habitación.
     * @param tipo el tipo de la habitación.
     * @param piso el piso donde se encuentra la habitación.
     */
    public Habitacion(int numero, String tipo, String piso) {
        this.numero = numero;
        this.tipo = tipo;
        this.piso = piso;
    }

    // Métodos getters
    public Integer getNumero() {
        return numero;
    }

    public String getTipo() {
        return tipo;
    }

    public String getPiso() {
        return piso;
    }
    
    // Métodos setters
    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setPiso(String piso) {
        this.piso = piso;
    }
    
    /**
     * Método que devuelve una cadena con la información de la habitación.
     * 
     * @return una cadena con la información de la habitación.
     */
    public String tohabitacion(){
        return "Numero de habitración: " + this.numero + "\n" + "Tipo habitación: " + this.tipo.toUpperCase() + "\n"+ "Piso: " + this.piso;
    }
    
}

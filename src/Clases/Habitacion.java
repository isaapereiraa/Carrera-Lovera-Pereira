/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *Esta clase maneja el constructor, getters y setters de los datos de las habitaciones
 * @author soyis
 */
public class Habitacion {
    private String numero;
    private String tipo;
    private String piso;

    public Habitacion(String numero, String tipo, String piso) {
        this.numero = numero;
        this.tipo = tipo;
        this.piso = piso;
    }

    public String getNumero() {
        return numero;
    }

    public String getTipo() {
        return tipo;
    }

    public String getPiso() {
        return piso;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setPiso(String piso) {
        this.piso = piso;
    }
    
    
}
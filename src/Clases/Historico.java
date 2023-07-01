/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *Esta clase maneja el constructor, getters y setters de los datos del historico
 * @author  isabella, adrian, alejandra
 */
public class Historico {
    private String cedula;
    private String nombre;
    private String apellido;
    private String correo;
    private String genero;
    private String llegada;
    private Integer num_hab;

    public Historico(String cedula, String nombre, String apellido, String correo, String genero, String llegada, Integer num_hab) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.genero = genero;
        this.llegada = llegada;
        this.num_hab = num_hab;
    }

    public String getCedula() {
        return cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public String getGenero() {
        return genero;
    }

    public String getLlegada() {
        return llegada;
    }

    public Integer getNum_hab() {
        return num_hab;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setLlegada(String llegada) {
        this.llegada = llegada;
    }

    public void setNum_hab(Integer num_hab) {
        this.num_hab = num_hab;
    }
    

    public String toString() {
        return "Cédula: " + cedula + ", Nombre: " + nombre + ", Apellido: " + apellido + ", Correo: " + correo + ", Género: " + genero + ", Fecha de llegada: " + llegada + ", Número de habitación: " + num_hab;
    }
}

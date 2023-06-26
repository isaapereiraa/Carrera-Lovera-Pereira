/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *Esta clase maneja el constructor, getters y setters de los datos del estado
 * @author soyis
 */
public class Estado {
   
    private Integer habitacion;
    private String nombre;
    private String apellido;
    private String correo;
    private String genero;
    private String celular;
    private String llegada; 

    
    public Estado(Integer habitacion, String nombre, String apellido, String correo, String genero, String celular, String llegada) {
        this.habitacion = habitacion;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.genero = genero;
        this.celular = celular;
        this.llegada = llegada;
    }

    Estado(int habitacion, String nombre, String apellido) {
        this.habitacion = habitacion;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public void setHabitacion(Integer habitacion) {
        this.habitacion = habitacion;
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

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public void setLlegada(String llegada) {
        this.llegada = llegada;
    }

    public Integer getHabitacion() {
        return habitacion;
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

    public String getCelular() {
        return celular;
    }

    public String getLlegada() {
        return llegada;
    }

    
    public String toCsv(){
        return this.habitacion + "," + this.nombre + "," + this.apellido + "," + this.correo + "," + this.genero + "," + this.celular + "," + this.llegada;
    }

    
}

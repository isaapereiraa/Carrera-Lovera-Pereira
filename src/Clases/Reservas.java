/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *Esta clase maneja el constructor, getters y setters de los datos de las reservas
 * @author soyis
 */
public class Reservas {
    private String cedula;
    private String nombre;
    private String apellido;
    private String correo;
    private String genero;
    private String tipo_hab;
    private String celular;
    private String llegada;
    private String salida;
    
     public Reservas(String cedula, String nombre, String apellido, String correo, String genero, String tipo_hab, String celular, String llegada, String salida) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.genero = genero;
        this.tipo_hab = tipo_hab;
        this.celular = celular;
        this.llegada = llegada;
        this.salida = salida;
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

    public void setTipo_hab(String tipo_hab) {
        this.tipo_hab = tipo_hab;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public void setLlegada(String llegada) {
        this.llegada = llegada;
    }

    public void setSalida(String salida) {
        this.salida = salida;
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

    public String getTipo_hab() {
        return tipo_hab;
    }

    public String getCelular() {
        return celular;
    }

    public String getLlegada() {
        return llegada;
    }

    public String getSalida() {
        return salida;
    }
    
    public String toReservas(){
        return "C.I: " +this.cedula+"\n" + "Nombre: " +this.nombre+"\n" + "Apellido: " +this.apellido+"\n" + "Correo: " +this.correo+"\n" + "Genero: " +this.genero+"\n" + "Tipo de habitación: " +this.tipo_hab+"\n"+ "Celular: " +this.celular+"\n" + "Llegada: " +this.llegada + "Salida: " +this.salida;
    }
}

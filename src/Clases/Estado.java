/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *Esta clase maneja el constructor, getters y setters de los datos del estado
 * @author  isabella, adrian, alejandra
 */
public class Estado {
   
    private Integer habitacion;
    private String nombre;
    private String apellido;
    private String correo;
    private String genero;
    private String celular;
    private String llegada; 
    
    /**
     * Constructor de la clase Estado.
     * 
     * @param habitacion el número de la habitación.
     * @param nombre el nombre del cliente.
     * @param apellido el apellido del cliente.
     * @param correo el correo electrónico del cliente.
     * @param genero el género del cliente.
     * @param celular el número de celular del cliente.
     * @param llegada la fecha de llegada del cliente.
     */
    public Estado(Integer habitacion, String nombre, String apellido, String correo, String genero, String celular, String llegada) {
        this.habitacion = habitacion;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.genero = genero;
        this.celular = celular;
        this.llegada = llegada;
    }

    // Métodos setters
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
    
    // Métodos getters
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

    /**
     * Método que devuelve una cadena con la información del estado.
     * 
     * @return una cadena con la información del estado.
     */
    public String toEstado(){
        return "Numero de habitacion: " +this.habitacion+"\n" + "Nombre: " +this.nombre+"\n" + "Apellido: " +this.apellido+"\n" + "Correo: " +this.correo+"\n" + "Genero: " +this.genero+"\n" + "Celular: " +this.celular+"\n" + "Llegada: " +this.llegada;
    }
    
}

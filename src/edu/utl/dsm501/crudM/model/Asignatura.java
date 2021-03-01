/**
 * NOMBRE DEL AUTOR: JONATHAN ULISES SANCHEZ PARRA
 * FECHA DE  CRACION: 27 - 02 - 2021
 * DESCRIPCION: CONEXION DE BASE DE DATOS CON MONGODB
 */
package edu.utl.dsm501.crudM.model;

import java.util.List;

public class Asignatura {
    
    
    private String nombre;
    private String maestro;
    private List<String> tareas;

    public Asignatura() {
    }

    public Asignatura(String nombre, String maestro, List<String> tareas) {
        this.nombre = nombre;
        this.maestro = maestro;
        this.tareas = tareas;
    }
    
    //GETTER

    public String getNombre() {
        return nombre;
    }

    public String getMaestro() {
        return maestro;
    }

    public List<String> getTareas() {
        return tareas;
    }

    
    //SETTER

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setMaestro(String maestro) {
        this.maestro = maestro;
    }

    public void setTareas(List<String> tareas) {
        this.tareas = tareas;
    }

    @Override
    public String toString() {
        return "Asignatura{" + "nombre=" + nombre + ", maestro=" + maestro + ", tareas=" + tareas + '}';
    }
    
    

    
    
}

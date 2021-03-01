/**
 * NOMBRE DEL AUTOR: JONATHAN ULISES SANCHEZ PARRA
 * FECHA DE  CRACION: 27 - 02 - 2021
 * DESCRIPCION: CONEXION DE BASE DE DATOS CON MONGODB
 */
package crudmongodb;

import edu.utl.dsm501.crudM.controller.ControlAsignatura;
import java.util.List;
import edu.utl.dsm501.crudM.model.Asignatura;
import java.util.ArrayList;
import java.util.Scanner;

public class CRUDMongoDB {
    
    static ControlAsignatura objCAsig = new ControlAsignatura();
    static List<Asignatura> listA = new ArrayList<>();
    static Asignatura objAsig;
    static Scanner sc = new Scanner(System.in);
    static List<String> tareas;
    
    public static void main(String[] args) {
        
//        mostrar();
//        mostrarConsulta();
//        insert();
//        update();
        delete();
        
    }
    
    public static void mostrar(){
        listA = objCAsig.getAll();
        
        listA.forEach((a) -> {
            System.out.println(a.getNombre() + " , " + a.getMaestro() + " , " + a.getTareas());
        });
    }
    
    public static void mostrarConsulta(){
        listA = objCAsig.getAsignatura();
        
        listA.forEach((a) -> {
            System.out.println(a.getNombre() + " , " + a.getMaestro() + " , " + a.getTareas());
        });
    }
    
    public static void insert(){
        objAsig = new Asignatura();
//        String tarea = null;
        tareas = new ArrayList<>();
        tareas.add("Curriculum");
        tareas.add("Grupo de discucion");
        tareas.add("Argumento");
        
        objAsig.setNombre("Expresion oral y escrita II");
        objAsig.setMaestro("Gerardo Bustamante Alonso");
        objAsig.setTareas(tareas);
        
        objCAsig.insert(objAsig);
//        tareas = new ArrayList<>();
//        
//        System.out.print("Inserte el nombre de materia: ");
//        objAsig.setNombre(sc.next());
//        System.out.print("Inserte el nombre del maestro: ");
//        objAsig.setMaestro(sc.next());
//        
//        
//        do {
//            System.out.println("Inserte las tareas (Escriba 0 para salir): ");
//            tarea = sc.next();
//            tareas.add(tarea);
//        } while (!sc.next().equals("0"));
//        objAsig.setTareas(tareas);
//        
//        System.out.println(objAsig.toString());
        
        
    }
    
    public static void update(){
        objAsig = new Asignatura();
//        String tarea = null;
        tareas = new ArrayList<>();
        tareas.add("Curriculum");
        tareas.add("Grupo de discucion");
        tareas.add("Argumento");
        
        objAsig.setNombre("Español Avanzado");
        objAsig.setMaestro("Gerardo Bustamante Alonso");
        objAsig.setTareas(tareas);
        
        objCAsig.update(objAsig);
    }
    
    public static void delete(){
        objCAsig.delete("603c6593d6feb42bf24f110c");
    }
    
}

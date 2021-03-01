/**
 * NOMBRE DEL AUTOR: JONATHAN ULISES SANCHEZ PARRA
 * FECHA DE  CRACION: 27 - 02 - 2021
 * DESCRIPCION: CONEXION DE BASE DE DATOS CON MONGODB
 */
package edu.utl.dsm501.crudM.controller;

import com.google.gson.Gson;
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoException;
import edu.utl.dsm501.crudM.data.Conexion;
import edu.utl.dsm501.crudM.model.Asignatura;
import java.util.ArrayList;
import java.util.List;
import org.bson.types.ObjectId;

public class ControlAsignatura {

    Conexion objConn = new Conexion();

    Gson gson = new Gson();

    private final String COLECCION = "Asignaturas";

    public List getAll() {
        try {
            DBCollection objCollection;

            objCollection = objConn.conectar(COLECCION);

            DBCursor cursor = objCollection.find();

            List<Asignatura> asignaturas = new ArrayList<>();

            while (cursor.hasNext()) {
                Asignatura a = new Asignatura();

                a = gson.fromJson(cursor.next().toString(), Asignatura.class);

                asignaturas.add(a);
            }

            objConn.cerrarConexion();

            return asignaturas;
        } catch (MongoException e) {
            e.printStackTrace();

            objConn.cerrarConexion();

            return null;
        }
    }

    public List getAsignatura() {
        try {
            DBCollection objCollection;

            objCollection = objConn.conectar(COLECCION);

            DBObject query = new BasicDBObject("maestro", "Ismael García Rangel");

            DBCursor cursor = objCollection.find(query);

            List<Asignatura> asignaturas = new ArrayList<>();

            while (cursor.hasNext()) {
                Asignatura a = new Asignatura();

                a = gson.fromJson(cursor.next().toString(), Asignatura.class);

                asignaturas.add(a);
            }

            objConn.cerrarConexion();

            return asignaturas;
        } catch (MongoException e) {
            e.printStackTrace();

            objConn.cerrarConexion();

            return null;
        }
    }

    public void insert(Asignatura a) {
        try {
            DBCollection objCollection;

            objCollection = objConn.conectar(COLECCION);

            BasicDBObject dbObjAsignatura = new BasicDBObject();

            dbObjAsignatura.append("nombre", a.getNombre());
            dbObjAsignatura.append("maestro", a.getMaestro());
            dbObjAsignatura.append("tareas", a.getTareas());

            objCollection.insert(dbObjAsignatura);

            objConn.cerrarConexion();

            System.out.println("Registro Realizado.........");
        } catch (MongoException e) {
            e.printStackTrace();

            objConn.cerrarConexion();
        }
    }

    public void update(Asignatura a) {
        try {
            DBCollection objCollection;

            objCollection = objConn.conectar(COLECCION);

            BasicDBObject dbObjUpdateA = new BasicDBObject();

            dbObjUpdateA.append("nombre", a.getNombre());
            dbObjUpdateA.append("maestro", a.getMaestro());
            dbObjUpdateA.append("tareas", a.getTareas());

            DBObject update = dbObjUpdateA;

            DBObject find = new BasicDBObject("_id", new ObjectId("603c6593d6feb42bf24f110c"));

            objCollection.update(find, update, false, false);

            objConn.cerrarConexion();

            System.out.println("Modificacion realizada");

            objConn.cerrarConexion();

        } catch (MongoException e) {
            e.printStackTrace();

            objConn.cerrarConexion();
        }
    }

    public void delete(String id) {
        try {
            DBCollection objCollection;

            objCollection = objConn.conectar(COLECCION);

            DBObject find = new BasicDBObject("_id", new ObjectId(id));

            objCollection.remove(find);
            
            objConn.cerrarConexion();
            
            System.out.println("Eliminacion exitosa");

        } catch (Exception e) {
            e.printStackTrace();
            objConn.cerrarConexion();
        }
    }
}

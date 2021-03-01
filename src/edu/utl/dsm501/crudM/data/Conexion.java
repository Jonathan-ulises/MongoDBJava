/**
 * NOMBRE DEL AUTOR: JONATHAN ULISES SANCHEZ PARRA
 * FECHA DE  CRACION: 27 - 02 - 2021
 * DESCRIPCION: CONEXION DE BASE DE DATOS CON MONGODB
 */
package edu.utl.dsm501.crudM.data;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;

public class Conexion {
    
    MongoClient objMongoCl;
    DB db;
    DBCollection objCollection;
    
    /**
     * Metodo para conectar con mongo. Devuelve la conexion para poder realizar
     * las operaciones desde el controlador ya que devuelve la colleccion
     * con la que trabajaremos.
     * 
     * @param collection
     * @return 
     */
    public DBCollection conectar(String collection){
        
        try {
            //Conexion al server MongoDB estableciendo el host y el puerto:
            objMongoCl = new MongoClient("localhost", 27017);
            
            //Obtener a la base de datos de mongo, la conexion a la base de datos:
            db = objMongoCl.getDB("coneccionJava");
            
            //Se optiene la coleccion con la que se trabajara:
            objCollection = db.getCollection(collection);
            
            //Retorna la coleccion a utilizar:
            return objCollection;
            
        } catch (MongoException e) {
            System.out.println(e.getMessage());
            
            return null;
        }
    }
    
    /**
     * Cierra la conexion.
     */
    public void cerrarConexion(){
        try {
            objMongoCl.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Josechavez
 */
public class alquilacion_habitacion {
        private Connection conn;
    public void realizaConexion(){
        conn = null;
        String urlDatabase =  "jdbc:postgresql://localhost:5432/la_sede";
        try {
        Class.forName("org.postgresql.Driver");
        conn = DriverManager.getConnection(urlDatabase,  "postgres", "q4xnkvc1");
        } catch (ClassNotFoundException | SQLException e) {
        System.out.println("Ocurrio un error : "+e.getMessage());
        }
    }
       
   public ArrayList<String> diponible(){
       ArrayList<String> lista= new ArrayList();
       try{
           Statement stmt = conn.createStatement();
           String sql ="SELECT h.numero_habitacion , d.tipo ,d.precio	"
                   + "FROM public.habitacion h	"
                   + "inner join public.des_habitacion d on h.tipo=d.tipoid	"
                   + "inner join public.sensor s	"
                   + "on h.idsensor=s.idsensor "
                   + "and s.estado=true	 ;";
           ResultSet respueta = stmt.executeQuery(sql);
           while(respueta.next() && respueta.getString(1) != null){
               String devolver =respueta.getString(1)+","+respueta.getString(2)+","+respueta.getString(3);
               lista.add(devolver);
           }
       }catch(Exception e){
       
       }
       return lista;
   } 
}

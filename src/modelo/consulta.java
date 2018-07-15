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
import java.util.logging.Level;
import java.util.logging.Logger;
import objetos.usuarios;

/**
 *
 * @author Josechavez
 */
public class consulta {
    
private Connection conn;

    public consulta() {
    }
      

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
    public ArrayList<usuarios> TraerEmpleado(int idrol){
    ArrayList<usuarios> devolver=new ArrayList<>();
    try {
        Statement stmt = conn.createStatement(); 
        ResultSet rs = stmt.executeQuery("select * from usuarios where idrol ="+idrol+";");
        while(rs.next()){
            usuarios lista = new usuarios(rs.getInt(1),rs.getString(2),rs.getString(7),rs.getString(3),rs.getInt(4),rs.getInt(5),rs.getString(6));
            devolver.add(lista);
            
        }
        
    } catch (SQLException ex) {
        Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
    }
    return devolver;
    
}
        public ArrayList<usuarios> TraerUsuarios(int idrol,int idrol2){
    ArrayList<usuarios> devolver=new ArrayList<>();
    try {
        Statement stmt = conn.createStatement(); 
        ResultSet rs = stmt.executeQuery("select * from usuarios where idrol ="+idrol+" and idrol ="+idrol2+" ;");
        while(rs.next()){
            usuarios lista = new usuarios(rs.getInt(1),rs.getString(2),rs.getString(7),rs.getString(3),rs.getInt(4),rs.getInt(5),rs.getString(6));
            devolver.add(lista);
            
        }
        
    } catch (SQLException ex) {
        Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
    }
    return devolver;
    
}

}

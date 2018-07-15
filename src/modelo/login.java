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
import java.util.logging.Level;
import java.util.logging.Logger;
import objetos.loginObjetos;
import objetos.usuarios;
/**
 *
 * @author User
 */
public class login {
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
public loginObjetos logiarce(String user,String pass){
    loginObjetos devolver;
    try {
        Statement stmt = conn.createStatement(); 
        ResultSet rs = stmt.executeQuery("SELECT * from buscar_usuario('"+user+"','"+pass+"');");
        if(rs.next() && rs.getObject(1)!=null){
            devolver = new loginObjetos(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getBoolean(4));
            return devolver;
        }
    } catch (SQLException ex) {
        Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
    }
    return null;
}

public usuarios traerUsuario(int id){
    usuarios devolver;
    try {
        Statement stmt = conn.createStatement(); 
        ResultSet rs = stmt.executeQuery("select * from usuarios where idusuario_empleado ="+id+";");
        if(rs.next() && rs.getObject(1)!=null){
            devolver = new usuarios(rs.getInt(1),rs.getString(2),rs.getString(7),rs.getString(3),rs.getInt(4),rs.getInt(5),rs.getString(6));
            return devolver;
        }
    } catch (SQLException ex) {
        Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
    }
    return null;
    
}
public String TraerNombreRolUsuario(int id){
    String devolver;
    try {
        Statement stmt = conn.createStatement(); 
        ResultSet rs = stmt.executeQuery("select nombre from roles where idroles="+id+";");
        if(rs.next() && rs.getObject(1)!=null){
            
            devolver =rs.getString(1);
            return devolver;
        }
    } catch (SQLException ex) {
        Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
    }
    return null;

}
public int TraerRolUsuario(int id){
    int devolver = 0;
    try {
        Statement stmt = conn.createStatement(); 
        ResultSet rs = stmt.executeQuery("select idrol from usuarios where idusuario_empleado="+id+";");
        if(rs.next() && rs.getObject(1)!=null){
            
            devolver =rs.getInt(1);
            return devolver;
        }
    } catch (SQLException ex) {
        Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
    }
    return devolver;

}
public int TraerRolUsuarioCedula(int id){
    int devolver = 0;
    try {
        Statement stmt = conn.createStatement(); 
        ResultSet rs = stmt.executeQuery("select idrol from usuarios where cedula="+id+";");
        if(rs.next() && rs.getObject(1)!=null){
            
            devolver =rs.getInt(1);
            return devolver;
        }
    } catch (SQLException ex) {
        Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
    }
    return devolver;

}


public usuarios traerUsuarioCedula(int id){
    usuarios devolver;
    try {
        Statement stmt = conn.createStatement(); 
        ResultSet rs = stmt.executeQuery("select * from usuarios where cedula ="+id+";");
        if(rs.next() && rs.getObject(1)!=null){
            devolver = new usuarios(rs.getInt(1),rs.getString(2),rs.getString(7),rs.getString(3),rs.getInt(4),rs.getInt(5),rs.getString(6));
           
            return devolver;
        }
    } catch (SQLException ex) {
        Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
    }
    return null;
    
}
public loginObjetos UsuarioLogin(int id){
    loginObjetos devolver;
    try {
        Statement stmt = conn.createStatement(); 
        ResultSet rs = stmt.executeQuery("select * from login where idusuario="+id+";");
        if(rs.next() && rs.getObject(1)!=null){
            devolver =new loginObjetos(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getBoolean(4));
            return devolver;
        }
    } catch (SQLException ex) {
        Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
    }
    return null;

}

  



}


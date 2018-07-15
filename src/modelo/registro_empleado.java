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
import objetos.loginObjetos;
import objetos.usuarios;

/**
 *
 * @author User
 */
public class registro_empleado {
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
    
    public void guardar_empleado(usuarios n1, loginObjetos n2, String contra){
        try{
            Statement stmt = conn.createStatement(); 
            String sql1 = "SELECT public.agregar_usuario('"
                    + n1.getNombre()+"','"
                    + n1.getApellido()+"','"
                    + n1.getTelefono()+"',"
                    + n1.getCedula()+","
                    + n1.getIdrol()+",'"+n1.getCorreo()+"');";
            String sql2 ="UPDATE public.login SET \"contraseña\"='"+contra+"'" 
                    + "WHERE usuario='"+n1.getCedula()+"';";
            String sql3="INSERT INTO public.registros(idusuario, actividad, descripcion, fecha)VALUES ("
                    + n2.getId()+", "
                    + "'Crear empleado', "
                    + "'El cliente ha creado un nuevo empleado', "
                    + "current_timestamp);";
            stmt.executeQuery(sql1);
            stmt.executeUpdate(sql2);
            stmt.execute(sql3);
        }catch (SQLException ex) {
        
        Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
    }    
    }
    
    public String Buscar_por_cedula(String cedula){
       try{
           Statement stmt = conn.createStatement(); 
           String sql1 = "SELECT usuarios.idusuario_empleado, usuarios.nombre, usuarios.cedula\n" 
                   +"FROM usuarios INNER JOIN login \n" 
                   +"ON usuarios.idrol=3 and login.idusuario = usuarios.idusuario_empleado "
                   + "and login.visible=true and usuarios.cedula ="+cedula+" ;";
           ResultSet respueta = stmt.executeQuery(sql1);
           if(respueta.next() && respueta.getString(2) != null){
               String devolver =respueta.getInt(1)+","+respueta.getString(2)+","+respueta.getString(3);
               return devolver;
           }
       }catch (SQLException ex) {
       Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
   }
       return null;
   }
    
    public String Buscar_por_cedula2(String cedula){
       try{
           Statement stmt = conn.createStatement(); 
           String sql1 = "SELECT usuarios.idusuario_empleado, usuarios.nombre, usuarios.cedula\n" 
                   +"FROM usuarios INNER JOIN login \n" 
                   +"ON login.idusuario = usuarios.idusuario_empleado "
                   + "and login.visible=true and usuarios.cedula ="+cedula+" ;";
           ResultSet respueta = stmt.executeQuery(sql1);
           if(respueta.next() && respueta.getString(2) != null){
               String devolver =respueta.getInt(1)+","+respueta.getString(2)+","+respueta.getString(3);
               return devolver;
           }
       }catch (SQLException ex) {
       Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
   }
       return null;
   }
   
    public boolean elimanar_empleado(int id){
       try{
           Statement stmt = conn.createStatement(); 
           String sql1 = "UPDATE public.login SET visible=false WHERE idusuario="+id+";";
           stmt.executeUpdate(sql1);
           return true;
       }catch (SQLException ex) {
       Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
       return false;
   }
   }
  
   public void actualizar_empleado(int id,String nombre,String apellido,int cedula,String telefono,String correo,String contraseña){
       try {
           Statement stmt = conn.createStatement(); 
           String sql1 = "UPDATE public.usuarios "
                   + "SET nombre='"+nombre+"', telefono='"+telefono+"', cedula="+cedula+", "
                   + "correo='"+correo+"', apellido='"+apellido+"' WHERE idusuario_empleado="+id+";";
           String sql2="UPDATE public.login SET usuario="+cedula+", \"contraseña\"="+contraseña+" WHERE idusuario="+id+";";
           stmt.executeUpdate(sql1);
           stmt.executeUpdate(sql2);
       } catch (Exception e) {
           System.out.println("Error");
       }
   }
   
   public ArrayList<String> devolverEmpleado(){
       ArrayList<String> lista= new ArrayList();
       try{
           Statement stmt = conn.createStatement();
           String sql ="SELECT nombre, apellido, telefono, cedula, correo " +
           "FROM public.usuarios where idrol=3;";
           ResultSet respueta = stmt.executeQuery(sql);
           while(respueta.next() && respueta.getString(1) != null){
               String devolver =respueta.getString(1)+","+respueta.getString(2)+","+respueta.getString(4)+","
                       +respueta.getString(3)+","+respueta.getString(5);
               lista.add(devolver);
           }
       }catch(Exception e){
       
       }
       return lista;
   } 
   
}

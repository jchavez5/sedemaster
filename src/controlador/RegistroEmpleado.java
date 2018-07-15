/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import static controlador.ventana_administrador.usu;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import modelo.registro_empleado;
import objetos.loginObjetos;
import objetos.usuarios;

/**
 *
 * @author Josechavez
 */
public class RegistroEmpleado {
    Controlador c=new Controlador();
    registro_empleado registro=new registro_empleado();
    int id;
    int cedula;
    public RegistroEmpleado() {
    }
    public void buscarCedula(JTextField txt,JTextField nombre,JTextField apellido,
            JTextField cedula,JTextField telefono,JTextField correo,JLabel loge,JLabel contraseña,JPanel panel,
            JTextField txtA,JPanel guardar,JPanel modificar,JPanel modifica){
        modelo.login logeo =new modelo.login();
         //al iniciar bd
        logeo.realizaConexion();

         int cedulaBusqueda=Integer.parseInt(txt.getText());
         
              int rolDelLogin= usu.getIdrol();
        
        if (logeo.TraerRolUsuarioCedula(cedulaBusqueda)==2&&rolDelLogin==2) {
                c.mensajeBusquedaNoSePuede();
            return;
        }
        if (logeo.TraerRolUsuarioCedula(cedulaBusqueda)==1) {
            c.mensajeBusquedaNoEncontrado();
            return;
        }else{
                     
        usuarios lista=logeo.traerUsuarioCedula(Integer.parseInt(txt.getText().toString()));
        
        if (lista!=null) {
        nombre.setText(lista.getNombre());
        apellido.setText(lista.getApellido());
        cedula.setText(String.valueOf(lista.getCedula()));
        telefono.setText(lista.getTelefono());
        correo.setText(lista.getCorreo());
        loginObjetos listaLogin=logeo.UsuarioLogin(lista.getId());
        loge.setText(listaLogin.getUsuario());
        contraseña.setText(listaLogin.getContraseña());
        panel.setVisible(true);
        txtA.setEnabled(false);
        c.mensajeBusqueda();
        this.id = lista.getId();
        this.cedula = lista.getCedula();
        
        SetVisible(new JPanel[]{guardar},false);
        SetVisible(new JPanel[]{modifica,modificar},true);
        }else{
            c.mensajeBusquedaNoEncontrado();
        }   
              }
                  
        
    }
    public void guardarEmpleado(JTextField txtnombre,JTextField txtapellido, JTextField txtcedula,
            JTextField txttelefono, JTextField txtcorreo,JLabel txtusuario,JLabel txtcontraseña,JPanel panel) {
         String nombre=txtnombre.getText();
         String apellido=txtapellido.getText();
         int cedula=Integer.parseInt(txtcedula.getText());
         String telefono=txttelefono.getText();
         String correo=txtcorreo.getText();
         //al iniciar bd
        modelo.login logeo =new modelo.login();
        logeo.realizaConexion();
        //busqueda de la cedula si existe
        usuarios busqueda = logeo.traerUsuarioCedula(cedula);
        if (busqueda!=null) {
            c.cedulaEncotrada();
            return; 
        }else{
              int rolDelLogin= usu.getIdrol();
              int rol=1;
              //System.out.println("crea: "+rol);
              if (rolDelLogin==1) {
                rol=2;
            }else{
                rol=3;
              }
             // System.out.println("el crea un:"+rol);
             // guardar la persona
           c.GenerarLogin(txtcedula, txtusuario, txtcontraseña);
           panel.setVisible(true);
           usuarios auxusu=new usuarios(0,nombre, apellido, telefono, cedula, rol, correo);
           registro.realizaConexion();
           registro.guardar_empleado(auxusu, controlador.ventana_administrador.usuario, txtcontraseña.getText());
           c.mensajeGuardadoExitoso();
        }


         
    }
    public  void SetVisible(JPanel[] Panel,boolean b ){
     for (int i = 0; i < Panel.length; i++) {
            Panel[i].setVisible(b);
        }
    }
   public void modificar(String nombre,String apellido,int cedula,String telefono,String correo,String contraseña){
        registro_empleado regEmp = new registro_empleado();
        regEmp.realizaConexion();
        System.out.println(cedula+"---"+this.cedula);
        if(cedula != this.cedula){
            String respuesta =regEmp.Buscar_por_cedula2(cedula+"");
            System.out.println(respuesta+"------------");
            if(respuesta!=null){
                JOptionPane.showMessageDialog(null, "!No se puede hacer la modificacion¡ \nCedula ya registrada.");
                return;
            }
        }
        regEmp.actualizar_empleado(this.id, nombre, apellido, cedula, telefono, correo, contraseña);
        JOptionPane.showMessageDialog(null, "Empleado Actualizado");
   }
   public int buscarConRolesIguales(int id){
         modelo.login logeo = new modelo.login();
        logeo.realizaConexion();
        if (logeo.TraerRolUsuarioCedula(id)==2) {
           return 2;
       }
        return 0;
   }
}

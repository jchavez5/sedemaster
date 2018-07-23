/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.Color;
import java.beans.PropertyVetoException;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import modelo.alquilacion_habitacion;
import modelo.registro_empleado;
import objetos.PasswordGenerator;
import vista.login;

/**
 *
 * @author Josechavez
 */
public class Controlador {

    private login view;

    public Controlador() {
    }

    public Controlador(login view) {
        this.view = view;
    }

    public void iniciar() {
        view.setLocationRelativeTo(null);
    }

    public void cerrar() {
        System.exit(0);

    }

    public void setColor(JPanel pane, JPanel Sdpane, JLabel label) {
        label.setForeground(new Color(255, 82, 82));
        pane.setBackground(new Color(207, 216, 220));
        Sdpane.setBackground(new Color(255, 82, 82));

    }

    public void resetColorLabel(JLabel[] label) {
        for (int i = 0; i < label.length; i++) {
            label[i].setForeground(new Color(255, 255, 255));
        }
    }

    public void resetColorJPanel(JPanel[] pane) {
        for (int i = 0; i < pane.length; i++) {
            pane[i].setBackground(new Color(69, 90, 100));
        }
    }

    public void efectoQuitarColorSalir(JPanel panelPrincipal) {
        panelPrincipal.setBackground(new Color(244, 67, 54));
    }

    public void efectoColocarColor(JPanel panelPrincipal) {
        panelPrincipal.setBackground(new Color(255,82,82));
    }

    public void mostrar(JDesktopPane mostrar, JInternalFrame x) {

        mostrar.add(x);
        x.show();
        try {
            x.setMaximum(true);
            x.setUI(null);
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
    }

    public void efectoColorButton(JButton panelPrincipal) {
        panelPrincipal.setBackground(new Color(150, 40, 27));
    }

    public void efectoQuitarColorbotton(JButton panelPrincipal) {
        panelPrincipal.setBackground(new Color(244, 67, 54));
    }
//////////////// movimiento del mouse menu lateral

    public void setColorMovimiento(JPanel pane, JPanel Sdpane, JLabel label) {

        label.setForeground(new Color(255, 82, 82));
        pane.setBackground(new Color(207,216,220));
        Sdpane.setBackground(new Color(207,216,220));

    }

    public void resetColorMovimiento(JPanel pane, JPanel Sdpane, JLabel label) {
        label.setForeground(new Color(222, 222, 222));
        pane.setBackground(new Color(69, 90, 100));
        Sdpane.setBackground(new Color(69, 90, 100));

    }
    public boolean AcInicio = false, AcVenta = false, AcMov = false, AcCons = false, AcRepo = false, AcCrea = false;

    public void activar(boolean inicio, boolean venta, boolean movi, boolean consu, boolean repor, boolean crear) {
        AcInicio = inicio;
        AcVenta = venta;
        AcMov = movi;
        AcCons = consu;
        AcRepo = repor;
        AcCrea = crear;
    }

    public void efectoColorButtonlogin(JPanel panelPrincipal) {
        panelPrincipal.setBackground(new Color(207, 216, 220));
    }

    public void efectoQuitarColorbottonlogin(JPanel panelPrincipal) {
        panelPrincipal.setBackground(new Color(189, 189, 189));
    }

    public void efectoQuitarColorbottonloginN(JButton panelPrincipal) {
        panelPrincipal.setBackground(new Color(255,82,82));
    }

    public void efectoQuitarColorbottonloginn(JButton panelPrincipal) {
        panelPrincipal.setBackground(new Color(189, 189, 189));
    }
    ///////movimiento del mouse lbl -> botones diseño nuevo

    public void EfectoLabel(JPanel panel, JLabel label) {
        panel.setBackground(new Color(69, 90, 100));
        label.setForeground(new Color(255, 255, 255));
    }

    public void EfectoQuitarLabel(JPanel panel, JLabel label) {
        panel.setBackground(new Color(255, 255, 255));
        label.setForeground(new Color(255, 82, 82));
    }

    public void visibleFalseJpanel(JPanel[] pane) {
        for (int i = 0; i < pane.length; i++) {
            pane[i].setVisible(false);
        }
    }
    //generador de el login
public void GenerarLogin(JTextField cedula,JLabel result,JLabel resultaContraseña){
    String n =cedula.getText();
     result.setText(n);
     resultaContraseña.setText(PasswordGenerator.getPassword(
		PasswordGenerator.MINUSCULAS+
		PasswordGenerator.ESPECIALES,6));
  
    }
//validaciones 
public  boolean vacio(JTextField[] txt ){
     for (int i = 0; i < txt.length; i++) {
            if(txt[i].getText().toString().equals("")){
                 return false;
            }
         }
     return true;
}
//setiar
public  void setiarCaja(JTextField[] txt ){
     for (int i = 0; i < txt.length; i++) {
            txt[i].setText("");
            }
         }
public  void setiarCajaEnableTrue(JTextField[] txt ){
     for (int i = 0; i < txt.length; i++) {
            txt[i].setEnabled(true);
            }
         }
public  void setiarCajaEnableFalse(JTextField[] txt ){
     for (int i = 0; i < txt.length; i++) {
            txt[i].setEnabled(false);
            }
         }
 //mensaje de validaciones
public boolean confirmarMensaje(){
        ImageIcon icon = new ImageIcon("src/imagenes/Nuevo.png");
	int input = JOptionPane.showConfirmDialog(null, "Desea crear un nuevo registro?", "CONFIRMACION.",
		JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icon);

        // 0=yes, 1=no, 2=cancel
	System.out.println(input);
      if (input==0) {
        return true;
    }
      return false;
}
public boolean confirmarMensajeSalida(){
        ImageIcon icon = new ImageIcon("src/imagenes/Close Window_48px.png");
	int input = JOptionPane.showConfirmDialog(null, "Desea salir de la aplicacion?", "CONFIRMACION.",
		JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icon);

        // 0=yes, 1=no, 2=cancel
	System.out.println(input);
      if (input==0) {
        return true;
    }
      return false;
}
public void mensajevalidacion(){
        ImageIcon icon = new ImageIcon("src/imagenes/advertencia.png");
        JOptionPane.showMessageDialog(null, "Faltan campos por llenar", "Validacion", 
                JOptionPane.DEFAULT_OPTION, icon);

}

public void mensajeBusqueda(){
        ImageIcon icon = new ImageIcon("src/imagenes/buscar.png");
        JOptionPane.showMessageDialog(null, "busqueda exitosa", "Busqueda", 
                JOptionPane.DEFAULT_OPTION, icon);


}public void mensajeBusquedaNoSePuede(){
        ImageIcon icon = new ImageIcon("src/imagenes/advertencia.png");
        JOptionPane.showMessageDialog(null, "Este empleado no se puede buscar!", "Busqueda", 
                JOptionPane.DEFAULT_OPTION, icon);

}
public void mensajeBusquedaNoEncontrado(){
        ImageIcon icon = new ImageIcon("src/imagenes/advertencia.png");
        JOptionPane.showMessageDialog(null, "Este empleado no se encontro!", "Busqueda", 
                JOptionPane.DEFAULT_OPTION, icon);

}
public void mensajeBusquedaNoEncontradoPorUsuarios(){
        ImageIcon icon = new ImageIcon("src/imagenes/advertencia.png");
        JOptionPane.showMessageDialog(null, "Este empleado no lo puedes eliminar!", "Busqueda", 
                JOptionPane.DEFAULT_OPTION, icon);

}

    public void cedulaEncotrada() {
   ImageIcon icon = new ImageIcon("src/imagenes/buscar.png");
        JOptionPane.showMessageDialog(null, "Esta cedula ya existe! no es posible crear este usuario.", "Busqueda", 
                JOptionPane.DEFAULT_OPTION, icon);
    }

    public void mensajeGuardadoExitoso() {
ImageIcon icon = new ImageIcon("src/imagenes/Guardar.png");
        JOptionPane.showMessageDialog(null, "Persona guardada exitosamente.", "Exitoso", 
                JOptionPane.DEFAULT_OPTION, icon);
 
    }
    public void boton_eliminar(String cedula){

   registro_empleado regEmp = new registro_empleado();
   regEmp.realizaConexion();
   String resBd = regEmp.Buscar_por_cedula(cedula);
   if(resBd!= null){
       try {
           String[] vconsulta = resBd.split(",");
           int confir = JOptionPane.showConfirmDialog(view,"¿Desea eliminar al Empleado:"+vconsulta[1]+" con la Cedula:"+vconsulta[2]+"?");
           System.out.println(confir);
           if(confir == 0){
               boolean confimado = regEmp.elimanar_empleado(Integer.parseInt(vconsulta[0]));
               if (confimado){
                   JOptionPane.showMessageDialog(view, "Eliminado");
                   return;
               }else{
                   JOptionPane.showMessageDialog(view, "Error al eliminar");
                   return;
               }
           }else {
               return;
           }
       } catch (Exception e) {
           System.out.println("error cancelo");
       }
       
   }else{
       JOptionPane.showMessageDialog(view, "Cedula no encontrada");
   } 
        }  
//}
    
    public void cargartabla(JTable tabla){
        registro_empleado regEmp = new registro_empleado();
        regEmp.realizaConexion();
        ArrayList<String> lista = regEmp.devolverEmpleado();
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        for (int i = 0; i < lista.size(); i++) {
            String[] datos = lista.get(i).split(",");
            Object[] fila ={datos[0],datos[1],datos[2],datos[3],datos[4]};
            modelo.addRow(fila);
        }
        tabla.setModel(modelo);     
    }
    
    public void cargartablaDisponible(JTable tabla){
        alquilacion_habitacion alqH = new alquilacion_habitacion();
        alqH.realizaConexion();
        ArrayList<String> lista = alqH.diponible();
          DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        for (int i = 0; i < lista.size(); i++) {
            String[] datos = lista.get(i).split(",");
            Object[] fila ={datos[0],datos[1],datos[2]};
            modelo.addRow(fila);
        }
        tabla.setModel(modelo);     
    }
    public void datos(JTable table,JTextField[] text){
        if (table.getSelectedRowCount()>0) {
             for (int i = 0; i < text.length; i++) {
            text[i].setText(table.getValueAt(table.getSelectedRow(), i).toString());
        }
        }
    }
}

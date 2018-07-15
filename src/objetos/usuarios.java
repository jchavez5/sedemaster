package objetos;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class usuarios {
    private int id;
    private String nombre;
    private String apellido;
    private String telefono;
    private  int cedula;
    private  int idrol;
    private String correo;

    public usuarios() {
    }

    public usuarios(int id, String nombre, String apellido, String telefono, int cedula, int idrol, String correo) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.cedula = cedula;
        this.idrol = idrol;
        this.correo = correo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public int getIdrol() {
        return idrol;
    }

    public void setIdrol(int idrol) {
        this.idrol = idrol;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public String toString() {
        return "usuarios{" + "id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", telefono=" + telefono + ", cedula=" + cedula + ", idrol=" + idrol + ", correo=" + correo + '}';
    }
    
    
    
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkgEntidad;
import java.sql.*;

/**
 *
 * @author USUARIO
 */
public class clsECliente {
    
     public String dni;
     private String nombre;
     private String apellido;
     private String telefono;
     static int nh = 0;

    public static int getNh() {
        return nh;
    }
    public void setNh(int nh) {
        this.nh = nh;
    }
     
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
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

    public clsECliente() {
    }

    public clsECliente(String dni, String nombre, String apellido, String telefono) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
    }
    
    
    
}

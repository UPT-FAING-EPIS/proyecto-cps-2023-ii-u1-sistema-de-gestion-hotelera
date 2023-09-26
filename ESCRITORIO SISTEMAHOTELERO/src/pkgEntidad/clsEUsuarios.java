/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkgEntidad;

/**
 *
 * @author ASUS
 */
public class clsEUsuarios {
    private String dni;
    private String clave;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private String estado;
    private int fk_cargo;

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getFk_cargo() {
        return fk_cargo;
    }

    public void setFk_cargo(int fk_cargo) {
        this.fk_cargo = fk_cargo;
    }

    public clsEUsuarios() {
    }

    public clsEUsuarios(String dni, String clave, String nombre, String apellido, String email, String telefono, String estado, int fk_cargo) {
        this.dni = dni;
        this.clave = clave;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
        this.estado = estado;
        this.fk_cargo = fk_cargo;
    }


    
    
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author USUARIO
 */
public class UsuarioAdmin {
    
    private String dni;
    private String clave;
    private int fk_cargo;
    private String estado;

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
    
    public int getFkcargo() {
        return fk_cargo;
    }

    public void setFkcargo(int fk_cargo) {
        this.fk_cargo = fk_cargo;
    }
    
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public UsuarioAdmin() {
    }

    public UsuarioAdmin(String dni, String clave,String estado, int fk_cargo) {

        this.dni = dni;
        this.clave = clave;
        this.estado = estado;
        this.fk_cargo = fk_cargo;
        
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author USUARIO
 */
public class Producto {
    
    private String codigo;
    private String nombre;
    private int cantidad;
    private float prunitario;
    private String estado;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getPrunitario() {
        return prunitario;
    }

    public void setPrunitario(float prunitario) {
        this.prunitario = prunitario;
    }
    
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Producto() {
    }

    
    public Producto(String codigo, String nombre, int cantidad, float prunitario, String estado) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.prunitario = prunitario;
        this.estado = estado;
    }
    
    
    
    
    
    
    
}

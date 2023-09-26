/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkgEntidad;

/**
 *
 * @author Acer
 */
public class clsEHabitaciones {
    
    private int id;
    private String fkdnicli;
    private String numero;
    private String tipo;
    private double precio;
    private String estado;
    private byte[] foto;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFkdnicli() {
        return fkdnicli;
    }

    public void setFkdnicli(String fkdnicli) {
        this.fkdnicli = fkdnicli;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public clsEHabitaciones() {
    }

    public clsEHabitaciones(int id, String fkdnicli, String numero, String tipo, double precio, String estado, byte[] foto) {
        this.id = id;
        this.fkdnicli = fkdnicli;
        this.numero = numero;
        this.tipo = tipo;
        this.precio = precio;
        this.estado = estado;
        this.foto = foto;
    }

    
    
    
}

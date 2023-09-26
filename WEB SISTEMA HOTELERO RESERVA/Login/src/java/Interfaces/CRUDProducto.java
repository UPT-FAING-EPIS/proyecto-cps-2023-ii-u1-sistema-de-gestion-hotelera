/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;
import Modelo.Producto;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public interface CRUDProducto {
    
    public List listar();
    public Producto list(String codigo); //metodo list y pasamos el parametro dni
    public boolean add(Producto prod); //con boolean definimos si el dato esta registrado o no
    public boolean edit(Producto prod); //cli es el objeto de nuestra clase Cliente
    public boolean eliminar(String codigo);
    
}

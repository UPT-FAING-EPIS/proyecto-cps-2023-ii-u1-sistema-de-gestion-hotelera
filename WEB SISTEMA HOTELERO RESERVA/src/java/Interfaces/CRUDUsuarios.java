/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;
import Modelo.Usuarios;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public interface CRUDUsuarios {
    
    public List listar();
    public Usuarios list(String dni); //metodo list y pasamos el parametro dni
    public boolean add(Usuarios cli); //con boolean definimos si el dato esta registrado o no
    public boolean edit(Usuarios cli); //cli es el objeto de nuestra clase Cliente
    public boolean eliminar(String dni);
    
}

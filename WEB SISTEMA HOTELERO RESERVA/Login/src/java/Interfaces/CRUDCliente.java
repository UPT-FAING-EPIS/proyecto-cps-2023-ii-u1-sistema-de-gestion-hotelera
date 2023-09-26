/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;
import Modelo.Cliente;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public interface CRUDCliente {
    
    public List listar();
    public Cliente list(String dni); //metodo list y pasamos el parametro dni
    public boolean add(Cliente cli); //con boolean definimos si el dato esta registrado o no
    public boolean edit(Cliente cli); //cli es el objeto de nuestra clase Cliente
    public boolean eliminar(String dni);
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;
import Modelo.Reservas;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public interface CRUDReservas {
    
    public List listar();
    public Reservas list(int id); //metodo list y pasamos el parametro dni
    public boolean add(Reservas res); //con boolean definimos si el dato esta registrado o no
    public boolean edit(Reservas res); //cli es el objeto de nuestra clase Cliente
    public boolean eliminar(int id);
    
}

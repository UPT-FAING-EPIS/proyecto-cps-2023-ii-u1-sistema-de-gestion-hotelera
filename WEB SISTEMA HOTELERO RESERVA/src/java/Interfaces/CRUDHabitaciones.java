/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;
import Modelo.Habitaciones;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public interface CRUDHabitaciones {
    
    public List listar();
    public Habitaciones list(int id); //metodo list y pasamos el parametro dni
    public boolean add(Habitaciones hab); //con boolean definimos si el dato esta registrado o no
    public boolean edit(Habitaciones hab); //cli es el objeto de nuestra clase Cliente
    public boolean eliminar(int id);
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;
import Modelo.Empleado; //llamamos al modelo Empleado
import java.util.List;

/**
 *
 * @author USUARIO
 */
public interface CRUDEmpleado {
    
    public List listar();
    public Empleado list(String dni); 
    public boolean add(Empleado emp); 
    public boolean edit(Empleado emp); 
    public boolean eliminar(String dni);
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModeloDAO;
import Config.Conexion;
import Interfaces.CRUDEmpleado;
import Modelo.Empleado;
import Interfaces.*;
import java.sql.*;
import java.util.ArrayList; //guardar datos en memoria


import java.util.List;

/**
 *
 * @author USUARIO
 */
public class EmpleadoDAO implements CRUDEmpleado {

    
    Conexion cn=new Conexion();//para reestablecer la conexion
    Connection con; //para llamar a la cadena de conexion
    PreparedStatement ps; //ejecutar consulta
    ResultSet rs; //almacena datos de la consulta
    Empleado empleado =new Empleado(); //objeto Empleado
    
    
    @Override
    public List listar() {
          
        ArrayList<Empleado> list=new ArrayList<>();
        String sql="select * from tbempleados";
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                
                Empleado emp=new Empleado();
                
                emp.setId(rs.getInt("id"));
                emp.setDni(rs.getString("dni"));
                emp.setClave(rs.getString("clave"));
                emp.setNombre(rs.getString("nombre"));
                emp.setApellido(rs.getString("apellido"));
                emp.setEmail(rs.getString("email"));
                emp.setTelefono(rs.getString("telefono"));
                emp.setHorario(rs.getString("horario"));
                emp.setCargo_id(rs.getInt("cargo_id"));
                
                list.add(emp); //se almacena en memoria en nuestro array
            }
        } catch (SQLException e){
            System.out.println("error "+e.getMessage());
        }
        
        return list;
        
            
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Empleado list(int id) {
         String sql="select dni, clave, nombre, apellido, email, telefono, horario,cargo_id from tbempleados where id='"+id+"'";
        try{
           con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            rs.next();
                
                Empleado emp=new Empleado();
                
                emp.setId(rs.getInt("id"));
                emp.setDni(rs.getString("dni"));
                emp.setClave(rs.getString("clave"));
                emp.setNombre(rs.getString("nombre"));
                emp.setApellido(rs.getString("apellido"));
                emp.setEmail(rs.getString("email"));
                emp.setTelefono(rs.getString("telefono"));
                emp.setHorario(rs.getString("horario"));
                emp.setCargo_id(rs.getInt("cargo_id"));
                
                return emp;
            
        }catch(SQLException e){
            System.out.println("error al Agregar "+e.getMessage());
        }
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return null;
    }

    @Override
    public boolean add(Empleado emp) {
        String sql="INSERT INTO tbempleados (id, dni, clave, nombre, apellido, email, telefono, horario, cargo_id)\n" + "VALUES('"+emp.getId()+"','"+emp.getDni()+"','"+emp.getClave()+"','"+emp.getNombre()+"','"+emp.getApellido()+"','"+emp.getEmail()+"','"+emp.getTelefono()+"','"+emp.getHorario()+"','"+emp.getCargo_id()+"');";
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        }catch(SQLException e){
            System.out.println("error al Agregar "+e.getMessage());
        }
    //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return false;
    }

    @Override
    public boolean edit(Empleado emp) {
          String sql="Update tbempleados set dni='"+emp.getDni()+"',clave='"+emp.getClave()+"',nombre='"+emp.getNombre()+"',apellido='"+emp.getApellido()+"',email='"+emp.getEmail()+"',telefono='"+emp.getTelefono()+"',horario='"+emp.getHorario()+"',cargo_id='"+emp.getCargo_id()+"' where id='"+emp.getId()+"';";
       
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        }catch(SQLException e){
            System.out.println("error al Editar "+e.getMessage());
        }
        return false;
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean eliminar(int id) {
         String sql="delete from tbempleados where id='"+id+"'";
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate(sql);
        }catch(SQLException e){
            System.out.println("error al Eliminar "+e.getMessage());
        }
        return false;
    }
    
    
    
    
}


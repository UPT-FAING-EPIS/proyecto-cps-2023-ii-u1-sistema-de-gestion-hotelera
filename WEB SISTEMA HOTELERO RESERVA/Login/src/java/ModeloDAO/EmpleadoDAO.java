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
        String sql="select * from tbempleado";
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                
                Empleado emp=new Empleado();
                
                emp.setDni(rs.getString("dni"));
                emp.setDireccion(rs.getString("direccion"));
                emp.setEmail(rs.getString("email"));
                emp.setTelefono(rs.getString("telefono"));
                emp.setClave(rs.getString("clave"));
                emp.setEstado(rs.getString("estado"));
                
                list.add(emp); //se almacena en memoria en nuestro array
            }
        } catch (SQLException e){
            System.out.println("error "+e.getMessage());
        }
        
        return list;
        
        
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Empleado list(String dni) {
         String sql="select dni, direccion,email,telefono,clave,estado from tbempleado where dni='"+dni+"'";
        try{
           con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            rs.next();
                
                Empleado emp=new Empleado();
                
                emp.setDni(rs.getString("dni"));
                emp.setDireccion(rs.getString("direccion"));
                emp.setEmail(rs.getString("email"));
                emp.setTelefono(rs.getString("telefono"));
                emp.setClave(rs.getString("clave"));
                emp.setEstado(rs.getString("estado"));
                
                return emp;
            
        }catch(SQLException e){
            System.out.println("error al Agregar "+e.getMessage());
        }
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return null;
    }

    @Override
    public boolean add(Empleado emp) {
        String sql="INSERT INTO tbempleado (dni, direccion,email,telefono,clave,estado)\n" + "VALUES('"+emp.getDni()+"','"+emp.getDireccion()+"','"+emp.getEmail()+"','"+emp.getTelefono()+"','"+emp.getClave()+"','"+emp.getEstado()+"');";
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
          String sql="Update tbempleado set direccion='"+emp.getDireccion()+"',email='"+emp.getEmail()+"',telefono='"+emp.getTelefono()+"',clave='"+emp.getClave()+"',estado='"+emp.getEstado()+"' where dni='"+emp.getDni()+"';";
       
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
    public boolean eliminar(String dni) {
         String sql="delete from tbempleado where dni='"+dni+"'";
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


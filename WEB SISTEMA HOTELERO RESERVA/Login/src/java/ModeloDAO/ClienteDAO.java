/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModeloDAO;
import Config.Conexion;
import Interfaces.CRUDCliente;
import Modelo.Cliente;
import Interfaces.*;
import java.sql.*;
import java.util.ArrayList; //guardar datos en memoria
import java.util.List;



/**
 *
 * @author USUARIO
 */
public class ClienteDAO implements CRUDCliente{
    
    
    Conexion cn=new Conexion();//para reestablecer la conexion
    Connection con; //para llamar a la cadena de conexion
    PreparedStatement ps; //ejecutar consulta
    ResultSet rs; //almacena datos de la consulta
    Cliente c =new Cliente(); //objeto cliente
    

    @Override
    public List listar() {
        
        ArrayList<Cliente> list=new ArrayList<>();
        String sql="select * from tbcliente";
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Cliente cli=new Cliente();
                
                cli.setDni(rs.getString("dni"));
                cli.setDireccion(rs.getString("direccion"));
                cli.setTelefono(rs.getString("telefono"));
                cli.setEmail(rs.getString("email"));
                
                list.add(cli); //se almacena en memoria en nuestro array
            }
        } catch (SQLException e){
            System.out.println("error "+e.getMessage());
        }
        
        return list;
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Cliente list(String dni) {
        String sql="select dni, direccion,telefono,email from tbcliente where dni='"+dni+"'";
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            rs.next();
            Cliente cli=new Cliente();
                
                cli.setDni(rs.getString("dni"));
                cli.setDireccion(rs.getString("direccion"));
                cli.setTelefono(rs.getString("telefono"));
                cli.setEmail(rs.getString("email"));
            return cli;
                
        }catch(SQLException e){
            System.out.println("error al Agregar "+e.getMessage());
        }
        return null;
    }

    @Override
    public boolean add(Cliente cli) {
            String sql="INSERT INTO tbcliente (dni,direccion,telefono,email)\n" + "VALUES('"+cli.getDni()+"','"+cli.getDireccion()+"','"+cli.getTelefono()+"','"+cli.getEmail()+"');";
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
    public boolean edit(Cliente cli) {
            String sql="Update tbcliente set direccion='"+cli.getDireccion()+"',telefono='"+cli.getTelefono()+"',email='"+cli.getEmail()+"' where dni='"+cli.getDni()+"';";
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
          String sql="delete from tbcliente where dni='"+dni+"'";
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

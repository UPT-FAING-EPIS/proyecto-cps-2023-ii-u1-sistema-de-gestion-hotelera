/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModeloDAO;
import Config.Conexion;
import Modelo.Usuarios;
import Interfaces.*;
import java.sql.*;
import java.util.ArrayList; //guardar datos en memoria
import java.util.List;
import Interfaces.CRUDUsuarios;



/**
 *
 * @author USUARIO
 */
public class UsuariosDAO implements CRUDUsuarios{
    
    
    Conexion cn=new Conexion();//para reestablecer la conexion
    Connection con; //para llamar a la cadena de conexion
    PreparedStatement ps; //ejecutar consulta
    ResultSet rs; //almacena datos de la consulta
    Usuarios c =new Usuarios(); //objeto cliente
    

    @Override
    public List listar() {
        
        ArrayList<Usuarios> list=new ArrayList<>();
        String sql="select * from tbusuarios";
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Usuarios cli=new Usuarios();
                
                cli.setDni(rs.getString("dni"));
                cli.setClave(rs.getString("clave"));
                cli.setNombre(rs.getString("nombre"));
                cli.setApellido(rs.getString("apellido"));
                cli.setEmail(rs.getString("email"));
                cli.setTelefono(rs.getString("telefono"));
                cli.setEstado(rs.getString("estado"));
                cli.setFk_cargo(rs.getInt("fk_cargo"));
                
                list.add(cli); //se almacena en memoria en nuestro array
            }
        } catch (SQLException e){
            System.out.println("error "+e.getMessage());
        }
        
        return list;
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Usuarios list(String dni) {
        String sql="select dni, clave,nombre,apellido,email,telefono,estado,fk_cargo from tbusuarios where dni='"+dni+"'";
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            rs.next();
            Usuarios cli=new Usuarios();
                
                cli.setDni(rs.getString("dni"));
                cli.setClave(rs.getString("clave"));
                cli.setNombre(rs.getString("nombre"));
                cli.setApellido(rs.getString("apellido"));
                cli.setEmail(rs.getString("email"));
                cli.setTelefono(rs.getString("telefono"));
                cli.setEstado(rs.getString("estado"));
                cli.setFk_cargo(rs.getInt("fk_cargo"));
            return cli;
                
        }catch(SQLException e){
            System.out.println("error al Agregar "+e.getMessage());
        }
        return null;
    }

    @Override
    public boolean add(Usuarios cli) {
            String sql="INSERT INTO tbusuarios (dni,clave,nombre,apellido,email,telefono,estado,fk_cargo)\n" + "VALUES('"+cli.getDni()+"','"+cli.getClave()+"','"+cli.getNombre()+"','"+cli.getApellido()+"','"+cli.getEmail()+"','"+cli.getTelefono()+"','"+cli.getEstado()+"','"+cli.getFk_cargo()+"');";
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
    public boolean edit(Usuarios cli) {
            String sql="Update tbusuarios set clave='"+cli.getClave()+"',nombre='"+cli.getNombre()+"',apellido='"+cli.getApellido()+"',email='"+cli.getEmail()+"',telefono='"+cli.getTelefono()+"',estado='"+cli.getEstado()+"',fk_cargo='"+cli.getFk_cargo()+"' where dni='"+cli.getDni()+"';";
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
          String sql="delete from tbusuarios where dni='"+dni+"'";
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

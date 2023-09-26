/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModeloDAO;
import Config.Conexion;
import Interfaces.CRUDProducto;
import Modelo.Producto;
import Interfaces.*;
import java.sql.*;
import java.util.ArrayList; //guardar datos en memoria


import java.util.List;

/**
 *
 * @author USUARIO
 */
public class ProductoDAO implements CRUDProducto {

    
    Conexion cn=new Conexion();//para reestablecer la conexion
    Connection con; //para llamar a la cadena de conexion
    PreparedStatement ps; //ejecutar consulta
    ResultSet rs; //almacena datos de la consulta
    Producto producto =new Producto(); //objeto Empleado
    
    
    @Override
    public List listar() {
          
        ArrayList<Producto> list=new ArrayList<>();
        String sql="select * from tbproducto";
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                
                Producto prod=new Producto();
                
                prod.setCodigo(rs.getString("codigo"));
                prod.setNombre(rs.getString("nombre"));
                prod.setCantidad(rs.getInt("cantidad"));
                prod.setPrunitario(rs.getFloat("prunitario"));
                prod.setEstado(rs.getString("estado"));
                
                list.add(prod); //se almacena en memoria en nuestro array
            }
        } catch (SQLException e){
            System.out.println("error "+e.getMessage());
        }
        
        return list;
        
        
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Producto list(String codigo) {
         String sql="select codigo, nombre,cantidad,prunitario,estado from tbproducto where codigo='"+codigo+"'";
        try{
           con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            rs.next();
                
                Producto prod=new Producto();
                
                prod.setCodigo(rs.getString("codigo"));
                prod.setNombre(rs.getString("nombre"));
                prod.setCantidad(rs.getInt("cantidad"));
                prod.setPrunitario(rs.getFloat("prunitario"));
                prod.setEstado(rs.getString("estado"));
                
                return prod;
        }catch(SQLException e){
            System.out.println("error al Agregar "+e.getMessage());
        }
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return null;
    }

    @Override
    public boolean add(Producto prod) {
        String sql="INSERT INTO tbproducto (codigo,nombre,cantidad,prunitario,estado)\n" + "VALUES('"+prod.getCodigo()+"','"+prod.getNombre()+"','"+prod.getCantidad()+"','"+prod.getPrunitario()+"','"+prod.getEstado()+"');";
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
    public boolean edit(Producto prod) {
          String sql="Update tbproducto set nombre='"+prod.getNombre()+"',cantidad='"+prod.getCantidad()+"',prunitario='"+prod.getPrunitario()+"',estado='"+prod.getEstado()+"' where codigo='"+prod.getCodigo()+"';";
       
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
    public boolean eliminar(String codigo) {
         String sql="delete from tbproducto where codigo='"+codigo+"'";
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


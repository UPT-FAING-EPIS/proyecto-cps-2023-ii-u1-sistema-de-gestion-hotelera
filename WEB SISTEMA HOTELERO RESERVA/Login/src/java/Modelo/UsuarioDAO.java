/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author USUARIO
 */
public class UsuarioDAO implements Validar {
    
    Connection con;
    Conexion cn=new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    
    @Override
    public int Validar(Usuario per) {
        int r=0;
        String sql="Select * from tblogin where nombre=? and correo=?";
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.setString(1, per.getNombre());
            ps.setString(2, per.getCorreo());
            rs=ps.executeQuery();
            while(rs.next()){
                r=r+1;
                per.setNombre(rs.getString("nombre"));
                per.setCorreo(rs.getString("correo"));
            }
            if(r==1){
                return 1;
            }else{
                return 0;
            }
        } catch (SQLException e){
            return 0;
        }
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
}

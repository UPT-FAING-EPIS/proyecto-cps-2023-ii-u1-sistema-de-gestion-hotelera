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
public class AdminDAO implements ValidarAdmin {
    
    Connection con;
    Conexion cn=new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    
    @Override
    public int Validar(UsuarioAdmin per) {
        int r=0;
        String sql="Select * from tbusuarios where dni=? and clave=? AND estado='A' AND fk_cargo='1'";
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.setString(1, per.getDni());
            ps.setString(2, per.getClave());
            rs=ps.executeQuery();
            while(rs.next()){
                r=r+1;
                per.setDni(rs.getString("dni"));
                per.setClave(rs.getString("clave"));
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

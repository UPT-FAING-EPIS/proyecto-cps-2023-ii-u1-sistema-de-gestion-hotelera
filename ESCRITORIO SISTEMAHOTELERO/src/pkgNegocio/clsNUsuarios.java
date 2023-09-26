/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkgNegocio;
import java.sql.*;
import javax.swing.JOptionPane;
import pkgEntidad.clsEUsuarios;
import pkgPresentacion.FrmPrincipal;

/**
 *
 * @author ASUS
 */
public class clsNUsuarios {
    Conexion cn=new Conexion();//para reestablecer la conexion
    Connection con; //para llamar a la cadena de conexion
    PreparedStatement ps; //ejecutar consulta
    ResultSet rs; //almacena datos de la consulta
    clsEUsuarios c=new clsEUsuarios();  

    public ResultSet Mtdlistar() {
        ResultSet rpta;
        String[] dato = new String[9];
        String sql="SELECT * FROM tbusuarios";
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rpta=ps.executeQuery();
            return rpta;
        }catch(SQLException ex){
            System.out.println("error al Listar"+ex.getMessage());
            return rpta=null;
        }
    }

    public boolean MtdAgregar(clsEUsuarios objEusu) {
        String sql="insert into tbusuarios(dni,clave,nombre,apellido,email,telefono,estado,fk_cargo)"+
                "values('"+objEusu.getDni()+"','"+objEusu.getClave()+"','"+objEusu.getNombre()+"','"+objEusu.getApellido()+"','"+objEusu.getEmail()+"','"+objEusu.getTelefono()+"','"+objEusu.getEstado()+"','"+objEusu.getFk_cargo()+"')";
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate(sql);
            return true;
        }catch (SQLException e){
            System.out.print("error al agregar "+e.getMessage());
            return false;
        }
    }

    public boolean MtdModificar(clsEUsuarios objEusu) {
         String sql="update tbusuarios set clave='"+objEusu.getClave()+"',nombre='"+objEusu.getNombre()+"',apellido='"+objEusu.getApellido()+"',email='"+objEusu.getEmail()+"',"
                 + "telefono='"+objEusu.getTelefono()+"',estado='"+objEusu.getEstado()+"'"+"',fk_cargo='"+objEusu.getFk_cargo()+"'"+"where dni="+objEusu.getDni()+";";
         System.out.print(sql);
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate(sql);
            return true;
        }catch (SQLException e){
            System.out.print("error al Modificar "+e.getMessage());
            return false;
        }
        
    }

    public boolean MtdEliminar(String dni) {
         String sql = "DELETE FROM tbusuarios WHERE dni = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, dni);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al eliminar: " + e.getMessage());
            return false;
        }
    }

    public ResultSet MtdBuscarCodigo(clsEUsuarios objEe) {
        ResultSet rpta;
        String[] dato=new String[10];
        String sql="SELECT * FROM tbusuarios where dni='"+objEe.getDni()+"';";
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rpta=ps.executeQuery();
            return rpta;
        } catch(SQLException ex){
            System.out.println("error al Buscar "+ex.getMessage());
            return rpta=null;
        }

    }

    
    public boolean MtdValidarLogin(clsEUsuarios objEusu) {
        
                String sql="select * from tbusuarios where dni='"+objEusu.getDni()+"' and clave='"+objEusu.getClave()+"' and fk_cargo=1 and estado='A'";
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery(sql);
            int c=0;
            while(rs.next()){
                c++;
            }
            if(c>0){
                return true;
            }
            else{
                return false;
            }
        }catch (SQLException e){
            System.out.print("error al agregar "+e.getMessage());
            return false;
        }
        
    }
   
}

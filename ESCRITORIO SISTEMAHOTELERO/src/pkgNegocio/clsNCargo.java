/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkgNegocio;
import java.sql.*;
import pkgEntidad.clsECargo;

/**
 *
 * @author USUARIO
 */
public class clsNCargo {
    
    Conexion cn=new Conexion();//para reestablecer la conexion
    Connection con; //para llamar a la cadena de conexion
    PreparedStatement ps; //ejecutar consulta
    ResultSet rs; //almacena datos de la consulta
    clsECargo c=new clsECargo(); 

    public ResultSet Mtdlistar() {
        ResultSet rpta;
        String[] dato = new String[4];
        String sql="SELECT * FROM tbcargos";
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rpta=ps.executeQuery();
            return rpta;
        }catch(SQLException ex){
            System.out.println("error al Listar"+ex.getMessage());
            return rpta=null;
        }

        

// throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public ResultSet MtdBuscarCodigo(clsECargo objEca) {
        ResultSet rpta;
        String[] dato=new String[4];
        String sql="SELECT * FROM tbcargos where id='"+objEca.getId()+"';";
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rpta=ps.executeQuery();
            return rpta;
        } catch(SQLException ex){
            System.out.println("error al Buscar "+ex.getMessage());
            return rpta=null;
        }
//throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public boolean MtdAgregar(clsECargo objEcar) {
        String sql="insert into tbcargos(id,nombre)"+
                "values('"+objEcar.getId()+"','"+objEcar.getNombre()+"')";
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate(sql);
            return true;
        }catch (SQLException e){
            System.out.print("error al agregar "+e.getMessage());
            return false;
        }
//throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public boolean MtdEliminar(String dni) {
          String sql = "DELETE FROM tbcargos WHERE id = ?";
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

//throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public boolean MtdModificar(clsECargo objEcar) {
     
      String sql="update tbcargos set nombre='"+objEcar.getNombre()+"'"+"where id="+objEcar.getId()+";";
         System.out.print(sql);
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate(sql);
            return true;
        }catch (SQLException e){
            System.out.print("error al Modificar "+e.getMessage());
            return false;
//throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
 }
}

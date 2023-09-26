/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkgNegocio;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import pkgEntidad.clsEHabitaciones;

/**
 *
 * @author Acer
 */
public class clsNHabitaciones {
    Conexion cn=new Conexion();//para reestablecer la conexion
    Connection con; //para llamar a la cadena de conexion
    PreparedStatement ps; //ejecutar consulta
    ResultSet rs; //almacena datos de la consulta
    clsEHabitaciones c=new clsEHabitaciones();  
    
   public ResultSet Mtdestadohabitaciones() {
        ResultSet rpta;
        //String[] dato = new String[1];
        String sql="SELECT estado FROM tbhabitaciones";
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
   
//   public ResultSet Mtdlistar() {
//        
//        return null;
//        
//    }
   
   public boolean MtdModificar(clsEHabitaciones objEhab) {
       String sql = "UPDATE tbhabitaciones SET fkdnicli = '" + objEhab.getFkdnicli() + "'," + "estado = '" + objEhab.getEstado() + "'WHERE id = " + objEhab.getId();
       
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

   
   
   public boolean MtdAgregarHabitacion(clsEHabitaciones objEhab) {
        
       try{
            String SQL="CALL USP_I_AgregarHabitacion (?,?,?,?,?,?);";
            con=cn.getConnection();
            PreparedStatement st=con.prepareStatement(SQL);
            st.setString(1, objEhab.getFkdnicli());
            st.setString(2, objEhab.getNumero());
            st.setString(3, objEhab.getTipo());
            st.setDouble(4, objEhab.getPrecio());
            st.setString(5, objEhab.getEstado());
            st.setBytes(6,objEhab.getFoto());
            
            if (st.executeUpdate()>0) {
                return true;
                
            }
            else{
                return false;
                
            }
        }catch (SQLException e){
            return false;
        }
    }
   
   public static ArrayList<clsEHabitaciones> MtdListar() {
        try {
        String SQL = "Select * from tbhabitaciones";
        Conexion conexion = new Conexion();
        Connection con = conexion.getConnection();
        PreparedStatement st = con.prepareStatement(SQL);
        
        ResultSet resultado = st.executeQuery();
        ArrayList<clsEHabitaciones> lista = new ArrayList<>();
        clsEHabitaciones res;
        while (resultado.next()) {
            res = new clsEHabitaciones();
            res.setId(resultado.getInt("id"));
            res.setFkdnicli(resultado.getString("fkdnicli"));
            res.setNumero(resultado.getString("numero"));
            res.setTipo(resultado.getString("tipo"));
            res.setPrecio(resultado.getInt("precio"));
            res.setEstado(resultado.getString("estado"));
            res.setFoto(resultado.getBytes("foto"));
            lista.add(res);
        }
        return lista;
    } catch (SQLException e) {
        return null;
    }
     }   
    public ResultSet MtdBuscarCodigo(clsEHabitaciones objEhab) {
        ResultSet rpta;
        String[] dato=new String[7];
        String sql="SELECT * FROM tbhabitaciones where id='"+objEhab.getId()+"';";
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
}
   
//   public static ArrayList<clsEHabitaciones> MtdListarHabitacion() {
//         try {
//            String SQL="Select * from tbhabitaciones";  
//            //Connection con=Conexion.Conexion();
//            //PreparedStatement st=con.prepareStatement(SQL);
//            //ResultSet resultado=st.executeQuery();
//            ArrayList<clsEHabitaciones> listahab=new ArrayList();
//            clsEHabitaciones lhab;
//            
//            
//            while(rs.next()){
//               lhab=new clsEHabitaciones();
//               lhab.setId(rs.getInt("id"));
//               lhab.setUsuario_id(rs.getInt("Usuario_id"));
//               lhab.setEstado(rs.getString("Estado"));
//               lhab.setDescripcion(rs.getString("Descripcion"));
//               lhab.setTipo(rs.getString("Tipo"));
//               lhab.setPrecio(rs.getDouble("Precio"));
//               lhab.setFoto(rs.getBytes("Foto"));
//
//               listahab.add(lhab);               
//            }
//            return listahab;
//        }catch (SQLException e){
//            return null;
//        }
//    }
    

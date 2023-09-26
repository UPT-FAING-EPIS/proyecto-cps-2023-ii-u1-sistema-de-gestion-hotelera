/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkgNegocio;
import java.sql.*;
import java.util.ArrayList;
import pkgEntidad.clsEReservas;

/**
 *
 * @author USUARIO
 */
public class clsNReservas {
    
    Conexion cn=new Conexion();//para reestablecer la conexion
    Connection con; //para llamar a la cadena de conexion
    PreparedStatement ps; //ejecutar consulta
    ResultSet rs; //almacena datos de la consulta
    clsEReservas c=new clsEReservas();


    public static ArrayList<clsEReservas> MtdListarReserva(clsEReservas objres) {
        try {
            String SQL="Select * from tbreservas WHERE dni = ?";  
            Conexion conexion = new Conexion();
            Connection con = conexion.getConnection();
            PreparedStatement st=con.prepareStatement(SQL);
            st.setInt(1, objres.getId());
            ResultSet resultado=st.executeQuery();
            ArrayList<clsEReservas> lista=new ArrayList();
            clsEReservas car;
            
            
            while(resultado.next()){
               car=new clsEReservas();
               car.setId(resultado.getInt("Id"));
               car.setCliente_dni(resultado.getString("cliente_dni"));
               car.setHabitacion_id(resultado.getInt("Habitacion_id"));
               car.setFechareserva(resultado.getString("Fechares"));
               car.setEstado(resultado.getString("Estado"));
               car.setFecha_entrada(resultado.getString("fecha_entrada"));
               car.setFecha_salida(resultado.getString("fecha_salida"));
               car.setPtotal(resultado.getInt("Ptotal"));

               lista.add(car);
               
            }
            return lista;
        }catch (SQLException e){
            return null;
        }
    }
    
//    public static ArrayList<clsEReservas> MtdListarReser() {
//        try {
//            String SQL="Select * from tbhabitaciones";  
//            Connection con=Conexion.Conexion;
//            PreparedStatement st=con.prepareStatement(SQL);
//         
//            ResultSet resultado=st.executeQuery();
//            ArrayList<clsEReservas> lista=new ArrayList();
//            clsEReservas res;
//            while(resultado.next()){
//               res=new clsEReservas();
//               res.setId(resultado.getInt("id"));
//               res.setNumero(resultado.getString("numero"));
//               res.setEstado(resultado.getString("Estado"));
//               res.setNrohabitaciones(resultado.getInt("NumHabitaciones"));
//               res.setCiudad(resultado.getString("Ciudad"));
//               res.setDescripcion(resultado.getString("Descripcion"));
//               res.setCategoria(resultado.getString("Categoria"));
//               res.setPrecio(resultado.getDouble("Precio"));
//               res.setFoto(resultado.getBytes("Foto"));
//               lista.add(res);
//               
//            }
//            return lista;
//        }catch (SQLException e){
//            return null;
//        }
//    }
    
    public ResultSet Mtdlistar() {
        ResultSet rpta;
        String[] dato = new String[9];
        String sql="SELECT * FROM tbreservas";
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
    
    public boolean MtdEliminar(String id) {
          String sql = "DELETE FROM tbreservas WHERE id = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            //ps.setInt(1, id);
            ps.setString(1, id);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al eliminar: " + e.getMessage());
            return false;
        }
    }
    
    public boolean MtdActualizarEstado(String dni) {
    String sql = "UPDATE tbreservas SET estado = 'Reservado' WHERE id = ?";
    try {
        con = cn.getConnection();
        ps = con.prepareStatement(sql);
        ps.setString(1, dni);
        ps.executeUpdate();
        return true;
    } catch (SQLException e) {
        System.out.println("Error al actualizar el estado: " + e.getMessage());
        return false;
    }
}
    
    public boolean MtdAgregar(clsEReservas objEres) {
        String sql="insert into tbreservas(id,cliente_dni,habitacion_id,fechareserva,estado,fecha_entrada,fecha_salida)"+
                "values('"+objEres.getId()+"','"+objEres.getCliente_dni()+"','"+objEres.getHabitacion_id()+"','"+objEres.getFechareserva()+"','"+objEres.getEstado()+"','"+objEres.getFecha_entrada()+"','"+objEres.getFecha_salida()+"')";
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
    
    public ResultSet MtdBuscarCodigo(clsEReservas objEre) {
        ResultSet rpta;
        String[] dato=new String[4];
        String sql="SELECT * FROM tbreservas where id='"+objEre.getId()+"';";
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
    
    public boolean MtdModificar(clsEReservas objEres) {
     
      String sql="update tbreservas set cliente_dni  ='"+objEres.getCliente_dni()+"'"+",habitacion_id='"+objEres.getHabitacion_id()+"'"+",fecharesereva='"+objEres.getFechareserva()+"'"+",estado='"+objEres.getEstado()+"'"+",fecha_entrada='"+objEres.getFecha_entrada()+"'"+",fecha_salida='"+objEres.getFecha_salida()+"'"+"where id="+objEres.getId()+";";
         System.out.print(sql);
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate(sql);
            return true;
        }catch (SQLException e)
        {
            System.out.print("error al Modificar " + e.getMessage());
            return false;
        }
    }
}
//    public static boolean MtdAceptarHabitacion(clsEReservas objReE) {
//        try{
//            String SQL="CALL PC_AceptarRes (?,?);";
//            Connection con = Conexion.Conectar();
//            PreparedStatement st=con.prepareStatement(SQL);
//            st.setInt(1, objReE.getIdreserva());
//            st.setString(2, objReE.getEstado());
//            if (st.executeUpdate()>0) {
//                return true;
//            }
//            else{
//                return false;
//            }
//        }catch (SQLException e){
//            return false;
//        }
//    }
    


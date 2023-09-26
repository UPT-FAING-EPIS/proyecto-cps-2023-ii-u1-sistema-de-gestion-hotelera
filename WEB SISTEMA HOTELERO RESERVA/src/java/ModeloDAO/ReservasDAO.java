/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModeloDAO;
import Config.Conexion;
import Modelo.Reservas;
import Interfaces.*;
import java.sql.*;
import java.util.ArrayList; //guardar datos en memoria
import java.util.List;
import Interfaces.CRUDReservas;
import Modelo.Habitaciones;



/**
 *
 * @author USUARIO
 */
public class ReservasDAO implements CRUDReservas{
    
    
    Conexion cn=new Conexion();//para reestablecer la conexion
    Connection con; //para llamar a la cadena de conexion
    PreparedStatement ps; //ejecutar consulta
    ResultSet rs; //almacena datos de la consulta
    Reservas reservas =new Reservas(); //objeto cliente

    @Override
    public List listar() {
        
        ArrayList<Reservas> list=new ArrayList<>();
        String sql="select * from tbreservas";
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Reservas res=new Reservas();
                
                res.setId(rs.getInt(1));
                res.setCliente_dni(rs.getString("cliente_dni"));
                res.setHabitacion_id(rs.getInt("habitacion_id"));
                res.setFechareserva(rs.getString("fechareserva"));
                res.setFecha_entrada(rs.getString("fecha_entrada"));
                res.setFecha_salida(rs.getString("fecha_salida"));
                res.setEstado(rs.getString("estado"));
                
                list.add(res); //se almacena en memoria en nuestro array
            }
        } catch (SQLException e){
            System.out.println("error "+e.getMessage());
        }
        
        return list;
    }
        
    @Override
    public Reservas list(int id) {
        String sql="select cliente_dni, habitacion_id,fechareserva, fecha_entrada, fecha_salida,estado from tbreservas where id='"+id+"'";
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            rs.next();
            Reservas res=new Reservas();
                
                res.setId(rs.getInt(id));
                res.setCliente_dni(rs.getString("cliente_dni"));
                res.setHabitacion_id(rs.getInt("habitacion_id"));
                res.setFechareserva(rs.getString("fechareserva"));
                res.setFecha_entrada(rs.getString("fecha_entrada"));
                res.setFecha_salida(rs.getString("fecha_salida"));
                res.setEstado(rs.getString("estado"));
            return res;
                
        }catch(SQLException e){
            System.out.println("error al Agregar "+e.getMessage());
        }
        return null;
    }

    @Override
    public boolean add(Reservas res) {
            String sql="INSERT INTO tbreservas (cliente_dni, habitacion_id,fechareserva,estado, fecha_entrada, fecha_salida,ptotal)\n" + "VALUES('"+res.getCliente_dni()+"','"+res.getHabitacion_id()+"','"+res.getFechareserva()+"','"+res.getEstado()+"','"+res.getFecha_entrada()+"','"+res.getFecha_salida()+"','"+res.getPtotal()+"');";
            
            String sqla="Update tbhabitaciones set estado='"+res.getEstado()+"' where id='"+res.getHabitacion_id()+"';";
        
            //String sql = "UPDATE habitaciones SET estado = '" + nuevoEstado + "' WHERE habitacion_id = '" + habitacionId + "';";

          
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
            
            con=cn.getConnection();
            ps=con.prepareStatement(sqla);
            System.out.println(sqla);
            ps.executeUpdate();   
        }
            
        
    
        catch(SQLException e){
            System.out.println("error al Agregar "+e.getMessage());
        }
        return false;
    }

    @Override
    public boolean edit(Reservas res) {
            String sql="Update tbreservas set cliente_dni='"+res.getCliente_dni()+"',habitacion_id='"+res.getHabitacion_id()+"',fechareserva='"+res.getFechareserva()+"',estado='"+res.getEstado()+"',fecha_entrada='"+res.getFecha_entrada()+"',fecha_salida='"+res.getFecha_salida()+"' where id='"+res.getId()+"';";
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        }catch(SQLException e){
            System.out.println("error al Editar "+e.getMessage());
        }
        return false;
    }

    @Override
    public boolean eliminar(int id) {
          String sql="delete from tbreservas where id='"+id+"'";
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

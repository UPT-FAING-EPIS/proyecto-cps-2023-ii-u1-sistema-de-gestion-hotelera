/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkgNegocio;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;
import javax.swing.filechooser.FileSystemView;
import pkgEntidad.clsECliente;

/**
 *
 * @author USUARIO
 */
public class clsNCliente {
    
    Conexion cn=new Conexion();//para reestablecer la conexion
    Connection con; //para llamar a la cadena de conexion
    PreparedStatement ps; //ejecutar consulta
    ResultSet rs; //almacena datos de la consulta
    clsECliente c=new clsECliente(); 

    public ResultSet Mtdlistar() {
        
        ResultSet rpta;
        String[] dato = new String[6];
        String sql="SELECT * FROM tbcliente";
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rpta=ps.executeQuery();
            return rpta;
        }catch(SQLException ex){
            System.out.println("error al Listar"+ex.getMessage());
            return rpta=null;
        }

//throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public boolean MtdAgregar(clsECliente objEclie) {
        String sql = "INSERT INTO tbcliente(dni, nombre, apellido, telefono) " +
             "VALUES ('"+objEclie.getDni()+ "', '" + objEclie.getNombre() + "','" +
             objEclie.getApellido() + "','" + objEclie.getTelefono()+"')";
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

    public ResultSet MtdBuscarCodigo(clsECliente objEcli) {
        ResultSet rpta;
        String[] dato=new String[6];
        String sql="SELECT * FROM tbcliente where dni='"+objEcli.getDni()+"';";
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

    public boolean MtdEliminar(String dni) {
         String sql = "DELETE FROM tbcliente WHERE dni = ?";
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

    public boolean MtdModificar(clsECliente objEclie) {
       String sql = "UPDATE tbcliente SET direccion = '" + objEclie.getNombre() + "'," +
             "apellido = '" + objEclie.getApellido() + "'," +
             "telefono = '" + objEclie.getTelefono() + "' " +
             "WHERE dni = " + objEclie.getDni();
       
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
   
    public void pdfClientes(clsECliente objEclie) {
        String nombre = null, apellido = null, telefono = null;
        try {
            FileOutputStream archivo;
            String url = FileSystemView.getFileSystemView().getDefaultDirectory().getPath();
            File salida = new File(url + File.separator + "pedido.pdf");
            archivo = new FileOutputStream(salida);
            Document doc = new Document();
            PdfWriter.getInstance(doc, archivo);
            doc.open();
            Image img = Image.getInstance(getClass().getResource("/Img/logo.png"));
            //Fecha
            String informacion = "SELECT dni from tbclientes";
            try {
                ps = con.prepareStatement(informacion);
                ps.setInt(1, Integer.parseInt(objEclie.dni));
                rs = ps.executeQuery();
                if (rs.next()) {
                    nombre = rs.getString("nombre");
                    apellido = rs.getString("apellido");
                    telefono = rs.getString("telefono");
                }

            } catch (SQLException e) {
                System.out.println(e.toString());
            }
            
            PdfPTable Encabezado = new PdfPTable(4);
            Encabezado.setWidthPercentage(100);
            Encabezado.getDefaultCell().setBorder(0);
            float[] columnWidthsEncabezado = new float[]{20f, 20f, 60f, 60f};
            Encabezado.setWidths(columnWidthsEncabezado);
            Encabezado.setHorizontalAlignment(Element.ALIGN_LEFT);
            Encabezado.addCell(img);
            Encabezado.addCell("");
            //info empresa
            String config = "SELECT * FROM cliente";
            try {
                con = cn.getConnection();
                ps = con.prepareStatement(config);
                rs = ps.executeQuery();
                if (rs.next()) {
                    Encabezado.addCell("Dni:    " + rs.getString("dni") 
                            + "\nNombre: " + rs.getString("nombre") 
                            + "\nApellido: " + rs.getString("apellido") 
                            + "\nTelefono: " + rs.getString("dni")
                    );
                }
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
            //
            Paragraph info = new Paragraph();
            Font negrita = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD, BaseColor.BLUE);
//            info.add("Atendido: " + usuario 
//                    + "\nN° Pedido: " + id_pedido 
//                    + "\nFecha: " + fechaPedido
//                    + "\nSala: " + sala
//                    + "\nN° Mesa: " + num_mesa
//            );
            Encabezado.addCell(info);
            
            doc.add(Encabezado);
            doc.add(Chunk.NEWLINE);
            PdfPTable tabla = new PdfPTable(4);
            tabla.setWidthPercentage(100);
            tabla.getDefaultCell().setBorder(0);
            float[] columnWidths = new float[]{10f, 50f, 15f, 15f};
            tabla.setWidths(columnWidths);
            tabla.setHorizontalAlignment(Element.ALIGN_LEFT);
            PdfPCell c1 = new PdfPCell(new Phrase("Dni.", negrita));
            PdfPCell c2 = new PdfPCell(new Phrase("Nombre", negrita));
            PdfPCell c3 = new PdfPCell(new Phrase("Apellido", negrita));
            PdfPCell c4 = new PdfPCell(new Phrase("Telefono", negrita));
            c1.setBorder(Rectangle.NO_BORDER);
            c2.setBorder(Rectangle.NO_BORDER);
            c3.setBorder(Rectangle.NO_BORDER);
            c4.setBorder(Rectangle.NO_BORDER);
            c1.setBackgroundColor(BaseColor.LIGHT_GRAY);
            c2.setBackgroundColor(BaseColor.LIGHT_GRAY);
            c3.setBackgroundColor(BaseColor.LIGHT_GRAY);
            c4.setBackgroundColor(BaseColor.LIGHT_GRAY);
            tabla.addCell(c1);
            tabla.addCell(c2);
            tabla.addCell(c3);
            tabla.addCell(c4);
//            String product = "SELECT d.* FROM pedidos p INNER JOIN detalle_pedidos d ON p.id = d.id_pedido WHERE p.id = ?";
//            try {
//                ps = con.prepareStatement(product);
//                ps.setInt(1, id_pedido);
//                rs = ps.executeQuery();
//                while (rs.next()) {
//                    double subTotal = rs.getInt("cantidad") * rs.getDouble("precio");
//                    tabla.addCell(rs.getString("cantidad"));
//                    tabla.addCell(rs.getString("nombre"));
//                    tabla.addCell(rs.getString("precio"));
//                    tabla.addCell(String.valueOf(subTotal));
//                }
//
//            } catch (SQLException e) {
//                System.out.println(e.toString());
//            }
            doc.add(tabla);
            Paragraph agra = new Paragraph();
            agra.add(Chunk.NEWLINE);
            //agra.add("Total S/: " + total);
            agra.setAlignment(Element.ALIGN_RIGHT);
            doc.add(agra);
            Paragraph firma = new Paragraph();
            firma.add(Chunk.NEWLINE);
            firma.add("Cancelacion \n\n");
            firma.add("------------------------------------\n");
            firma.add("Firma \n");
            firma.setAlignment(Element.ALIGN_CENTER);
            doc.add(firma);
            Paragraph gr = new Paragraph();
            gr.add(Chunk.NEWLINE);
            //gr.add(mensaje);
            gr.setAlignment(Element.ALIGN_CENTER);
            doc.add(gr);
            doc.close();
            archivo.close();
            Desktop.getDesktop().open(salida);
        } catch (DocumentException | IOException e) {
            System.out.println(e.toString());
        }finally{
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
    }
    
    
    
}

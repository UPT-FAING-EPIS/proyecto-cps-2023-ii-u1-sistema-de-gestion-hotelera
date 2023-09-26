<%-- 
    Document   : validar.jsp
    Created on : 20 may 2023, 15:51:39
    Author     : USUARIO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String dni = request.getParameter("dni");
    String clave = request.getParameter("clave");
    String message = "";
    
    try{
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbhotel", "root", "");
        ps = con.prepareStatement("SELECT * FROM tbusuarios WHERE dni=? AND clave=?");
        ps.setString(1, dni);
        ps.setString(2, clave);
        rs = ps.executeQuery();

        if (rs.next()) {
            int id = rs.getInt("fk_cargo");
            if (id == 1) {
                response.sendRedirect("ControladorUsuarios?accion=listar");
            } else if (id == 2) {
                response.sendRedirect("PrincipalUser.jsp");
            } else {
                message = "ERROR EN LA AUTENTIFICACION";
            }
        } else {
            message = "ERROR EN LA AUTENTIFICACION";
        }
    } catch (Exception e) {
        message = "ERROR EN LA CONEXION A LA BASE DE DATOS";
        e.printStackTrace();
    } finally {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
%>

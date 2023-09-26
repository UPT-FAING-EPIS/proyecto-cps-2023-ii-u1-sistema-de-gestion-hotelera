<%-- 
    Document   : listar
    Created on : 21 may 2023, 10:39:28
    Author     : USUARIO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<%@page import="Modelo.Habitaciones"%>
<%@page import="ModeloDAO.HabitacionesDAO"%>
<%@page import="java.util.*"%>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Habitaciones - Gestion</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>
    <div class="container">
        <h1 class="mt-4">Gestion Habitaciones - Tomas Condori Vargas</h1>
        <a class="btn btn-primary mb-3" href="ControladorHabitaciones?accion=add">Agregar</a>
        
        <table class="table table-bordered">
            <thead>
                <tr>
                    <th>CODIGO</th>
                    <th>NUMERO</th>
                    <th>TIPO</th>
                    <th>PRECIO</th>
                    <th>ESTADO</th>
                    <th>ACCIONES</th>
                </tr>
            </thead>
            
            <%
                HabitacionesDAO dao = new HabitacionesDAO();
                List<Habitaciones> list = dao.listar();
                Iterator<Habitaciones> iter = list.iterator();
                Habitaciones hab = null;
                while (iter.hasNext()) {
                    hab = iter.next();
            %>
            
            <tbody>
                <tr>
                    <td><%= hab.getId()%></td>
                    <td><%= hab.getNumero()%></td>
                    <td><%= hab.getTipo()%></td>
                    <td><%= hab.getPrecio()%></td>
                    <td><%= hab.getEstado()%></td>
                    
                    <td>
                        <a class="btn btn-primary btn-sm" href="ControladorHabitaciones?accion=editar&vid=<%= hab.getId()%>">Editar</a>
                        <a class="btn btn-danger btn-sm" href="ControladorHabitaciones?accion=eliminar&vid=<%= hab.getId()%>">Eliminar</a>
                    </td>
                </tr>
                
                <% } %>
            </tbody>
        </table>
        
        <a class="btn btn-secondary" href="./Principal.jsp">Regresar</a>
    </div>
    
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>
</html>


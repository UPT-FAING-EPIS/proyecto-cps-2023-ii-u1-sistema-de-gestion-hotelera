<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<%@page import="Modelo.Producto"%>
<%@page import="ModeloDAO.ProductoDAO"%>
<%@page import="java.util.*"%>


<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Mantenimiento de Productos - Supermercado</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <style>
        .mt-4 {
            margin-top: 4rem;
        }
        
        .mb-3 {
            margin-bottom: 3rem;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1 class="mt-4">Mantenimiento de Productos - Tomas Condori Vargas</h1>
        <a class="btn btn-primary mb-3" href="ControladorProducto?accion=add">Agregar</a>
        
        <table class="table table-bordered">
            <thead>
                <tr>
                    <th>CODIGO</th>
                    <th>NOMBRE</th>
                    <th>STOCK</th>
                    <th>PRECIO UNITARIO</th>
                    <th>IMAGEN</th>
                    <th>ACCION</th>
                </tr>
            </thead>
            
            <%-- Iterate over the list of products --%>
            <tbody>
                <%
                    ProductoDAO dao = new ProductoDAO();
                    List<Producto> list = dao.listar();
                    for (Producto prod : list) {
                %>
                <tr>
                    <td><%= prod.getCodigo()%></td>
                    <td><%= prod.getNombre()%></td>
                    <td><%= prod.getCantidad()%></td>
                    <td><%= prod.getPrunitario()%></td>
                    <td><img src="improd/<%= prod.getCodigo() + ".jpg" %>" alt="<%= prod.getNombre()%>" width="100" height="100"></td>
                    
                    <td>
                        <a class="btn btn-primary btn-sm" href="ControladorProducto?accion=comprar&vcodigo=<%= prod.getCodigo()%>">Comprar</a>
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

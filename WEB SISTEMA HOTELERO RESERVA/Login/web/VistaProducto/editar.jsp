<%-- 
    Document   : editar
    Created on : 21 may 2023, 10:39:52
    Author     : USUARIO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<%@page import="Modelo.Producto"%>
<%@page import="ModeloDAO.ProductoDAO"%>
<%@page import="java.util.*"%>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Modificar Producto - Supermercado</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <style>
        .form-label {
            font-weight: bold;
        }
    </style>
</head>
<body>
    <div class="container">
        <%
            ProductoDAO dao = new ProductoDAO();
            String vcodigo = (String) request.getParameter("vcodigo");
            Producto producto = (Producto) dao.list(vcodigo);
        %>
        
        <h1 class="mt-4">MODIFICAR PRODUCTO</h1>
        <form action="ControladorProducto" class="mt-4">
            <div class="form-group">
                <label for="txtcodigo" class="form-label">CODIGO PRODUCTO:</label>
                <input type="text" class="form-control" name="txtcodigo" value="<%=producto.getCodigo() %>">
            </div>
            <div class="form-group">
                <label for="txtnom" class="form-label">NOMBRE:</label>
                <input type="text" class="form-control" name="txtnom" value="<%=producto.getNombre() %>">
            </div>
            <div class="form-group">
                <label for="txtcan" class="form-label">CANTIDAD:</label>
                <input type="text" class="form-control" name="txtcan" id="txtcan" value="<%=producto.getCantidad() %>">
            </div>
            <div class="form-group">
                <label for="txtpru" class="form-label">PRECIO UNITARIO:</label>
                <input type="text" class="form-control" name="txtpru" id="txtpru" value="<%=producto.getPrunitario() %>">
            </div>
            <div class="form-group">
                <label for="txtestado" class="form-label">ESTADO:</label>
                <input type="text" class="form-control" name="txtestado" value="<%=producto.getEstado() %>">
            </div>
            <input type="hidden" name="txtvcodigo" value="">
            <input type="submit" class="btn btn-primary" name="accion" value="Actualizar">
            <a href="ControladorProducto?accion=listar" class="btn btn-secondary">Regresar</a>
        </form>
    </div>
    
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <script>
        // Obtener el campo de entrada
        var txtcan = document.getElementById('txtcan');

        // Agregar evento de escucha para el evento "input"
        txtcan.addEventListener('input', function(e) {
            // Obtener el valor actual del campo de entrada
            var valor = txtcan.value;

            // Verificar si el valor ingresado es un número entero
            if (valor === "") {
                // Si no se ingresa nada, establecer el valor del campo de entrada como 0
                txtcan.value = "0";
            } else if (!Number.isInteger(parseFloat(valor))) {
                // Si no es un número entero, borrar el último carácter ingresado
                txtcan.value = valor.slice(0, -1);
            }
        });
    </script>
    
    <script>
        // Obtener el campo de entrada
        var txtpru = document.getElementById('txtpru');

        // Agregar evento de escucha para el evento "input"
        txtpru.addEventListener('input', function(e) {
            // Obtener el valor actual del campo de entrada
            var valor = txtpru.value;

            // Verificar si el valor ingresado es un número float válido
            if (valor === "") {
                // Si no se ingresa nada, establecer el valor predeterminado como 0
                txtpru.value = "0";
            } else if (isNaN(parseFloat(valor))) {
                // Si no es un número float válido, borrar el contenido del campo de entrada
                txtpru.value = "";
            }
        });
    </script>
</body>
</html>
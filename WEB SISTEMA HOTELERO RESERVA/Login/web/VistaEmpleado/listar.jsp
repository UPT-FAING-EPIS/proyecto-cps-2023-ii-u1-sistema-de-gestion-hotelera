<%-- 
    Document   : listar
    Created on : 21 may 2023, 10:39:28
    Author     : USUARIO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<%@page import="Modelo.Empleado"%>
<%@page import="ModeloDAO.EmpleadoDAO"%>
<%@page import="java.util.*"%>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Empleados</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <style>
        body {
            background-color: #f8f9fa;
            color: #333333;
            font-family: Arial, sans-serif;
            padding: 20px;
        }

        h1 {
            font-size: 24px;
            font-weight: bold;
            margin-bottom: 20px;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 20px;
        }

        th, td {
            padding: 10px;
            border: 1px solid #ced4da;
        }

        th {
            background-color: #e9ecef;
        }

        a {
            color: #007bff;
            text-decoration: none;
            margin-right: 10px;
        }

        a:hover {
            color: #0056b3;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Mantenimiento de Empleados - Tomas Condori Vargas</h1>
        <a class="btn btn-primary" href="ControladorEmpleado?accion=add">Agregar</a><br><br>

        <table class="table">
            <thead>
                <tr>
                    <th>DNI</th>
                    <th>DIRECCION</th>
                    <th>EMAIL</th>
                    <th>TELEFONO</th>
                    <th>CLAVE</th>
                    <th>ESTADO</th>
                    <th>ACCIONES</th>
                </tr>
            </thead>
            <tbody>
                <%
                EmpleadoDAO dao = new EmpleadoDAO();
                List<Empleado> list = dao.listar();
                for (Empleado emp : list) {
                %>
                <tr>
                    <td><%= emp.getDni() %></td>
                    <td><%= emp.getDireccion() %></td>
                    <td><%= emp.getEmail() %></td>
                    <td><%= emp.getTelefono() %></td>
                    <td><%= emp.getClave() %></td>
                    <td><%= emp.getEstado() %></td>
                    <td>
                        <a href="ControladorEmpleado?accion=editar&vdni=<%= emp.getDni() %>">Editar</a>
                        <a href="ControladorEmpleado?accion=eliminar&vdni=<%= emp.getDni() %>">Eliminar</a>
                    </td>
                </tr>
                <% } %>
            </tbody>
        </table>

        <a href="./Principal.jsp" class="btn btn-primary">Regresar</a>
    </div>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>
</html>

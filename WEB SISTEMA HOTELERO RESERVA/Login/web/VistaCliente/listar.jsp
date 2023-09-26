<%-- 
    Document   : listar.jsp
    Created on : 21 may 2023, 10:02:18
    Author     : USUARIO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<%@page import="Modelo.Cliente"%>
<%@page import="ModeloDAO.ClienteDAO"%>
<%@page import="java.util.*"%>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Mantenimiento de Clientes - Supermercado</title>
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

        a {
            color: #007bff;
            text-decoration: none;
        }

        table {
            width: 100%;
            border-collapse: collapse;
        }

        th, td {
            padding: 10px;
            text-align: left;
            border-bottom: 1px solid #dee2e6;
        }

        .actions {
            white-space: nowrap;
        }

        .actions a {
            margin-right: 10px;
        }

        .btn {
            padding: 5px 10px;
            font-size: 14px;
            border-radius: 4px;
        }

        .btn-primary {
            background-color: #007bff;
            border: none;
            color: #ffffff;
        }

        .btn-primary:hover {
            background-color: #0069d9;
        }

        .btn-danger {
            background-color: #dc3545;
            border: none;
            color: #ffffff;
        }

        .btn-danger:hover {
            background-color: #c82333;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Mantenimiento de Clientes</h1>
        <a href="ControladorCliente?accion=add" class="btn btn-primary">Agregar</a>

        <table class="table mt-4">
            <thead>
                <tr>
                    <th>DNI</th>
                    <th>DIRECCION</th>
                    <th>TELEFONO</th>
                    <th>EMAIL</th>
                    <th>ACCIONES</th>
                </tr>
            </thead>
            <tbody>
                <% 
                    ClienteDAO dao=new ClienteDAO();
                    List<Cliente> list=dao.listar();
                    Iterator<Cliente> iter=list.iterator();
                    Cliente cli=null;
                    while (iter.hasNext()) {
                        cli=iter.next();
                %>
                <tr>
                    <td><%= cli.getDni() %></td>
                    <td><%= cli.getDireccion() %></td>
                    <td><%= cli.getTelefono() %></td>
                    <td><%= cli.getEmail() %></td>
                    <td class="actions">
                        <a href="ControladorCliente?accion=editar&vdni=<%= cli.getDni() %>" class="btn btn-primary">Editar</a>
                        <a href="ControladorCliente?accion=eliminar&vdni=<%= cli.getDni() %>" class="btn btn-danger">Eliminar</a>
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


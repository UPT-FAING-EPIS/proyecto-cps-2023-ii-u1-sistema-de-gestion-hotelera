<%-- 
    Document   : listar.jsp
    Created on : 21 may 2023, 10:02:18
    Author     : USUARIO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<%@page import="Modelo.Usuarios"%>
<%@page import="ModeloDAO.UsuariosDAO"%>
<%@page import="java.util.*"%>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Usuarios - GESTION</title>
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
        <h1>Usuarios</h1>
        <a href="ControladorUsuarios?accion=add" class="btn btn-primary">Agregar</a>

        <table class="table mt-4">
            <thead>
                <tr>
                    <th>DNI</th>
                    <th>CONTRASEÑA</th>
                    <th>NOMBRE</th>
                    <th>APELLIDO</th>
                    <th>EMAIL</th>
                    <th>TELEFONO</th>
                    <th>ESTADO</th>
                    <th>CARGO</th>
                    <th>ACCIONES</th>
                </tr>
            </thead>
            <tbody>
                <% 
                    UsuariosDAO dao=new UsuariosDAO();
                    List<Usuarios> list=dao.listar();
                    Iterator<Usuarios> iter=list.iterator();
                    Usuarios cli=null;
                    while (iter.hasNext()) {
                        cli=iter.next();
                %>
                <tr>
                    <td><%= cli.getDni() %></td>
                    <td><%= cli.getClave() %></td>
                    <td><%= cli.getNombre() %></td>
                    <td><%= cli.getApellido() %></td>
                    <td><%= cli.getEmail() %></td>
                    <td><%= cli.getTelefono() %></td>
                    <td><%= cli.getEstado() %></td>
                    <td><%= cli.getFk_cargo() %></td>
                    <td class="actions">
                        <a href="ControladorUsuarios?accion=editar&vdni=<%= cli.getDni() %>" class="btn btn-primary">Editar</a>
                        <a href="ControladorUsuarios?accion=eliminar&vdni=<%= cli.getDni() %>" class="btn btn-danger">Eliminar</a>
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


<%-- 
    Document   : listar.jsp
    Created on : 21 may 2023, 10:02:18
    Author     : USUARIO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<%@page import="Modelo.Reservas"%>
<%@page import="ModeloDAO.ReservasDAO"%>
<%@page import="java.util.*"%>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Reservas Habitaciones - Gestion</title>
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
        <h1>Mantenimiento de Reservas</h1>
        <a href="ControladorReservas?accion=add" class="btn btn-primary">Agregar</a>

        <table class="table mt-4">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>DNI CLIENTE</th>
                    <th>HABITACION ID</th>
                    <th>FECHA ENTRADA</th>
                    <th>FECHA SALIDA</th>
                    <th>ESTADO</th>
                    <th>ACCIONES</th>
                </tr>
            </thead>
            <tbody>
                <% 
                    ReservasDAO dao=new ReservasDAO();
                    List<Reservas> list=dao.listar();
                    Iterator<Reservas> iter=list.iterator();
                    Reservas res=null;
                    while (iter.hasNext()) {
                        res=iter.next();
                %>
                <tr>
                    <td><%= res.getId() %></td>
                    <td><%= res.getCliente_dni() %></td>
                    <td><%= res.getHabitacion_id() %></td>
                    <td><%= res.getFecha_entrada() %></td>
                    <td><%= res.getFecha_salida() %></td>
                    <td><%= res.getEstado() %></td>
                    <td class="actions">
                        <a href="ControladorReservas?accion=editar&vid=<%= res.getId() %>" class="btn btn-primary">Editar</a>
                        <a href="ControladorReservas?accion=eliminar&vid=<%= res.getId() %>" class="btn btn-danger">Eliminar</a>
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


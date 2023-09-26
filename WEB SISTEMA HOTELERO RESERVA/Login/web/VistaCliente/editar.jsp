<%-- 
    Document   : editar
    Created on : 21 may 2023, 10:02:33
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
    <title>Modificar Cliente - Supermercado</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <style>
        body {
            background-color: #f8f9fa;
            color: #333333;
            font-family: Arial, sans-serif;
            padding-top: 50px;
        }

        .container {
            max-width: 500px;
            margin: 0 auto;
            background-color: #ffffff;
            padding: 30px;
            border-radius: 5px;
            box-shadow: 0px 2px 5px rgba(0, 0, 0, 0.1);
        }

        .container h1 {
            font-size: 24px;
            font-weight: bold;
            margin-bottom: 20px;
        }

        .form-group {
            margin-bottom: 20px;
        }

        .form-label {
            font-weight: bold;
            margin-bottom: 5px;
        }

        .form-control {
            width: 100%;
            padding: 10px;
            font-size: 16px;
            border: 1px solid #ced4da;
            border-radius: 4px;
        }

        .btn-primary {
            background-color: #007bff;
            border: none;
            padding: 10px 20px;
            font-size: 16px;
            border-radius: 4px;
        }

        .btn-primary:hover {
            background-color: #0069d9;
        }
    </style>
</head>
<body>
    <div class="container">
        <% 
            ClienteDAO dao=new ClienteDAO();
            String vdni=(String)request.getParameter("vdni");
            Cliente c=(Cliente) dao.list(vdni);
        %>
        
        <h1 class="mt-4">MODIFICAR CLIENTE</h1>
        
        <form action="ControladorCliente" class="mt-4">
            <div class="form-group">
                <label for="txtdni" class="form-label">DNI:</label>
                <input type="text" class="form-control" name="txtdni" value="<%=c.getDni()%>">
            </div>
            <div class="form-group">
                <label for="txtdir" class="form-label">DIRECCION:</label>
                <input type="text" class="form-control" name="txtdir" value="<%=c.getDireccion()%>">
            </div>
            <div class="form-group">
                <label for="txttel" class="form-label">TELEFONO:</label>
                <input type="text" class="form-control" name="txttel" value="<%=c.getTelefono()%>">
            </div>
            <div class="form-group">
                <label for="txtemail" class="form-label">EMAIL:</label>
                <input type="text" class="form-control" name="txtemail" value="<%=c.getEmail()%>">
            </div>
            <input type="hidden" name="txtvdni" value="">
            <input type="submit" class="btn btn-primary" name="accion" value="Actualizar">
            <a href="ControladorCliente?accion=listar" class="btn btn-secondary">Regresar</a>
        </form>
    </div>
    
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>
</html>


<%-- 
    Document   : editar
    Created on : 21 may 2023, 10:39:52
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
        <title>JSP Page</title>
    </head>
    <body>
        <%
            EmpleadoDAO dao=new EmpleadoDAO();
            String vdni=(String)request.getParameter("vdni");
            Empleado empleado=(Empleado) dao.list(vdni);
        %>
        
        <h1>MODIFICAR EMPLEADO</h1>
        <form action="ControladorEmpleado">
            DNI:<BR>
            <input type="text" name="txtdni" value="<%=empleado.getDni()%>"><br>
            DIRECCION:<BR>
            <input type="text" name="txtdir" value="<%=empleado.getDireccion()%>"><br>
            EMAIL:<BR>
            <input type="text" name="txtemail" value="<%=empleado.getEmail()%>"><br>
            TELEFONO:<BR>
            <input type="text" name="txttel" value="<%=empleado.getTelefono()%>"><br>
            CLAVE:<BR>
            <input type="text" name="txtclave" value="<%=empleado.getClave()%>"><br>
            ESTADO:<BR>
            <input type="text" name="txtestado" value="<%=empleado.getEstado()%>"><br>
            <input type="hidden" name="txtvdni" value=""><br>
            <input type="submit" name="accion" value="Actualizar"><br>
            <a href="ControladorEmpleado?accion=listar">Regresar
            
            
        </form>
        
        
    </body>
</html>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Modificar Empleado - Supermercado</title>
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

        form {
            max-width: 400px;
            margin: 0 auto;
        }

        label {
            font-weight: bold;
            margin-bottom: 5px;
        }

        input[type="text"] {
            width: 100%;
            padding: 10px;
            border-radius: 4px;
            border: 1px solid #ced4da;
            margin-bottom: 10px;
        }

        input[type="submit"] {
            background-color: #007bff;
            border: none;
            color: #ffffff;
            padding: 10px 20px;
            font-size: 14px;
            border-radius: 4px;
        }

        input[type="submit"]:hover {
            background-color: #0069d9;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Modificar Empleado</h1>
        <form action="ControladorEmpleado" method="post">
            <div class="form-group">
                <label for="txtdni">DNI:</label>
                <input type="text" class="form-control" id="txtdni" name="txtdni" value="<%=empleado.getDni()%>">
            </div>
            <div class="form-group">
                <label for="txtdir">DIRECCION:</label>
                <input type="text" class="form-control" id="txtdir" name="txtdir" value="<%=empleado.getDireccion()%>">
            </div>
            <div class="form-group">
                <label for="txtemail">EMAIL:</label>
                <input type="text" class="form-control" id="txtemail" name="txtemail" value="<%=empleado.getEmail()%>">
            </div>
            <div class="form-group">
                <label for="txttel">TELEFONO:</label>
                <input type="text" class="form-control" id="txttel" name="txttel" value="<%=empleado.getTelefono()%>">
            </div>
            <div class="form-group">
                <label for="txtclave">CLAVE:</label>
                <input type="text" class="form-control" id="txtclave" name="txtclave" value="<%=empleado.getClave()%>">
            </div>
            <div class="form-group">
                <label for="txtestado">ESTADO:</label>
                <input type="text" class="form-control" id="txtestado" name="txtestado" value="<%=empleado.getEstado()%>">
            </div>
            <input type="hidden" name="txtvdni" value="">
            <input type="submit" class="btn btn-primary" name="accion" value="Actualizar">
        </form>
    </div>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>
</html>

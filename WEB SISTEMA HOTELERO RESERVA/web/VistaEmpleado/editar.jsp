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
    <title>Modificar Empleado - Hoteleria</title>
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
        
        <%
            EmpleadoDAO dao=new EmpleadoDAO();
            String vidString = request.getParameter("vid");
            int vid;
            try {
                vid = Integer.parseInt(vidString);
            } catch (NumberFormatException e) {
            //System.out.println("Error: El valor proporcionado no es un número válido.");
                // Manejo de la excepción si el valor no es un número válido
                // Puedes mostrar un mensaje de error o asignar un valor por defecto a vid
                vid = 0; // Por ejemplo, asignando 0 en caso de error
            }
            Empleado empleado=(Empleado) dao.list(vid);
        %>
        
        <h1>Modificar Empleado</h1>
        
        <form action="ControladorEmpleado" method="post">
            <div class="form-group">
                <label for="txtid" class="form-label">ID:</label>
                <input type="text" class="form-control" name="txtid" value="<%=empleado.getId()%>">
            </div>
            <div class="form-group">
                <label for="txtdni" class="form-label">DNI:</label>
                <input type="text" class="form-control" name="txtdni" value="<%=empleado.getDni()%>">
            </div>
            <div class="form-group">
                <label for="txtclave" class="form-label">CONTRASEÑA:</label>
                <input type="password" class="form-control" name="txtclave" id="txtclave" value="<%=empleado.getClave()%>">
            </div>
            <div class="form-check">
                <input type="checkbox" class="form-check-input" id="chkMostrarClave">
                <label class="form-check-label" for="chkMostrarClave">Mostrar contraseña</label>
            </div>
            <div class="form-group">
                <label for="txtnom" class="form-label">NOMBRE:</label>
                <input type="text" class="form-control" name="txtnom" value="<%=empleado.getNombre()%>">
            </div>
            <div class="form-group">
                <label for="txtape" class="form-label">APELLIDO:</label>
                <input type="text" class="form-control" name="txtape" value="<%=empleado.getApellido()%>">
            </div>
            <div class="form-group">
                <label for="txtema" class="form-label">EMAIL:</label>
                <input type="text" class="form-control" name="txtema" value="<%=empleado.getEmail()%>">
            </div>
            <div class="form-group">
                <label for="txttel" class="form-label">TELEFONO:</label>
                <input type="text" class="form-control" name="txttel" value="<%=empleado.getTelefono()%>">
            </div>
            <div class="form-group">
                <label for="txthor" class="form-label">HORARIO:</label>
                <input type="text" class="form-control" name="txthor" value="<%=empleado.getHorario()%>">
            </div>
            <div class="form-group">
                <label for="txtcargo_id" class="form-label">CARGO:</label>
                <select class="form-control" name="txtcargo_id" value="<%=empleado.getHorario()%>">
                  <option value="1" <% if (empleado.getCargo_id() == 1) { %>selected<% } %>>1</option>
                  <option value="2" <% if (empleado.getCargo_id() == 2) { %>selected<% } %>>2</option>
                </select>
            </div>
            <input type="hidden" name="txtvid" value="">
            <input type="submit" class="btn btn-primary" name="accion" value="Actualizar">
        </form>
    </div>
            
    <script>
        var txtClave = document.getElementById("txtclave");
        var chkMostrarClave = document.getElementById("chkMostrarClave");

        chkMostrarClave.addEventListener("change", function() {
            if (chkMostrarClave.checked) {
                txtClave.type = "text";
            } else {
                txtClave.type = "password";
            }
        });
    </script>   
            
            
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>
</html>

<%-- 
    Document   : agregar
    Created on : 21 may 2023, 10:39:56
    Author     : USUARIO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Agregar Empleado - Supermercado</title>
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
        <h1>Agregar Empleado</h1>
        <form action="ControladorEmpleado" method="post">
            <div class="form-group">
                <label for="txtdni">DNI:</label>
                <input type="text" class="form-control" id="txtdni" name="txtdni">
            </div>
            <div class="form-group">
                <label for="txtdir">DIRECCION:</label>
                <input type="text" class="form-control" id="txtdir" name="txtdir">
            </div>
            <div class="form-group">
                <label for="txtema">EMAIL:</label>
                <input type="text" class="form-control" id="txtema" name="txtema">
            </div>
            <div class="form-group">
                <label for="txttel">TELEFONO:</label>
                <input type="text" class="form-control" id="txttel" name="txttel">
            </div>
            <div class="form-group">
                <label for="txtclav">CLAVE:</label>
                <input type="text" class="form-control" id="txtclav" name="txtclav">
            </div>
            <div class="form-group">
                <label for="txtestado">ESTADO:</label>
                <input type="text" class="form-control" id="txtestado" name="txtestado">
            </div>
            <input type="submit" class="btn btn-primary" name="accion" value="Agregar">
        </form>
    </div>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>
</html>

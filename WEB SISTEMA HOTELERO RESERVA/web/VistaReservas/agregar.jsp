<%-- 
    Document   : agregar.jsp
    Created on : 21 may 2023, 10:02:26
    Author     : USUARIO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Agregar Reserva - Gestion</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <style>
        body {
            background-color: #f8f9fa;
            color: #333333;
            font-family: Arial, sans-serif;
        }

        .container {
            margin-top: 50px;
            max-width: 500px;
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
        <h1 class="mt-4">AGREGAR RESERVA</h1>
        <form action="ControladorReservas" class="mt-4">
<!--            <div class="form-group">
                <label for="txtid" class="form-label">ID:</label>
                <input type="text" class="form-control" name="txtid">
            </div>-->
            <div class="form-group">
                <label for="txtc_dni" class="form-label">CLIENTE DNI:</label>
                <input type="text" class="form-control" name="txtc_dni">
            </div>
            <div class="form-group">
                <label for="txth_id" class="form-label">HABITACION ID:</label>
                <input type="text" class="form-control" name="txth_id">
            </div>
            <div class="form-group">
                <label for="txtf_en" class="form-label">FECHA ENTRADA:</label>
                <input type="text" class="form-control" name="txtf_en">
            </div>
            <div class="form-group">
                <label for="txtf_sal" class="form-label">FECHA SALIDA:</label>
                <input type="text" class="form-control" name="txtf_sal">
            </div>
            <div class="form-group">
                <label for="txtest" class="form-label">ESTADO:</label>
                <input type="text" class="form-control" name="txtest" value="Reservado" readonly>
            </div>
            
            <input type="submit" class="btn btn-primary" name="accion" value="Agregar">
        </form>
    </div>
    
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>
</html>

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
    <title>Agregar Usuario</title>
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
        <h1 class="mt-4">AGREGAR USUARIO</h1>
        <form action="ControladorUsuarios" class="mt-4">
            <div class="form-group">
                <label for="txtdni" class="form-label">DNI:</label>
                <input type="text" class="form-control" name="txtdni">
            </div>
            <div class="form-group">
                <label for="txtclave" class="form-label">CONTRASEÑA:</label>
                <input type="password" class="form-control" name="txtclave" id="txtclave">
            </div>
            <div class="form-check">
                <input type="checkbox" class="form-check-input" id="chkMostrarClave">
                <label class="form-check-label" for="chkMostrarClave">Mostrar contraseña</label>
            </div>
            <div class="form-group">
                <label for="txtnom" class="form-label">NOMBRE:</label>
                <input type="text" class="form-control" name="txtnom">
            </div>
            <div class="form-group">
                <label for="txtape" class="form-label">APELLIDO:</label>
                <input type="text" class="form-control" name="txtape">
            </div>
            <div class="form-group">
                <label for="txtema" class="form-label">EMAIL:</label>
                <input type="text" class="form-control" name="txtema">
            </div>
            <div class="form-group">
                <label for="txttel" class="form-label">TELEFONO:</label>
                <input type="text" class="form-control" name="txttel">
            </div>
            <div class="form-group">
                <label for="txtest" class="form-label">ESTADO:</label>
                <input type="text" class="form-control" name="txtest" value="A" readonly>
            </div>
            <div class="form-group">
                <label for="txtfk_cargo" class="form-label">CARGO:</label>
                <select class="form-control" name="txtfk_cargo" id="txtfk_cargo" value="1">
                  <option value=1>Administrador</option>
                  <option value=2>Cliente</option>
                </select>
            </div>
            
            <input type="submit" class="btn btn-primary" name="accion" value="Agregar">
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

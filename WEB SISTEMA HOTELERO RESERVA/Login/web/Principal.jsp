<%-- 
    Document   : principal
    Created on : 18 may 2023, 11:48:23
    Author     : USUARIO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <title>JSP Page</title>
    <style>
        body {
            padding-top: 60px;
            font-family: Arial, sans-serif;
        }

        .navbar {
            padding-top: 10px;
            padding-bottom: 10px;
        }

        .navbar-toggler {
            color: white;
            border-color: white;
        }

        .dropdown-menu {
            margin-top: 10px;
            padding: 10px;
        }

        .sidebar {
            position: fixed;
            top: 0;
            left: -250px;
            width: 250px;
            height: 100vh;
            background: #343a40;
            transition: all 0.3s ease;
        }

        .sidebar.show {
            left: 0;
        }

        .sidebar .nav-link {
            color: white;
        }

        .content {
            margin-left: 250px;
        }
    </style>
</head>
<body>
    <nav class="navbar navbar-dark bg-dark fixed-top">
        <a style="color: white" class="navbar-toggler" id="sidebarCollapse"><span class="navbar-toggler-icon"></span> HOME</a>
        <div class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                Cerrar Sesión
            </a>
            <div class="dropdown-menu text-center">
                <a><img src="img/img1.png" height="40" width="40"></a><br>
                <a>${nom}</a>
                <a>${correo}</a>
                <div class="dropdown-divider"></div>
                <a href="index.jsp" class="dropdown-item">Salir</a>
            </div>
        </div>
    </nav>

    <div class="sidebar" id="sidebar">
        <div class="list-group">
            <a href="ControladorCliente?accion=listar" class="list-group-item list-group-item-action">CLIENTE</a>
            <a href="ControladorEmpleado?accion=listar" class="list-group-item list-group-item-action">EMPLEADO</a>
            <a href="ControladorProducto?accion=listar" class="list-group-item list-group-item-action">PRODUCTO</a>
            <a href="ProductosCompras.jsp" class="list-group-item list-group-item-action">COMPRAS</a>
        </div>
    </div>

    <div class="content">
        <div class="container mt-4">
            <h1>Bienvenido al sistema...<strong>Admin: ${nom}</strong></h1>
        </div>

        <div class="container mt-4">
            <h3>CRUD CON MYSQL!</h3>
        </div>
    </div>

    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.3/dist/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
    <script>
        $(document).ready(function() {
            $('#sidebarCollapse').on('click', function() {
                $('#sidebar').toggleClass('show');
            });
        });
    </script>
</body>
</html>

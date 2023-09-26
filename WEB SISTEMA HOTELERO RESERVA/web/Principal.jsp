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
            background-image: url("images/2.jpg");
            background-size: cover;
            background-position: center;
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
            margin-left: 130px;
        }

        .btn-custom-container {
            margin-top: 100px;
            display: flex;
            justify-content: space-between;
            margin-bottom: 20px;
        }

        .btn-custom {
            width: 300px;
            height: 300px;
            border-radius: 50%;
            background-size: cover;
            background-position: center;
            background-repeat: no-repeat;
            display: flex;
            justify-content: center;
            align-items: center;
            color: white;
            font-size: 24px;
            font-weight: bold;
            text-decoration: none;
        }
        
        .btn-custom.usuarios {
            background-image: url("images/usuarios.png");
        }
        
        .btn-custom.habitaciones {
            background-image: url("images/habitaciones.png");
        }
        
        .btn-custom.reservas {
            background-image: url("images/reservas.png");
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
                <a>${dni}</a>
                <div class="dropdown-divider"></div>
                <a href="index.jsp" class="dropdown-item">Salir</a>
            </div>
        </div>
    </nav>

    <div class="content">
        <div class="container mt-4">
            <h1>Bienvenido al sistema...<strong>ADMINISTRADOR: ${dni}</strong></h1>
        </div>

        <div class="container mt-4">
            <h3>SISTEMA GESTION HOTELERA</h3>
            
            <div class="btn-custom-container">
                
                <a href="ControladorUsuarios?accion=listar" class="btn-custom usuarios">USUARIOS</a>
                <a href="ControladorHabitaciones?accion=listar" class="btn-custom habitaciones">HABITACIONES</a>
                <a href="ControladorReservas?accion=listar" class="btn-custom reservas">RESERVAS</a>
            </div>
            
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

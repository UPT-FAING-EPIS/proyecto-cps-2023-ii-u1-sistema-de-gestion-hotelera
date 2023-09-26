<%-- 
    Document   : editar
    Created on : 21 may 2023, 10:39:52
    Author     : USUARIO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<%@page import="Modelo.Habitaciones"%>
<%@page import="ModeloDAO.HabitacionesDAO"%>
<%@page import="java.util.*"%>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Modificar Habitacion - Gestion</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <style>
        .form-label {
            font-weight: bold;
        }
    </style>
</head>
<body>
    <div class="container">
        <%
            HabitacionesDAO dao = new HabitacionesDAO();
            //int vid = (int) request.getParameter("vid");
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
            Habitaciones habitacion = (Habitaciones) dao.list(vid);
        %>
        
        <h1 class="mt-4">MODIFICAR HABITACION</h1>
        <form action="ControladorHabitaciones" class="mt-4">
            <div class="form-group">
                <label for="txtid" class="form-label">ID HABITACION:</label>
                <input type="text" class="form-control" name="txtid" value="<%=habitacion.getId() %>">
            </div>
            <div class="form-group">
                <label for="txtnum" class="form-label">NUMERO:</label>
                <input type="text" class="form-control" name="txtnum" value="<%=habitacion.getNumero() %>">
            </div>
            <div class="form-group">
                <label for="txttip" class="form-label">TIPO:</label>
                <input type="text" class="form-control" name="txttip" id="txttip" value="<%=habitacion.getTipo() %>">
            </div>
            <div class="form-group">
                <label for="txtpre" class="form-label">PRECIO:</label>
                <input type="text" class="form-control" name="txtpre" id="txtpre" value="<%=habitacion.getPrecio() %>">
            </div>
            <div class="form-group">
                <label for="txtestado" class="form-label">ESTADO:</label>
                <select class="form-control" name="txtestado" id="txtestado" value="<%=habitacion.getEstado() %>">
                  <option value="Disponible">Disponible</option>
                  <option value="Ocupado">Ocupado</option>
                </select>
              </div>
            <input type="hidden" name="txtvid" value=0>
            <input type="submit" class="btn btn-primary" name="accion" value="Actualizar">
            <a href="ControladorHabitaciones?accion=listar" class="btn btn-secondary">Regresar</a>
        </form>
    </div>
    
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    
    <script>
        // Obtener el campo de entrada
        var txtpre = document.getElementById('txtpre');

        // Agregar evento de escucha para el evento "input"
        txtpre.addEventListener('input', function(e) {
            // Obtener el valor actual del campo de entrada
            var valor = txtpre.value;

            // Verificar si el valor ingresado es un número float válido
            if (valor === "") {
                // Si no se ingresa nada, establecer el valor predeterminado como 0
                txtpre.value = "0";
            } else if (isNaN(parseFloat(valor))) {
                // Si no es un número float válido, borrar el contenido del campo de entrada
                txtpre.value = "";
            }
        });
    </script>
</body>
</html>
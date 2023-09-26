<%-- 
    Document   : agregar.jsp
    Created on : 21 may 2023, 10:02:26
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
    <title>Agregar Reserva - Gestion</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://code.jquery.com/ui/1.13.0/themes/base/jquery-ui.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://code.jquery.com/ui/1.13.0/jquery-ui.js"></script>
    
    
   
<!--    <script>
        function mostrarAlerta() {
            alert("Reserva Exitosa");
        }
    </script>-->
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

<%
                HabitacionesDAO dao = new HabitacionesDAO();
                List<Habitaciones> list = dao.listar();
                Iterator<Habitaciones> iter = list.iterator();
                Habitaciones hab = null;
            %>


<body>
    <div class="container">
        <h1 class="mt-4">AGREGAR RESERVA</h1>
        <form action="ControladorAgregarReservas" class="mt-4">
<!--            <div class="form-group">
                <label for="txtid" class="form-label">ID:</label>
                <input type="text" class="form-control" name="txtid">
            </div>-->
            <div class="form-group">
                <label for="txtc_dni" class="form-label">CLIENTE DNI:</label>
                <input type="text" class="form-control" name="txtc_dni">
            </div>
            <div class="form-group">
            <label for="txth_id" class="form-label">HABITACIONES:</label>
            <select class="form-control" id="txth_id" name="txth_id">
                <%while (iter.hasNext()) {
                    hab = iter.next();
                %> 
                <option value="<%= hab.getId()%>" data-price="<%=hab.getPrecio()%>" data-enable="<%= hab.getEstado()%>" ><%= hab.getTipo()%> <%= hab.getNumero()%></option>
                    <%}%> 
            </select>
            </div>
            <div class="form-group">
                <label for="txtf_re" class="form-label">FECHA RESERVA:</label>
                <input type="text" class="form-control" id="txtf_re" name="txtf_re">
            </div>
            <div class="form-group">
                <label for="txtest" class="form-label">ESTADO:</label>
                <input type="text" class="form-control" name="txtest" value="Pendiente" readonly>
            </div>
             <div class="form-group">
                <label for="txtf_en" class="form-label">FECHA ENTRADA:</label>
                <input type="date" class="form-control" id="txtf_en" name="txtf_en" pattern="\d{4}-\d{2}-\d{2} onchange="calcularDiferencia()">
            </div>
            <div class="form-group">
                <label for="txtf_sal" class="form-label">FECHA SALIDA:</label>
                <input type="date" class="form-control" id="txtf_sal" name="txtf_sal" pattern="\d{4}-\d{2}-\d{2} onchange="calcularDiferencia()">
            </div>
            <div class="form-group">
                <label for="txtp_tot" class="form-label">PRECIO A PAGAR:</label>
                <input type="text" class="form-control" id="txtp_tot" name="txtp_tot" readonly>
            </div>
            <div class="form-group">
                
                <label for="txtp_tot" class="form-label">Nota: Poner en la descripcion del yape el nro de dni, se verificara a la hora de Ingreso y se validara el pago correspondiente</label>
                <br>
                <img src="images/pagoyape.jpeg" alt="Imagen" width="400" height="400">
            </div>

            
<!--            <input type="submit" class="btn btn-primary" name="accion" value="Agregar" onclick="mostrarAlerta()">-->
            
            <input id="btn-reservar" type="submit" class="btn btn-primary" name="accion" value="Agregar">
            <p id="p-message"></p>
            
        </form>
    </div>
    
    <script>
    function calcularDiferencia() {
        var fechaEntrada = new Date(document.getElementById('txtf_en').value);
        var fechaSalida = new Date(document.getElementById('txtf_sal').value);

        if (fechaSalida <= fechaEntrada) {
            alert('La fecha de salida debe ser posterior a la fecha de entrada.');
            return;
        }

        var diferenciaEnMilisegundos = fechaSalida.getTime() - fechaEntrada.getTime();
        var diferenciaEnDias = Math.floor(diferenciaEnMilisegundos / (1000 * 60 * 60 * 24));

        // Obtener el precio de la habitación seleccionada
        var selectHabitacion = document.getElementById('txth_id');
        var precioHabitacion = parseFloat(selectHabitacion.options[selectHabitacion.selectedIndex].dataset.price);
        
        // Calcular el precio total a pagar
        var precioTotal = diferenciaEnDias * precioHabitacion;

        // Mostrar el precio total en el campo de texto
        document.getElementById('txtp_tot').value = isNaN(precioTotal) ? "" : parseInt(precioTotal);

        // Puedes hacer cualquier otra cosa con la variable "diferenciaEnDias" y "precioTotal"
        console.log('La diferencia de días es: ' + diferenciaEnDias);
        console.log('El precio total a pagar es: ' + precioTotal);
    }

    // Asignar el evento onchange a los campos de entrada de fecha
    document.getElementById('txtf_en').addEventListener('change', calcularDiferencia);
    document.getElementById('txtf_sal').addEventListener('change', calcularDiferencia);
    
</script>
    
    <script>
        var HabitacionSelect = document.getElementById('txth_id');
        
        HabitacionSelect.addEventListener('change', calcularDiferencia);
        HabitacionSelect.addEventListener('change',function(){
            var disponibleHabitacion = this.options[this.selectedIndex].dataset.enable;
            console.log("Estado => "+disponibleHabitacion)
            if(disponibleHabitacion == "Disponible"){
                document.querySelector("#btn-reservar").disabled = false
                document.querySelector("#p-message").innerText = ""
            }else{
                document.querySelector("#btn-reservar").disabled = true
                document.querySelector("#p-message").innerText = "Habitacion Reservada o en uso"
            }
        })
    </script>
    
    
    <script>
        // Obtener el elemento de entrada de fecha de entrada
        var fechaEntradaInput = document.getElementById('txtf_en');

        // Establecer el mínimo de fechas seleccionables como el día siguiente al actual
        var fechaActual = new Date();
        fechaActual.setDate(fechaActual.getDate() + 1);
        var fechaMinima = fechaActual.toISOString().split('T')[0];
        fechaEntradaInput.min = fechaMinima;

        // Obtener el elemento de entrada de fecha de salida
        var fechaSalidaInput = document.getElementById('txtf_sal');

        // Establecer el mínimo de fechas seleccionables como el día siguiente al actual
        fechaSalidaInput.min = fechaMinima;

        // Agregar validación en el evento onchange del campo de fecha de salida
        fechaSalidaInput.onchange = function() {
            var fechaEntrada = new Date(fechaEntradaInput.value);
            var fechaSalida = new Date(fechaSalidaInput.value);

            if (fechaSalida <= fechaEntrada) {
                fechaSalidaInput.value = '';
                alert('La fecha de salida debe ser posterior a la fecha de entrada.');
            }
        };
    </script>

    
    <script>
    // Obtener el elemento de entrada de fecha
    var fechaReservaInput = document.getElementById('txtf_re');

    // Obtener la fecha actual
    var fechaActual = new Date().toISOString().split('T')[0];

    // Establecer el valor del campo de entrada de fecha como la fecha actual
    fechaReservaInput.value = fechaActual;

    // Bloquear el campo de entrada de fecha
    fechaReservaInput.setAttribute('readonly', 'readonly');
</script>
    
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>
</html>

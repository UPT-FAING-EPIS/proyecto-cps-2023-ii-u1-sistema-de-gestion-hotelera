/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Modelo.Reservas;
import ModeloDAO.ReservasDAO;

import javax.servlet.RequestDispatcher;

/**
 *
 * @author USUARIO
 */
public class ControladorReservas extends HttpServlet {
    
    
    String Listar="VistaReservas/listar.jsp";
    String add="VistaReservas/agregar.jsp";
    String edit="VistaReservas/editar.jsp";
    Reservas res=new Reservas();
    ReservasDAO dao=new ReservasDAO();
    
    

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControladorReservas</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorReservas at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        String acceso="";
        String action=request.getParameter("accion");
        if(action.equalsIgnoreCase("listar")){
            acceso=Listar;
        }
         else if (action.equalsIgnoreCase("add")){
            acceso=add;
        }
        else if(action.equalsIgnoreCase("Agregar")){
            
            int vid = Integer.parseInt(request.getParameter("txtid"));
            String vc_dni=request.getParameter("txtc_dni");
            int vh_id = Integer.parseInt(request.getParameter("txth_id"));
            String vf_en=request.getParameter("txtf_en");
            String vf_sal=request.getParameter("txtf_sal");
            String vest=request.getParameter("txtest");
            
            res.setId(vid);
            res.setCliente_dni(vc_dni);
            res.setHabitacion_id(vh_id);
            res.setFecha_entrada(vf_en);
            res.setFecha_salida(vf_sal);
            res.setEstado(vest);
            dao.add(res);
            acceso=Listar;
        }
        else if (action.equalsIgnoreCase("eliminar")){
            int vid = Integer.parseInt(request.getParameter("vid"));
            dao.eliminar(vid);
            acceso=Listar;
        }
        else if (action.equalsIgnoreCase("editar")){
            request.setAttribute("valid",request.getParameter("vid"));
            acceso=edit;
        }
        else if(action.equalsIgnoreCase("Actualizar")){
            int vid = Integer.parseInt(request.getParameter("txtid"));
            String vc_dni=request.getParameter("txtc_dni");
            int vh_id = Integer.parseInt(request.getParameter("txth_id"));
            String vf_en=request.getParameter("txtf_en");
            String vf_sal=request.getParameter("txtf_sal");
            String vest=request.getParameter("txtest");
            
            res.setId(vid);
            res.setCliente_dni(vc_dni);
            res.setHabitacion_id(vh_id);
            res.setFecha_entrada(vf_en);
            res.setFecha_salida(vf_sal);
            res.setEstado(vest);
            dao.edit(res);
            acceso=Listar;
        }
        
        RequestDispatcher vista=request.getRequestDispatcher(acceso);
        vista.forward(request,response);
        
        //processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

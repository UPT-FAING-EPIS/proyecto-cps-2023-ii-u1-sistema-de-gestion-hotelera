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
import Modelo.Habitaciones;
import ModeloDAO.HabitacionesDAO;

import javax.servlet.RequestDispatcher;

/**
 *
 * @author USUARIO
 */
public class ControladorHabitacionesVista extends HttpServlet {
    
    
    String Listar="VistaHabitaciones/listaruser.jsp";
    String add="VistaHabitaciones/listaruser.jsp";
    Habitaciones hab=new Habitaciones();
    HabitacionesDAO dao=new HabitacionesDAO();

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
            out.println("<title>Servlet ControladorHabitacionesVista</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorHabitacionesVista at " + request.getContextPath() + "</h1>");
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
            String vnum=request.getParameter("txtnum");
            String vtip=request.getParameter("txttip");
            //String vcan=request.getParameter("txtcan");
            //String cantidadStr = Integer.toString(vcan);
            //String vpru=request.getParameter("txtpru");
            float vpre = Float.parseFloat(request.getParameter("txtpre"));
            //String cantidadStr = Integer.toString(vcan);
            String vestad=request.getParameter("txtestado");
            hab.setId(vid);
            hab.setNumero(vnum);
            //prod.setCantidad(request.getParameter("txtcan"));
            hab.setTipo(vtip);
            hab.setPrecio(vpre);
            hab.setEstado(vestad);
            
            dao.add(hab);
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

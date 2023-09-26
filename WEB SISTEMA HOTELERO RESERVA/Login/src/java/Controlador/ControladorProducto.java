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
import Modelo.Producto;
import ModeloDAO.ProductoDAO;

import javax.servlet.RequestDispatcher;

/**
 *
 * @author USUARIO
 */
public class ControladorProducto extends HttpServlet {
    
    
    String Listar="VistaProducto/listar.jsp";
    String add="VistaProducto/agregar.jsp";
    String edit="VistaProducto/editar.jsp";
    Producto prod=new Producto();
    ProductoDAO dao=new ProductoDAO();

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
            out.println("<title>Servlet ControladorProducto</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorProducto at " + request.getContextPath() + "</h1>");
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
            String vcodigo=request.getParameter("txtcodigo");
            String vnom=request.getParameter("txtnom");
            //String vcan=request.getParameter("txtcan");
            int vcan = Integer.parseInt(request.getParameter("txtcan"));
            //String cantidadStr = Integer.toString(vcan);
            //String vpru=request.getParameter("txtpru");
            float vpru = Float.parseFloat(request.getParameter("txtpru"));
            //String cantidadStr = Integer.toString(vcan);
            String vestad=request.getParameter("txtestado");
            prod.setCodigo(vcodigo);
            prod.setNombre(vnom);
            //prod.setCantidad(request.getParameter("txtcan"));
            prod.setCantidad(vcan);
            prod.setPrunitario(vpru);
            prod.setEstado(vestad);
            
            dao.add(prod);
            acceso=Listar;
        }
        else if (action.equalsIgnoreCase("eliminar")){
            String vcodigo=request.getParameter("vcodigo");
            dao.eliminar(vcodigo);
            acceso=Listar;
        }
        else if (action.equalsIgnoreCase("editar")){
            request.setAttribute("valcodigo",request.getParameter("vcodigo"));
            acceso=edit;
        }
        else if(action.equalsIgnoreCase("Actualizar")){
            String vcodigo=request.getParameter("txtcodigo");
            String vnom=request.getParameter("txtnom");
            //String vcan=request.getParameter("txtcan");
            int vcan = Integer.parseInt(request.getParameter("txtcan"));
            //String cantidadStr = Integer.toString(vcan);
            //String vpru=request.getParameter("txtpru");
            float vpru = Float.parseFloat(request.getParameter("txtpru"));
            //String cantidadStr = Integer.toString(vcan);
            String vestad=request.getParameter("txtestado");
            prod.setCodigo(vcodigo);
            prod.setNombre(vnom);
            //prod.setCantidad(request.getParameter("txtcan"));
            prod.setCantidad(vcan);
            prod.setPrunitario(vpru);
            prod.setEstado(vestad);
            
            dao.edit(prod);
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

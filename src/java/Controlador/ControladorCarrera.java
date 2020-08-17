/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Carrera;
import ModeloDAO.CarreraDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ControladorCarrera")
public class ControladorCarrera extends HttpServlet {
    String listarcarrera = "Vista/ListarCarrera.jsp";
    String agregarcarrera = "Vista/AgregarCarrera.jsp";
    String editarcarrera = "Vista/EditarCarrera.jsp";
    Carrera carrera = new Carrera();
    CarreraDAO carreraDAO = new CarreraDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acceso = "";
        String s_accion = request.getParameter("f_accion");
        if (s_accion.equalsIgnoreCase("listarcarrera")) {
            acceso = listarcarrera;
        }else if (s_accion.equalsIgnoreCase("agregarcarrera01")) {
            acceso = agregarcarrera;
        }else if (s_accion.equalsIgnoreCase("agregarcarrera02")) {
            String s_nombre = request.getParameter("f_nombre");
            String s_estado = request.getParameter("f_estado");
            carrera.setNombre(s_nombre);
            carrera.setEstado(s_estado);
            carreraDAO.agregarcarrera(carrera);
            acceso = listarcarrera;
            
        }else if (s_accion.equalsIgnoreCase("editarcarrera01")) {
            request.setAttribute("f_idcarrera", request.getParameter("f_idcarrera"));
            acceso = editarcarrera;
        }else if (s_accion.equalsIgnoreCase("editarcarrera02")) {
            int s_idcarrera = Integer.valueOf(request.getParameter("f_idcarrera"));
            String s_nombre = request.getParameter("f_nombre");
            String s_estado = request.getParameter("f_estado");
       
            carrera.setIdcarrera(s_idcarrera);            
            carrera.setNombre(s_nombre);
            carrera.setEstado(s_estado);
            carreraDAO.editarcarrera(carrera);
            acceso = listarcarrera;
        }else if (s_accion.equals("eliminarcarrera")) {
            int s_idcarrera = Integer.valueOf(request.getParameter("f_idcarrera"));
            carreraDAO.eliminarcarrera(s_idcarrera);
            acceso = listarcarrera;
        }
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {   
    }

}

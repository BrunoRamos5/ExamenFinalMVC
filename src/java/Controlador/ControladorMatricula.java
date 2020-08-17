/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Matricula;
import ModeloDAO.MatriculaDAO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author TuNombre
 */
@WebServlet("/ControladorMatricula")
public class ControladorMatricula extends HttpServlet {

    String listarmatricula = "Vista/ListarMatricula.jsp";
    String agregarmatricula = "Vista/AgregarMatricula.jsp";
    String editarmatricula = "Vista/EditarMatricula.jsp";
    Matricula matricula = new Matricula();
    MatriculaDAO matriculaDAO = new MatriculaDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acceso = "";
        String s_accion = request.getParameter("f_accion");
        if (s_accion.equalsIgnoreCase("listarmatricula")) {
            acceso = listarmatricula;
        } else if (s_accion.equalsIgnoreCase("agregarmatricula01")) {
            acceso = listarmatricula;
        } else if (s_accion.equalsIgnoreCase("agregarmatricula02")) {
            String s_semestre = request.getParameter("f_semestre");
            int s_ciclo = Integer.valueOf(request.getParameter("f_ciclo"));
            String s_estado = request.getParameter("f_estado");
            int s_idcurso = Integer.valueOf(request.getParameter("f_idcurso"));
            int s_idestudiante = Integer.valueOf(request.getParameter("f_idestudiante"));
            int s_idcarrera = Integer.valueOf(request.getParameter("f_idcarrera"));

            matricula.setSemestre(s_semestre);
            matricula.setCiclo(s_ciclo);
            matricula.setEstado(s_estado);
            matricula.setIdcurso(s_idcurso);
            matricula.setIdestudiante(s_idestudiante);
            matricula.setIdcarrera(s_idcarrera);
            matriculaDAO.agregarmatricula(matricula);
            acceso = listarmatricula;

        } else if (s_accion.equalsIgnoreCase("editarmatricula01")) {
            request.setAttribute("f_idestudiante", request.getParameter("f_idestudiante"));
            acceso = listarmatricula;
        } else if (s_accion.equalsIgnoreCase("editarmatricula02")) {
            int s_idmatricula = Integer.valueOf(request.getParameter("f_idmatricula"));
            String s_semestre = request.getParameter("f_semestre");
            int s_ciclo = Integer.valueOf(request.getParameter("f_ciclo"));
            String s_estado = request.getParameter("f_estado");
            int s_idcurso = Integer.valueOf(request.getParameter("f_idcurso"));
            int s_idestudiante = Integer.valueOf(request.getParameter("f_idestudiante"));
            int s_idcarrera = Integer.valueOf(request.getParameter("f_idcarrera"));
            
            matricula.setIdmatricula(s_idmatricula);
            matricula.setSemestre(s_semestre);
            matricula.setCiclo(s_ciclo);
            matricula.setEstado(s_estado);
            matricula.setIdcurso(s_idcurso);
            matricula.setIdestudiante(s_idestudiante);
            matricula.setIdcarrera(s_idcarrera);
            matriculaDAO.agregarmatricula(matricula);
            matriculaDAO.editarmatricula(matricula);
            acceso = listarmatricula;
        } else if (s_accion.equals("eliminarmatricula")) {
            int s_idmatricula = Integer.valueOf(request.getParameter("f_idmatricula"));
            matriculaDAO.eliminarmatricula(s_idmatricula);
            acceso = listarmatricula;
        }
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

}

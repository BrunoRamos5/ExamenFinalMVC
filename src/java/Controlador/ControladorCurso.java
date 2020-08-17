/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Curso;
import ModeloDAO.CursoDAO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ControladorCurso")
public class ControladorCurso extends HttpServlet {
    String listarcurso = "Vista/ListarCurso.jsp";
    String agregarcurso = "Vista/AgregarCurso.jsp";
    String editarcurso = "Vista/EditarCurso.jsp";
    Curso curso = new Curso();
    CursoDAO cursoDAO = new CursoDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acceso = "";
        String s_accion = request.getParameter("f_accion");
        if (s_accion.equalsIgnoreCase("listarcurso")) {
            acceso = listarcurso;
        }else if (s_accion.equalsIgnoreCase("agregarcurso01")) {
            acceso = agregarcurso;
        }else if (s_accion.equalsIgnoreCase("agregarcurso02")) {
            String s_nombre = request.getParameter("f_nombre");
            String s_horas = request.getParameter("f_horas");
            String s_creditos = request.getParameter("f_creditos");
            String s_estado = request.getParameter("f_estado");
            curso.setNombre(s_nombre);
            curso.setHoras(Integer.parseInt(s_horas));
            curso.setCreditos(Integer.parseInt(s_creditos));
            curso.setEstado(s_estado);
            cursoDAO.agregarcurso(curso);
            acceso = listarcurso;
        }else if (s_accion.equalsIgnoreCase("editarcurso01")) {
            request.setAttribute("f_idcurso", request.getParameter("f_idcurso"));
            acceso = editarcurso;
        }else if (s_accion.equalsIgnoreCase("editarcurso02")) {
            int s_idcurso = Integer.valueOf(request.getParameter("f_idcurso"));
            String s_nombre = request.getParameter("f_nombre");
            int s_horas = Integer.valueOf(request.getParameter("f_horas"));
            int s_creditos = Integer.valueOf(request.getParameter("f_creditos"));
            String s_estado = request.getParameter("f_estado");
            curso.setIdcurso(s_idcurso);            
            curso.setNombre(s_nombre);
            curso.setHoras(s_horas);
            curso.setCreditos(s_creditos);
            curso.setEstado(s_estado);
            cursoDAO.editarcurso(curso);
            acceso = listarcurso;
        }else if (s_accion.equals("eliminarcurso")) {
            int s_idcurso = Integer.valueOf(request.getParameter("f_idcurso"));
            cursoDAO.eliminarcurso(s_idcurso);
            acceso = listarcurso;
        }
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}


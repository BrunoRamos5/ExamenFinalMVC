<%-- 
    Document   : ListarMatricula
    Created on : 17 ago. 2020, 02:06:18
    Author     : sis
--%>


<%@page import="Modelo.Matricula1"%>
<%@page import="Modelo.Matricula"%>
<%@page import="ModeloDAO.MatriculaDAO"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listar Matricula</title>
        <link href="CSS/bootstrap.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="container">
            <h1>Listado de Matriculas</h1>
            <a class="btn btn-success" href="${pageContext.request.contextPath}/ControladorMatricula?f_accion=agregarmatricula01">Agregar Nueva Matricula</a>
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th class="text-center">ID</th>
                        <th class="text-center">Semestre</th>
                        <th class="text-center">Ciclo</th>
                        <th class="text-center">Estado</th>
                        <th class="text-center">IdCurso</th>
                        <th class="text-center">IdEstudiante</th>
                        <th class="text-center">IdCarrera</th>
                        <th class="text-center">Acciones</th>
                    </tr>
                </thead>
                <tbody>

                    <%
                        MatriculaDAO matriculaDAO = new MatriculaDAO();
                        List<Matricula> matriculas = matriculaDAO.listarmatricula();
                        Iterator<Matricula> iterator = matriculas.iterator();
                        Matricula matricula = null;
                        while (iterator.hasNext()) {
                            matricula = iterator.next();
                    %>
                    <tr>
                        <td class="text-center"><% out.print(matricula.getIdmatricula()); %></td>
                        <td class="text-center"><% out.print(matricula.getSemestre()); %></td>
                        <td class="text-center"><% out.print(matricula.getCiclo()); %></td>
                        <td class="text-center"><% out.print(matricula.getEstado()); %></td>
                        <td class="text-center"><% out.print(matricula.getIdcurso()); %></td>
                        <td class="text-center"><% out.print(matricula.getIdestudiante()); %></td>
                        <td class="text-center"><% out.print(matricula.getIdcarrera()); %></td>
                        <td class="text-center">
                                <a class="btn btn-warning" href="${pageContext.request.contextPath}/ControladorMatricula?f_accion=editarmatricula01&f_idmatricula=<% out.print(matricula.getIdmatricula()); %>">
                                    Editar
                                </a>
                                <a class="btn btn-danger" href="${pageContext.request.contextPath}/ControladorMatricula?f_accion=eliminarmatricula&f_idmatricula=<% out.print(matricula.getIdmatricula()); %>">
                                    Eliminar
                                </a>
                        </td>
                    </tr>
                    <%    }
                    %>                    
                </tbody>
            </table>
            <table class="table table-bordered">
                <thead>
                    <tr>                        
                        <th class="text-center">Estudiante</th>
                        <th class="text-center">IdMatricula</th>
                        <th class="text-center">Semestre</th>
                        <th class="text-center">Ciclo</th>
                        <th class="text-center">Estado</th> 
                        <th class="text-center">Curso</th>
                        <th class="text-center">Carrera</th>
                    </tr>
                </thead>
                <tbody>

                    <%
                        List<Matricula1> matriculas1 = matriculaDAO.listarmatricula1();
                        Iterator<Matricula1> iterator1 = matriculas1.iterator();
                        Matricula1 matricula1 = null;
                        while (iterator1.hasNext()) {
                            matricula1 = iterator1.next();
                    %>
                    <tr>
                        <td class="text-center"><% out.print(matricula1.getEstudiante()); %></td>
                        <td class="text-center"><% out.print(matricula1.getIdmatricula()); %></td>
                        <td class="text-center"><% out.print(matricula1.getSemestre()); %></td>
                        <td class="text-center"><% out.print(matricula1.getCiclo()); %></td>
                        <td class="text-center"><% out.print(matricula1.getEstado()); %></td>
                        <td class="text-center"><% out.print(matricula1.getCurso()); %></td>
                        <td class="text-center"><% out.print(matricula1.getCarrera()); %></td>                       
                    </tr>
                    <%    }
                    %>                    
                </tbody>
            </table>
        </div>
    </body>
</html>

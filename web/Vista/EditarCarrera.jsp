<%-- 
    Document   : EditarCarrera
    Created on : 16/08/2020, 04:09:37 AM
    Author     : Usuario
--%>

<%@page import="Modelo.Carrera"%>
<%@page import="ModeloDAO.CarreraDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Carrera</title>
        <link href="CSS/bootstrap.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="container">
            <%
                CarreraDAO carreraDAO = new CarreraDAO();
                int s_idcarrera = Integer.valueOf(request.getParameter("f_idcarrera"));
                Carrera carrera = (Carrera)carreraDAO.buscarcarrera(s_idcarrera);
            %>
            <form name="EditarCarreraForm" action="${pageContext.request.contextPath}/ControladorCarrera" method="get">
                <table  class="table">
                    <thead>
                        <tr>
                            <th class="text-center" colspan="2">Editar Carrera</th>                            
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td class="text-right">Nombre</td>
                            <td><input class="form-control" type="text" name="f_nombre" value="<% out.println(carrera.getNombre()); %>" maxlength="30" size="20" /></td>
                        </tr>                    
                        <tr>
                            <td class="text-right">Estado</td>
                            <td><input class="form-control" type="text" name="f_estado" value="<% out.println(carrera.getEstado()); %>" maxlength="1" size="2" /></td>
                        </tr>
                        <tr>
                            <td colspan="2" class="text-center">
                                <input class="btn btn-primary" type="submit" value="Editar Carrera" name="editar" />
                                <input type="hidden" value="editarcarrera02" name="f_accion"/>
                                <input type="hidden" value="<% out.print(carrera.getIdcarrera()); %>" name="f_idcarrera">

                            </td>
                        </tr>

                    </tbody>
                </table>


            </form>
        </div>
    </body>
</html>
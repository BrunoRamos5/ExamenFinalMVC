<%-- 
    Document   : AgregarEstudiante
    Created on : 10/08/2020, 09:13:57 AM
    Author     : TuNombre
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>AgregarCurso</title>
        <link href="CSS/bootstrap.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="container">
            <form name="AgregarCursoForm" action="${pageContext.request.contextPath}/ControladorCurso" method="get">
                <table  class="table">
                    <thead>
                        <tr>
                            <th class="text-center" colspan="2">Agregar Curso</th>                            
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td class="text-right">Nombre</td>
                            <td><input class="form-control" type="text" name="f_nombre" value="" maxlength="30" size="20" /></td>
                        </tr>
                        
                        <tr>
                            <td class="text-right">Horas</td>
                            <td><input class="form-control" type="text" name="f_horas" value="" maxlength="8" size="8" /></td>
                        </tr>
                        <tr>
                            <td class="text-right">Creditos</td>
                            <td><input class="form-control" type="text" name="f_creditos" value="" maxlength="12" size="12" /></td>
                        </tr>
                        <tr>
                            <td class="text-right">Estado</td>
                            <td><input class="form-control" type="text" name="f_estado" value="" maxlength="1" size="2" /></td>
                        </tr>
                        <tr>
                            <td colspan="2" class="text-center">
                                <input class="btn-primary" type="submit" value="Agregar Curso" name="agregar" />
                                <input type="hidden" value="agregarcurso02" name="f_accion"/>
                                    
                            </td>
                        </tr>
                        
                    </tbody>
                </table>
                
            </form>
        </div>
    </body>
</html>

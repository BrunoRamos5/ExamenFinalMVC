<%-- 
    Document   : index
    Created on : 16 ago. 2020, 15:34:40
    Author     : sis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MENU REGISTRO</title>
        <link href="CSS/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" type="text/css" href="styles.css">
    </head>
    <body>
        <section class="wrap">
            <section id="info">             
                <div id="cards">
                    <div class="card">
                        <p class="icon">
                            E
                        </p>
                        <h2 class="category">Tabla Estudiantes</h2>
                        <p class="descripcion">
                            CRUD Para Tabla Estudiantes
                        </p>
                        <a href="${pageContext.request.contextPath}/ControladorEstudiante?f_accion=listarestudiante">Listar Estudiantes</a>
                    </div>
                    <div class="card">
                        <p class="icon">
                            C
                        </p>
                        <h2 class="category">Tabla Carreras</h2>
                        <p class="descripcion">
                            CRUD Para Tabla Carreras
                        </p>
                        <a  href="${pageContext.request.contextPath}/ControladorCarrera?f_accion=listarcarrera">Listar Carreras</a>
                    </div>
                    <div class="card">
                        <p class="icon">
                            C
                        </p>
                        <h2 class="category">Tabla Cursos</h2>
                        <p class="descripcion">
                            CRUD Para Tabla Cursos
                        </p>
                        <a href="${pageContext.request.contextPath}/ControladorCurso?f_accion=listarcurso">Listar Cursos</a>  
                    </div>
                    <div class="card">
                        <p class="icon">
                            M
                        </p>
                        <h2 class="category">Tabla Matrícula</h2>
                        <p class="descripcion">
                            CRUD Para Tabla Matrícula
                        </p>
                        <a href="${pageContext.request.contextPath}/ControladorMatricula?f_accion=listarmatricula">Listar Matricula</a>    
                    </div>
                </div>
            </section>
        </section>    
    </body>
</html>

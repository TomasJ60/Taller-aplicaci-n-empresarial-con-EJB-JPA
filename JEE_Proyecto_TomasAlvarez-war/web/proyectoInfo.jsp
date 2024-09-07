<%-- 
    Document   : proyectoInfo
    Created on : 5/09/2024, 06:53:11 PM
    Author     : tomas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Proyecto Taller aplicación empresarial con EJB-JPA</title>
    </head>
    <body>
        <h1>Taller aplicación empresarial con EJB-JPA - Manejo del espacio público - Tomas Alvarez Daza</h1>
        <form action="./ProyectoServlet" method="POST"> 
            <table>
                <tr>
                    <td>Id</td>
                    <td><input type="text" name="Id" value="${proyecto.id}" /></td> <!-- INTEGER -->
                </tr>
                <tr>
                    <td>Nombre</td>
                    <td><input type="text" name="nombre" value="${proyecto.nombre}" /></td> <!-- VARCHAR -->
                </tr>
                <tr>
                    <td>Apellido</td>
                    <td><input type="text" name="apellido" value="${proyecto.apellido}" /></td> <!-- VARCHAR -->
                </tr>
                <tr>
                    <td>Nombre del proyecto</td>
                    <td><input type="text" name="nombredelproyecto" value="${proyecto.nombredelproyecto}" /></td> <!-- VARCHAR -->
                </tr>
                <tr>
                    <td>descripcion</td>
                    <td><input type="text" name="descripcion" value="${proyecto.descripcion}" /></td> <!-- VARCHAR -->
                </tr>
                <tr>
                    <td>localidad</td>
                    <td><input type="text" name="localidad" value="${proyecto.localidad}" /></td> <!-- VARCHAR -->
                </tr>
                <tr>
                    <td>Presupuesto</td>
                    <td><input type="text" name="presupuesto" value="${proyecto.presupuesto}" /></td> <!-- VARCHAR -->
                </tr>
                <tr>
                    <td>Numero de habitantes</td>
                    <td><input type="text" name="numerodehabitantes" value="${proyecto.numerodehabitantes}" /></td> <!-- INTEGER -->
                </tr>
                
                <tr>
                    
                    <td colspan="2">
                        <input type="submit" name="action" value="Add" />
                        <input type="submit" name="action" value="Edit" />
                        <input type="submit" name="action" value="Delete" />
                        <input type="submit" name="action" value="Search" />
                    </td>
                </tr>
                <br>
            </table>
        </form>
        <br>
        <table border="1">
            <th>Id</th>
            <th>Nombre</th>
            <th>Apellido</th>
            <th>Nombre del proyecto</th>
            <th>Descripcion</th>
            <th>localidad</th>
            <th>Presupuesto</th>
            <th>Numero de habitantes</th>
                <c:forEach items="${allProyectos}" var="proy">
                <tr>
                    <td>${proy.id}</td>
                    <td>${proy.nombre}</td>
                    <td>${proy.apellido}</td>
                    <td>${proy.nombredelproyecto}</td>
                    <td>${proy.descripcion}</td>
                    <td>${proy.localidad}</td>
                    <td>${proy.presupuesto}</td>
                    <td>${proy.numerodehabitantes}</td>
                </tr>
            </c:forEach> 
        </table>
    </body>
</html>
<%@page import="java.util.ArrayList"%>
<%@page import="com.emergentes.Almacen"%>
<%
  if (session.getAttribute("almacen" )== null){
      ArrayList<Almacen> lisaux = new ArrayList<Almacen>();
      session.setAttribute("almacen", lisaux);
  }  

    ArrayList<Almacen> almacen = (ArrayList<Almacen>)session.getAttribute("almacen");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1> Ingrese sus Tareas </h1>
        <form action="MainServlet" method="post">
        <table>
            <tr>
                <td>Id</td>
                <td> <input type="text" name="id" value=""  placeholder="Ingrese ID"> </td>
            </tr>
            
            <tr>
                <td>Tarea</td>
                <td> <input type="text" name="tarea" value="" placeholder="Ingrese Tarea"> </td>
            </tr>
            <tr>
                <td></td>
                <td> <input type="submit" value="Procesar" /> </td>
            </tr>
        </table>
        </form>
        <br>
        <a href="MainServlet?t=vaciar">Nuevas Tareas </a>
        
        <h2> Tareas Pendientes </h2>
            <table border="1">
                <tr>
                        <th>Id</th>
                        <th>Tarea</th>
                        <th>Completado</th>
                        <th></th>
                </tr>
                <%
                    if (almacen != null) {
                            for (Almacen p : almacen ){
                                
                        
                %>
                <tr>
                        <td><%= p.getId() %></td>
                        <td><%= p.getTarea() %></td>
                        <td><input type="checkbox" name="acepto"></td>
                       
                        
                        <td><a href="MainServlet?t=eliminar&id=<%= p.getId() %>">Eliminar</a></td>
                </tr>
                <%
                        }
                    }
                %>
  
            </table>
        
    </body>
</html>

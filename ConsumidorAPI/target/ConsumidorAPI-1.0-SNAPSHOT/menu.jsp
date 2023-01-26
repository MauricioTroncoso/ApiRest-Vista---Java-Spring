<%-- 
    Document   : index
    Created on : 09-07-2022, 13:34:18
    Author     : Pc gamer
--%>
<%@page import="MODEL.usuario"%>
<%@page import="MODEL.categoria" %>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
 
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="/Template/style.jsp"/>
         <jsp:include page="/Template/navbar.jsp"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inicio</title>
    </head>
    <body>
        <%
        String role = session.getAttribute("role").toString();
        if(" ".equals(role)){
            response.sendRedirect("error.jsp");
        }
        usuario user = new usuario();
        
        %>
        
       <div class="container">
            <br>
            <div style="text-align: center;">
                <h1>Bienvenido</h1>
              </div> 
        </div>
        <img src="https://c.tenor.com/wdRu2v7XxwYAAAAC/miku-dancing.gif">
             <form action="ServletLogout">
         <button type="Submit" link="ServletLogout" class="btn btn-danger">Logout</button>   
        </form>
    </body>
</html>

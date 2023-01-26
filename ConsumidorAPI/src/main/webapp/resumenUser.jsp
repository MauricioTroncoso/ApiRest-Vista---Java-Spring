<%-- 
    Document   : resumenUser
    Created on : 13-07-2022, 19:26:10
    Author     : Vermi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="/Template/style.jsp"/>
         <jsp:include page="/Template/navbar.jsp"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pagina para USER</title>
    </head>
    <body>
        <div style="text-align: center;">
                <h1>Resumen de Productos,Categorias y Distribuidores</h1>
            </div>  
            <br>
            <div class="button" role="group" aria-label="Basic example">
        <form action="servletresumenproductos" method="POST">
            <button type="submit" class="linea">Mostrar Productos</button>
        </form>
                ${datosProductos}
            <br>
            <div class="button" role="group" aria-label="Basic example">
        <form action="servletresumencategoria" method="POST">
            <button type="submit" class="linea">Mostrar Categorias</button>
        </form>
             ${datosCategoria}   
            <br>
            <div class="button" role="group" aria-label="Basic example">
        <form action="servletresumendistribuidores" method="POST">
            <button type="submit" class="linea">Mostrar Distribuidores</button>
        </form>
            ${datosDistribuidores}
    </body>
</html>

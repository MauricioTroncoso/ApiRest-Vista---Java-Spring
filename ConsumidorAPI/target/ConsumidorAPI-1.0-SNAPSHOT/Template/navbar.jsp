<%-- 
    Document   : navbar
    Created on : 09-07-2022, 17:46:40
    Author     : Vermi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container-fluid">
        <a class="navbar-brand" href="menu.jsp">Menu</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarText">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
          <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="resumenUser.jsp">Resumen Usuario</a>
        </li>
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="productos.jsp">Productos</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="categoria.jsp">Categorías</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="distribuidores.jsp">Distribuidor</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="UnderConstruction.jsp">Estado</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="UnderConstruction.jsp">Oferta</a>
        </li>
      </ul>
      <span class="navbar-text">
       Consumidor de API
      </span>
    </div>
  </div>
</nav>
    </head>

</html>

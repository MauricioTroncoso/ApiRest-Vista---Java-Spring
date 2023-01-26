<%-- 
    Document   : errorlogin
    Created on : 13-07-2022, 19:16:41
    Author     : Vermi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="/Template/style.jsp"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Espere futuras Actualizaciones</title>
    </head>
    <body>
        <h1>Es una pena, al parecer no tienes cuenta con nosotros <br> 
            Te invitaria a hacerte una pero el diseñador de esta pagina no hizo un REGISTRAR. <br> 
            Porfavor, usa una de nuestras credenciales aceptadas por Miku</h1>
        <img src="https://www.icegif.com/wp-content/uploads/icegif-2607.gif">
        <table class="table table-bordered">
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">Usuario</th>
      <th scope="col">Contraseña</th>
      <th scope="col">Rol</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th scope="row">1</th>
      <td>Miku</td>
      <td>1234</td>
      <td>ADMIN</td>
    </tr>
    <tr>
      <th scope="row">2</th>
      <td>NotMiku</td>
      <td>1234</td>
      <td>USER</td>
    </tr>
  </tbody>
</table>
         <a class="btn btn-primary" href="index.jsp" role="button">Volver a Logear</a>
    </body>
</html>

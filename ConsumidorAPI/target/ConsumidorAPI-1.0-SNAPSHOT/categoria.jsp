<%-- 
    Document   : categoria
    Created on : 09-07-2022, 17:49:37
    Author     : Vermi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
         <jsp:include page="/Template/style.jsp"/>
         <jsp:include page="/Template/navbar.jsp"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pagina de Categorias</title>
    </head>
    <body>
          <%
        String role = session.getAttribute("role").toString();
        if(" ".equals(role)){
            response.sendRedirect("error.jsp");
        }
        if ("USER".endsWith(role)) {
               response.sendRedirect("error.jsp");
            }
        %>

         <div class="container">
            <br>
            <div style="text-align: center;">
                <h1>Categorias</h1>
            </div>  
            <br>
            <div class="btn-group" role="group" aria-label="Basic example">
        <form action="servletcategoria" method="POST">
            <button type="submit" class="linea">Mostrar Datos</button>
        </form>
               <form action="servletcreatecategoria" method="POST">
                   <button type="button" class="linea" data-toggle="modal" data-target="#modalAgregar">Agregar Categoria</button>

                    <div class="modal fade" id="modalAgregar" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                        <div class="modal-dialog modal-dialog-centered">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="exampleModalLabel">Agregando nueva categoria</h5>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                                <div class="modal-body text-left">
                                    <label>Nombre de la Categoria</label>
                                    <input type="text" class="form-control" name="nombre_categoria" required>   
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
                                    <button type="submit" class="btn btn-primary">Agregar</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </form>
                   
                 <form action="servleteditcategoria" method="POST">
                   <button type="button" class="linea" data-toggle="modal" data-target="#modalEditar">Editar Categoria</button>

                    <div class="modal fade" id="modalEditar" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                        <div class="modal-dialog modal-dialog-centered">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="exampleModalLabel">Agregando nueva categoria</h5>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                                <div class="modal-body text-left">
                                    <label>Id de la Categoria a editar</label>
                                    <input type="text" class="form-control" name="id" required>   
                                </div>
                                <div class="modal-body text-left">
                                    <label>Nombre de la Categoria a editar</label>
                                    <input type="text" class="form-control" name="nombre_categoria" required>   
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
                                    <button type="submit" class="btn btn-primary">Agregar</button>
                                </div>
                            </div>
                        </div>
                    </div>
                   <input type="Hidden" name="_METHOD" value="DELETE"/>
                </form>
                               <form action="servletdeletecategoria" method="POST">
                   <button type="button" class="linea" data-toggle="modal" data-target="#modalEliminar">Eliminar Categoria</button>

                    <div class="modal fade" id="modalEliminar" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                        <div class="modal-dialog modal-dialog-centered">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="exampleModalLabel">Eliminando Categorias</h5>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                                <div class="modal-body text-left">
                                    <label>Id de la Categoria a eliminar</label>
                                    <input type="text" class="form-control" name="id" required>   
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
                                    <button type="submit" class="btn btn-primary">Eliminar</button>
                                </div>
                            </div>
                        </div>
                    </div>
                   <input type="Hidden" name="_METHOD" value="PUT"/>
                </form>
           </div>
        </div>
         ${datos}
                
    </body>
</html>
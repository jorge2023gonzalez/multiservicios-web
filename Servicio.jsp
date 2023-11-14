<%-- 
    Document   : servicio
    Created on : 7/11/2023, 10:53:45 a. m.
    Author     : jorge
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <div class="d-flex">
         <div class="card col-sm-6">
            <div class="card-body">
                <form action="controlador?menu=Servicio" method="POST">
                    <div class="form-group">
                        <label>Nombre</label>
                        <input type="text" value="${servicio.getNombre()}" name="txtNombre" class="form-control">
                    </div>
                    <div class="form-group">
                        <label>Precio</label>
                        <input type="text" value="${servicio.getPrecio()}" name="txtPrecio" class="form-control">
                    </div>
                    <div class="form-group">
                        <label>Stock</label>
                        <input type="text" value="${servicio.getStock()}" name="txtStock" class="form-control">
                    </div>
                    <div class="form-group">
                        <label>Estado</label>
                        <input type="text" value="${servicio.getEstado()}" name="txtEstado" class="form-control">
                    </div>
                    <input type="submit" name="accion" value="Agregar" class="btn btn-info">
                    <input type="submit" name="accion" value="Actualizar" class="btn btn-success">
                </form>
                
            </div>
            
        </div>
            <div class="col-sm-10">
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>NOMBRE</th>
                        <th>PRECIO</th>
                        <th>STOCK</th>
                        <th>ESTADO</th>
                        <th>ACCIONES</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="se" items="${servicios}">
                        <tr>
                            <td>${se.getId()}</td>
                            <td>${se.getNombre()}</td>
                            <td>${se.getPrecio()}</td>
                            <td>${se.getStock()}</td>
                            <td>${se.getEstado()}</td>
                            <td>
                                <a class="btn btn-warning" href="controlador?menu=Servicio&accion=Editar&id=${se.getId()}">Editar</a>
                                <a class="btn btn-danger" href="controlador?menu=sercicio&accion=Delete&id=${se.getId()}">Delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                    
                </tbody>
            </table>
        </div>   
        </div>
        
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js" integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+" crossorigin="anonymous"></script>
    </body>
</html>

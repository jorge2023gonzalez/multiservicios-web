<%-- 
    Document   : proveedor
    Created on : 7/11/2023, 10:53:27 a. m.
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
                <form action="controlador?menu=Proveedor" method="POST">
                    <div class="form-group">
                        <label>Dni</label>
                        <input type="text" value="${proveedor.getDni()}" name="txtDni" class="form-control">
                    </div>
                    <div class="form-group">
                        <label>Nombres</label>
                        <input type="text" value="${proveedor.getNombre()}" name="txtNombre" class="form-control">
                    </div>
                    <div class="form-group">
                        <label>Telefono</label>
                        <input type="text" value="${proveedor.getTelefo()}" name="txtTelefono" class="form-control">
                    </div>
                    <div class="form-group">
                        <label>Correo</label>
                        <input type="text" value="${proveedor.getCorreo()}" name="txtCorreo" class="form-control">
                    </div>
                    <div class="form-group">
                        <label>Usuario</label>
                        <input type="text" value="${proveedor.getUser()}" name="txtUsuario" class="form-control">
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
                        <th>DNI</th>
                        <th>NOMBRES</th>
                        <th>TELEFONO</th>
                        <th>CORREO</th>
                        <th>USER</th>
                        <th>ACCIONES</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="pr" items="${proveedores}">
                        <tr>
                            <td>${pr.getId()}</td>
                            <td>${pr.getDni()}</td>
                            <td>${pr.getNombre()}</td>
                            <td>${pr.getTelefono()}</td>
                            <td>${pr.getCorreo()}</td>
                            <td>${pr.getUser()}</td>
                            <td>
                                <a class="btn btn-warning" href="controlador?menu=Proveedor&accion=Editar&id=${pr.getId()}">Editar</a>
                                <a class="btn btn-danger" href="controlador?menu=Proveedor&accion=Delete&id=${pr.getId()}">Delete</a>
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

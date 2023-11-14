<%-- 
    Document   : RegistrarPago
    Created on : 7/11/2023, 10:54:29 a. m.
    Author     : jorge
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"/>
        <title>PAGOS</title>
        <style>
            @media print{
                .parte01, .btn, .accion{
                    display: none;
                }
            }
        </style>
    </head>
    <body>
        <div class="d-flex">
            <div class="col-sm-4 parte01">
                <div class="card">
                    <form action="controlador?menu=NuevoPago" method="POST">
                        <div class="card-body">
                            <!-- DATOS DEL CLIENTE -->
                            <div class="form-group">
                                <label>Datos del Cliente</label>
                            </div>
                            <div class="form-group d-flex">
                                <div class="col-sm-6 d-flex">
                                    <input type="text" name="codigocliente" value="${c.getDni()} "class="form-control col-sm-8" placeholder="codigo">
                                    <input type="submit" name="accion" value="BuscarCliente" class="btn btn-outline-info">
                                </div>
                                <div class="col-sm-6">
                                    <input type="text" name="nombrescliente" value="${c.getNombre()} class="form-control col-sm-8">
                                </div> 
                            </div>
                            <!-- DATOS DEL SERVICIO -->
                            <div class="form-group">
                                <label>Datos Servicio</label>
                            </div>
                            <div class="form-group d-flex">
                                <div class="col-sm-6 d-flex">
                                    <input type="text" name="codigoservicio" value="${servicio.getId()}" class="form-control col-sm-8" placeholder="codigo">
                                    <button type="submit" name="accion" value="BuscarServicio" class="btn btn-outline-info">Buscar Servicio</button>
                                </div>
                                <div class="col-sm-6">
                                    <input type="text" name="nombreservicio" value="${servicio.getNombre()}" placeholder="Datos Servicio" class="form-control col-sm-8">
                                </div> 
                            </div>
                            <div class="form-group d-flex">
                                <div class="col-sm-6">
                                    <input type="text" name="precio" value="${servicio.getPrecio()}" class="form-control col-sm-8" placeholder="$/.0.00">
                                </div>
                                <div class="col-sm-3">
                                    <input type="number" value="1" name="cant" class="form-control col-sm-8">
                                </div>
                                <div class="col-sm-3">
                                    <input type="text" name="stock" value="${servicio.getStock()}" class="form-control col-sm-8">
                                </div>
                            </div>
                            <!-- BOTON AGREGAR SERVICIO -->    
                            <div class="form-group">
                                <button type="submit" name="accion" value="Agregar" class="btn btn-outline-info">Agregar Servicio</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            <div class="col-sm-8">
                <div class="card">
                    <div class="card-body">
                        <div class="d-flex col-sm-6 ml-auto">
                            <label>NroSerie</label>
                            <input type="text" name="NroSerie" value="${nserie()}" class="form-control">
                        </div>
                        <br>
                        <table class="table table-hover">
                            <thead>
                                <tr>
                                    <th>Nro</th>
                                    <th>Codigo</th>
                                    <th>Descripcion</th>
                                    <th>Precio</th>
                                    <th>Cantidad</th>
                                    <th>SubTotal</th>
                                    <th class="accion">Acciones</th>
                                </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="list" items="${lista}">
                                <tr>
                                    <td>${list.getItem()}</td>
                                    <td>${list.getIdservicio()}</td>
                                    <td>${list.getDescripcion()}</td>
                                    <td>${list.getPrecio()}</td>
                                    <td>${list.getCantidad()}</td>
                                    <td>${list.getSubtotal()}</td>
                                    <td class="d-flex">
                                        <a href="$" class="btn btn-warning">Editar</a>
                                        <a href="$" class="btn btn-danger" style="margin-left: 10px">Delete</a>
                                    </td>
                                </tr>
                            </c:forEach>

                            </tbody>
                        </table>
                    </div>
                  <div class="card-footer d-flex" >
                      <div class="col-sm-6">
                          <a href="controlador?menu=NuevoAgenda&accion=GenerarServicio" onclick="print()">Generar Servicio</a>
                          <input type="submit" name="accion" value="Generar Servicio" class="btn btn-success">
                          <input type="submit" name="accion" value="Cancelar" class="btn btn-danger">
                      </div>
                      <div class="col-sm-4 ml-auto">
                          <input type="text" name="txtTotal" value="s/.${totalpagar()}" class="form-control">
                      </div>
                    </div>
                </div>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js" integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+" crossorigin="anonymous"></script>
    </body>
</html>

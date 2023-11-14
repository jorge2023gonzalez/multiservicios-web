/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import config.GenerarSerie;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.proveedor;
import modelo.proveedorDAO;
import java.util.List;
import modelo.agenda;
import modelo.agendaDAO;
import modelo.cliente;
import modelo.clienteDAO;
import modelo.servicio;
import modelo.servicioDAO;

/**
 *
 * @author jorge
 */
public class controlador extends HttpServlet {

    proveedor pr=new proveedor();
    proveedorDAO pdao=new proveedorDAO();
    int idp;
    
    cliente cl=new cliente();
    clienteDAO cdao=new clienteDAO();
    int idc;
    
    servicio se=new servicio();
    servicioDAO sdao=new servicioDAO();
    int ids;
    
    agenda ag=new agenda();
    List<agenda>lista=new ArrayList<>();
    int item;
    int cod;
    String descripcion;
    double precio;
    int cant;
    double subtotal;
    double totalpagar;
    
    String numeroserie;
    agendaDAO adao=new agendaDAO();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");
        if (menu.equals("principal")) {
            request.getRequestDispatcher("principal.jsp").forward(request, response);
        }
        if (menu.equals("Proveedor")) {
            switch (accion) {
                case "Listar":
                    List lista = pdao.listar();
                    request.setAttribute("proveedores", lista);
                    break;
                    case "Agregar":
                        String dni=request.getParameter("txtDni");
                        String nombre=request.getParameter("txtNombres");
                        String telefono=request.getParameter("txtTelefono");
                        String correo=request.getParameter("txtCorreo");
                        String user=request.getParameter("txtUser");
                        pr.setDni(dni);
                        pr.setNombre(nombre);
                        pr.setTelefono(telefono);
                        pr.setCorreo(correo);
                        pr.setUser(user);
                        pdao.agregar(pr);
                        request.getRequestDispatcher("controlador?menu=proveedor&accion=listar").forward(request, response);
                        break;
                    case "Editar":
                        idp=Integer.parseInt(request.getParameter("id"));
                        proveedor p=pdao.listarId(idp);
                        request.setAttribute("proveedor", p);
                        request.getRequestDispatcher("controlador?menu=proveedor&accion=listar").forward(request, response);

                    case "Actualizar":
                        String dni1 = request.getParameter("txtDni");
                        String nombre1 = request.getParameter("txtNombres");
                        String telefono1 = request.getParameter("txtTelefono");
                        String correo1 = request.getParameter("txtCorreo");
                        String user1 = request.getParameter("txtUser");
                        pr.setDni(dni1);
                        pr.setNombre(nombre1);
                        pr.setTelefono(telefono1);
                        pr.setCorreo(correo1);
                        pr.setUser(user1);
                        pr.setId(idp);
                        pdao.actualizar(pr);
                        pdao.actualizar(pr);
                        request.getRequestDispatcher("controlador?menu=proveedor&accion=listar").forward(request, response);
                        break;
                    case "Delete":
                        idp = Integer.parseInt(request.getParameter("id"));
                        pdao.delete(idp);
                        request.getRequestDispatcher("controlador?menu=proveedor&accion=listar").forward(request, response);
                        break;
                    default:
                        throw new AssertionError();
                }
            request.getRequestDispatcher("Proveedor.jsp").forward(request, response);
        }
            if (menu.equals("Cliente")) {
                switch (accion) {
                    case "Listar":
                        List lista = cdao.listar();
                        request.setAttribute("clientes", lista);
                        break;
                    case "Agregar":
                        String dni=request.getParameter("txtDni");
                        String nombre=request.getParameter("txtNombres");
                        String telefono=request.getParameter("txtTelefono");
                        String correo=request.getParameter("txtCorreo");
                        cl.setDni(dni);
                        cl.setNombre(nombre);
                        cl.setTelefono(telefono);
                        cl.setCorreo(correo);
                        cdao.agregar(cl);
                        request.getRequestDispatcher("controlador?menu=cliente&accion=listar").forward(request, response);
                        break;
                    case "Editar":
                        idc=Integer.parseInt(request.getParameter("id"));
                        cliente c=cdao.listarId(idc);
                        request.setAttribute("cliente", c);
                        request.getRequestDispatcher("controlador?menu=cliente&accion=listar").forward(request, response);

                    case "Actualizar":
                        String dni1 = request.getParameter("txtDni");
                        String nombre1 = request.getParameter("txtNombres");
                        String telefono1 = request.getParameter("txtTelefono");
                        String correo1 = request.getParameter("txtCorreo");
                        cl.setDni(dni1);
                        cl.setNombre(nombre1);
                        cl.setTelefono(telefono1);
                        cl.setCorreo(correo1);
                        cl.setId(idc);
                        cdao.actualizar(cl);
                        cdao.actualizar(cl);
                        request.getRequestDispatcher("controlador?menu=cliente&accion=listar").forward(request, response);
                        break;
                    case "Delete":
                        idc = Integer.parseInt(request.getParameter("id"));
                        cdao.delete(idc);
                        request.getRequestDispatcher("controlador?menu=cliente&accion=listar").forward(request, response);
                        break;
                    default:
                        throw new AssertionError();
                }
            request.getRequestDispatcher("clientes.jsp").forward(request, response);
        }
            if (menu.equals("Servicio")) {
                switch (accion) {
                    case "Listar":
                        List lista = sdao.listar();
                        request.setAttribute("servicios", lista);
                        break;
                    case "Agregar":
                        String nombre=request.getParameter("txtNombres");
                        String Precio=request.getParameter("txtPrecio");
                        String stock=request.getParameter("txtStock");
                        String estado=request.getParameter("txtEstado");
                        se.setNombre(nombre);
                        se.setEstado(estado);
                        se.setPrecio(Precio);
                        se.setStock(stock);
                        sdao.agregar(se);
                        request.getRequestDispatcher("controlador?menu=servicio&accion=listar").forward(request, response);
                        break;
                    case "Editar":
                        ids=Integer.parseInt(request.getParameter("id"));
                        servicio s=sdao.listarId(ids);
                        request.setAttribute("servicio", s);
                        request.getRequestDispatcher("controlador?menu=servicio&accion=listar").forward(request, response);

                    case "Actualizar":
                        String nombre1 = request.getParameter("txtNombres");
                        String precio1 = request.getParameter("txtPrecio");
                        String stock1 = request.getParameter("txtStock");
                        String estado1 = request.getParameter("txtEstado");
                        se.setNombre(nombre1);
                        se.setPrecio(precio1);
                        se.setStock(stock1);
                        se.setEstado(estado1);
                        se.setId(ids);
                        sdao.actualizar(se);
                        sdao.actualizar(se);
                        request.getRequestDispatcher("controlador?menu=servicio&accion=listar").forward(request, response);
                        break;
                    case "Delete":
                        ids = Integer.parseInt(request.getParameter("id"));
                        sdao.delete(ids);
                        request.getRequestDispatcher("controlador?menu=servicio&accion=listar").forward(request, response);
                        break;
                    default:
                        throw new AssertionError();
                }
            request.getRequestDispatcher("Servicio.jsp").forward(request, response);
        }
            
            if (menu.equals("NuevoPago")) {
                switch (accion) {
                    case "BuscarCliente":
                        String dni=request.getParameter("codigocliente");
                        cl.setDni(dni);
                        cl=cdao.buscar(dni);
                        request.setAttribute("cliente",cl);
                        break;
                    case "Buscar servicio":
                        int id = Integer.parseInt(request.getParameter("codigoservicio"));
                        se = sdao.listarId(id);
                        request.setAttribute("cliente", cl);
                        request.setAttribute("servicio", se);
                        request.setAttribute("lista", lista);
                        request.setAttribute("totalpagar", totalpagar);
                        break;
                    case "Agregar":
                        request.setAttribute("cliente", cl);
                        totalpagar =0.0;
                        item=item+1;
                        cod=se.getId();
                        descripcion=request.getParameter("nombreservicio");
                        precio=Double.parseDouble(request.getParameter("precio"));
                        cant=Integer.parseInt(request.getParameter("cant"));
                        subtotal=precio*cant;
                        ag=new agenda();
                        ag.setItem(item);
                        ag.setIdservicio(cod);
                        ag.setDecripcionS(descripcion);
                        ag.setPrecio(precio);
                        ag.setCantidad(cant);
                        ag.setSubtotal(subtotal);
                        lista.add(ag);
                        for (int i = 0; i < lista.size(); i++) {
                            totalpagar=totalpagar +lista.get(i).getSubtotal();
                        }
                        request.setAttribute("totalpagar", totalpagar);
                        request.setAttribute("lista", lista);
                        break;
                    case "GenerarAgenda":
                        //guardar agenda
                        ag.setIdcliente(cl.getId());
                        ag.setIdproveedor(1);
                        ag.setNumeroserie(numeroserie);
                        ag.setFecha("2023-11-09");
                        ag.setMonto(totalpagar);
                        ag.setEstado("1");
                        adao.GuardarAgenda(ag);
                        //guardar detalle pago
                        int idpa=Integer.parseInt(adao.IdAgenda());
                        for (int i = 0; i <lista.size(); i++) {
                            ag=new agenda();
                            ag.setId(idpa);
                            ag.setIdservicio(lista.get(i).getIdservicio());
                            ag.setCantidad(lista.get(i).getCantidad());
                            ag.setPrecio(lista.get(i).getPrecio());
                            adao.guardarDetallepagos(ag);
                            
                        }
                        break;
                    default:
                        ag=new agenda();
                        lista=new ArrayList<>();
                        item=0;
                        totalpagar=0.0;
                        
                        numeroserie=adao.GenerarSerie();
                        if (numeroserie==null) {
                            numeroserie="00000001";
                            request.setAttribute("nserie", numeroserie);
                        }
                        else{
                            int incrementar=Integer.parseInt(numeroserie);
                            GenerarSerie gs=new GenerarSerie();
                            numeroserie=gs.NumeroSerie(incrementar);
                            request.setAttribute("nserie", numeroserie);
                        }
                        throw new AssertionError();
                }
            request.getRequestDispatcher("RegitrarPago.jsp").forward(request, response);
        }

        }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    }

    

    
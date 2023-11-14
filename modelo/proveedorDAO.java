/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import config.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jorge
 */
public class proveedorDAO {
    conexion cn=new conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    public proveedor validar(String User, String Dni){
        proveedor pr=new proveedor();
        String sql="select * from proveedor where User=? and Dni=?";
        try {
            con=cn.conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1, User);
            ps.setString(2, Dni);
            rs=ps.executeQuery();
            while (rs.next()) { 
                pr.setId(rs.getInt("IdProveedor"));
                pr.setUser(rs.getString("User"));
                pr.setDni(rs.getString("Dni"));
                pr.setNombre(rs.getString("Nombres"));
                pr.setTelefono(rs.getString("Telefono"));
                pr.setCorreo(rs.getString("Correo"));
            }
        } catch (Exception e) {
        }
        return pr;
    }
    
    //operaciones CRUD
    
    public List listar(){
        String sql="select * from proveedor";
        List<proveedor>lista=new ArrayList<>();
        try {
            con=cn.conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {
                proveedor pr= new proveedor();
                pr.setId(rs.getInt(1));
                pr.setDni(rs.getString(2));
                pr.setNombre(rs.getString(3));
                pr.setTelefono(rs.getString(4));
                pr.setCorreo(rs.getString(5));
                pr.setUser(rs.getString(6));
                lista.add(pr);
            }
        } catch (Exception e) {
        }
        return lista;
    }
    public int agregar(proveedor p){
        String sql="insert into proveedor(Dni, Nombre, Telefono, Correo, User)values(?,?,?,?,?)";
        try {
            con=cn.conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1, p.getDni());
            ps.setString(2, p.getNombre());
            ps.setString(3, p.getTelefono());
            ps.setString(4, p.getCorreo());
            ps.setString(5, p.getUser());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
        
    }
    public proveedor listarId(int id){
        proveedor pro=new proveedor();
        String sql="select * from proveedor where IdProveedor="+id;
        try {
            con=cn.conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {                
                pro.setDni(rs.getString(2));
                pro.setNombre(rs.getString(3));
                pro.setTelefono(rs.getString(4));
                pro.setCorreo(rs.getString(5));
                pro.setUser(rs.getString(6));
                        
            }
        } catch (Exception e) {
        }
        return null;
    }
    public int actualizar(proveedor p){
        String sql="update proveedor set Dni=?, Nombre=?, Telefono=?, Correo=?, User=? where IdProveedor=?";
        try {
            con=cn.conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1, p.getDni());
            ps.setString(2, p.getNombre());
            ps.setString(3, p.getTelefono());
            ps.setString(4, p.getCorreo());
            ps.setString(5, p.getUser());
            ps.setInt(6, p.getId());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    
    }
    public void delete(int id){
        String sql="delete from proveedor where IdProveedor="+id;
        try {
            con=cn.conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
        } catch (Exception e) {
        }
    
    }
            
}

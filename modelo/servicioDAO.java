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
public class servicioDAO {
    conexion cn=new conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    public servicio validar(String Nombres, String Estado){
        servicio se=new servicio();
        String sql="select * from Servicio where Nombres=? and Estado=?";
        try {
            con=cn.conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1, Nombres);
            ps.setString(2, Estado);
            rs=ps.executeQuery();
            while (rs.next()) { 
                se.setId(rs.getInt("IdServicio"));
                se.setEstado(rs.getString("Estado"));
                se.setNombre(rs.getString("Nombres"));
                se.setPrecio(rs.getString("Precio"));
                se.setStock(rs.getString("Stock"));
            }
        } catch (Exception e) {
        }
        return se;
    }
    
    //Operaciones CRUD//
    
    public List listar(){
        String sql="select * from servicio";
        List<servicio>lista=new ArrayList<>();
        try {
            con=cn.conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {
                servicio se= new servicio();
                se.setId(rs.getInt(1));
                se.setPrecio(rs.getString(2));
                se.setNombre(rs.getString(3));
                se.setStock(rs.getString(4));
                se.setEstado(rs.getString(5));
                lista.add(se);
            }
        } catch (Exception e) {
        }
        return lista;
    }
    public int agregar(servicio se){
        String sql="insert into servicio(Nombre, Precio, Stock, Estado)values(?,?,?,?)";
        try {
            con=cn.conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1, se.getNombre());
            ps.setString(2, se.getPrecio());
            ps.setString(3, se.getStock());
            ps.setString(4, se.getEstado());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
        
    }
    public servicio listarId(int id){
        servicio se=new servicio();
        String sql="select * from servicio where IdServicio="+id;
        try {
            con=cn.conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {                
                se.setNombre(rs.getString(2));
                se.setPrecio(rs.getString(3));
                se.setStock(rs.getString(4));
                se.setEstado(rs.getString(5));
                        
            }
        } catch (Exception e) {
        }
        return null;
    }
    public int actualizar(servicio se){
        String sql="update servicio set Nombre=?, Precio=?, Stock=?, Estado=? where IdServicio=?";
        try {
            con=cn.conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1, se.getNombre());
            ps.setString(2, se.getPrecio());
            ps.setString(3, se.getStock());
            ps.setString(4, se.getEstado());
            ps.setInt(6, se.getId());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    
    }
    public void delete(int id){
        String sql="delete from servicio where IdServicio="+id;
        try {
            con=cn.conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
        } catch (Exception e) {
        }
    
    }
    
}

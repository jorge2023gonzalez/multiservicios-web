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
public class clienteDAO {
    conexion cn=new conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    public cliente buscar(String dni){
        cliente cl=new cliente();
        String sql="select * from cliente where Dni="+dni;
        try {
            con=cn.conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) { 
                cl.setId(rs.getInt(1));
                cl.setDni(rs.getString(2));
                cl.setNombre(rs.getString(3));
                cl.setTelefono(rs.getString(3));
                cl.setCorreo(rs.getString(5));
            }
        } catch (Exception e) {
        }
    return cl;
    }
    

    
    //operaciones CRUD
    
    public List listar(){
        String sql="select * from cliente";
        List<cliente>lista=new ArrayList<>();
        try {
            con=cn.conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {
                cliente cl= new cliente();
                cl.setId(rs.getInt(1));
                cl.setDni(rs.getString(2));
                cl.setNombre(rs.getString(3));
                cl.setTelefono(rs.getString(4));
                cl.setCorreo(rs.getString(5));
                lista.add(cl);
            }
        } catch (Exception e) {
        }
        return lista;
    }
    public int agregar(cliente cl){
        String sql="insert into cliente(Dni, Nombre, Telefono, Correo,)values(?,?,?,?)";
        try {
            con=cn.conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1, cl.getDni());
            ps.setString(2, cl.getNombre());
            ps.setString(3, cl.getTelefono());
            ps.setString(4, cl.getCorreo());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
        
    }
    public cliente listarId(int id){
        cliente cl=new cliente();
        String sql="select * from cliente where IdCliente="+id;
        try {
            con=cn.conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {                
                cl.setDni(rs.getString(2));
                cl.setNombre(rs.getString(3));
                cl.setTelefono(rs.getString(4));
                cl.setCorreo(rs.getString(5));
                        
            }
        } catch (Exception e) {
        }
        return null;
    }
    public int actualizar(cliente cl){
        String sql="update cliente set Dni=?, Nombre=?, Telefono=?, Correo=? where IdCliente=?";
        try {
            con=cn.conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1, cl.getDni());
            ps.setString(2, cl.getNombre());
            ps.setString(3, cl.getTelefono());
            ps.setString(4, cl.getCorreo());
            ps.setInt(6, cl.getId());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    
    }
    public void delete(int id){
        String sql="delete from cliente where IdCliente="+id;
        try {
            con=cn.conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
        } catch (Exception e) {
        }
    
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import config.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author jorge
 */
public class agendaDAO {
    Connection con;
    conexion cn=new conexion();
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    public String GenerarSerie(){
        String numeroserie="";
        String sql="select max(NumeroSerie) * from agenda";
        try {
            con=cn.conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {                
                numeroserie=rs.getString(1);
            }
        } catch (Exception e) {
        }
        return numeroserie;
    }
    
    public String IdAgenda(){
        String idagenda="";
        String sql="select * from agenda";
        try{
        con=cn.conexion();
        ps=con.prepareStatement(sql);
        rs=ps.executeQuery();
        while (rs.next()) {                
                idagenda=rs.getString(1);
            }
        } catch (Exception e) {
        }
        return idagenda;
    }
    public int GuardarAgenda(agenda ag){
    String sql="insert into agenda(IdCliente,IdProveedor,NumeroSerie,Fecha,Valor,Estado)value(?,?,?,?,?,?)";
        try {
            con=cn.conexion();
            ps=con.prepareStatement(sql);
            ps.setInt(1, ag.getIdcliente());
            ps.setInt(2, ag.getIdproveedor());
            ps.setString(3, ag.getNumeroserie());
            ps.setString(4, ag.getFecha());
            ps.setDouble(5, ag.getPrecio());
            ps.setString(6, ag.getEstado());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }
    public int guardarDetallepagos(agenda agenda){
        String sql="insert into detalle_pagos(IdAgenda, IdProveedor, PrecioVenta)values(?,?,?) ";
        try {
            con=cn.conexion();
            ps=con.prepareStatement(sql);
            ps.setInt(1, agenda.getId());
            ps.setInt(2, agenda.getIdproveedor());
            ps.setInt(3, agenda.getCantidad());
            ps.setDouble(4, agenda.getPrecio());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }
}

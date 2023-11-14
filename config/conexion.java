/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package config;
import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author jorge
 */
public class conexion {
    
   Connection con;
   String url="jdbc:mysql://localhost:3306/multiservicios4";
   String user="root";
   String pass="Jg12345";
   public Connection conexion(){
       try {
           Class.forName("com.mysql.cj.jdbc.Driver");
           con=DriverManager.getConnection(url,user,pass);
       } catch (Exception e) {
       }
       return con;
   }
    
}

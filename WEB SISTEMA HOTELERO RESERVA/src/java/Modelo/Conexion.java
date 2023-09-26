/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.*;

/**
 *
 * @author USUARIO
 */
public class Conexion {
    Connection con;
    public Connection getConnection(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dbhotel","root","");
        }catch(ClassNotFoundException | SQLException e){
                System.out.println("error conexion"+e.getMessage());
            }
    return con;
   } 
}

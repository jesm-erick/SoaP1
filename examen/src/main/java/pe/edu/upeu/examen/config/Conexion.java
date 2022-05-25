/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.upeu.examen.config;

/**
 *
 * @author jhone
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author jhone
 */
public class Conexion {
    private static final String URL ="jdbc:postgresql://ec2-3-231-82-226.compute-1.amazonaws.com:5432/d9dp66jckbuf4h";
    private static final String  DRIVER ="org.postgresql.Driver";
    private static final String PASS="f92cde866a30ca86b339b9152ae40b8d657105b091be40388c7c501d0de1b914";
    private static final String USER="dewtywaqoroimx";
    private static Connection cx = null;

    public static Connection getConex(){
        try {
            Class.forName(DRIVER);
            if(cx==null){
                cx = DriverManager.getConnection(URL, USER, PASS);
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error:"+e);
        }
        return cx;
    }
}

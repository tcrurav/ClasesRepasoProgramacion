package venezela;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Profesor
 */
public class AccesoBD {
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://localhost/libros";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "";
    
    Connection conn = null;
    Statement stmt = null;
    
    public AccesoBD(){
        try {
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            
            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            
            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM libros where codigo=0";  
            ResultSet rs = stmt.executeQuery(sql);
            
            String titulo;
            String autor;
            int codigo;
            
            //STEP 5: Extract data from result set
            while(rs.next()){
               //Retrieve by column name
               codigo  = rs.getInt("codigo");
               titulo = rs.getString("Titulo");

               //Display values
               System.out.print("codigo: " + codigo);
               System.out.print(", Titulo: " + titulo);
            }
            
            titulo = "Los Ricos también lloran";
            autor = "Efrén Becquer";
            sql = "UPDATE libros SET Titulo = '" + titulo + "', " +
                             "Autor = '" + autor + "' WHERE codigo=0"; 
            stmt.executeUpdate(sql);
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AccesoBD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AccesoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}

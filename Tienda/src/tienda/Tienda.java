/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tiburcio
 */
public class Tienda {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        readFromDatabase();
    }

    private static void readFromDatabase() {
        Connection connect = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            connect = DriverManager
                    .getConnection("jdbc:mysql://localhost/tienda?"
                            + "user=root&password=");
            // Statements allow to issue SQL queries to the database
            statement = connect.createStatement();
            // Result set get the result of the SQL query
            resultSet = statement
                    .executeQuery("select nombre, apellidos from clientes c, compras o where c.id_cliente = o.id_cliente");
            
            while(resultSet.next()){
//                System.out.println("id_cliente: " + resultSet.getInt("id_cliente"));
                System.out.println("nombre: " + resultSet.getString("nombre"));
                System.out.println("apellidos: " + resultSet.getString("apellidos"));
            }
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Tienda.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Tienda.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            try {
                statement.close();
                resultSet.close();
                connect.close();
            } catch (SQLException ex) {
                Logger.getLogger(Tienda.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
}

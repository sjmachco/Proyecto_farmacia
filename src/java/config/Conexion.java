
package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author TIVE
 */
public class Conexion {   

    public Connection getConexion(){    
        //Connection cn = null;
        try {
            Connection conexion;
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/farmacia", "root", "admin");
            System.out.println("Conexion exitosa");
            return conexion;
        } catch (SQLException e) {
            System.out.println(e.toString());
            //System.out.println("No conecto!");
            return null;
        }catch(ClassNotFoundException ex){
            //System.out.println("No se conecto!");
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }    
}



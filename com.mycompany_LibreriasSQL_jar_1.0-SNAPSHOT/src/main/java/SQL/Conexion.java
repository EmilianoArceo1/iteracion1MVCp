
package SQL;


import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;


public class Conexion {
    public static Connection con = null;
    public static Connection getConexion(){
        String conexionURL = "jdbc:sqlserver://localhost:1433;"
                + "database=Libreria;"
                + "user=sa;"
                + "password=12345678;"
                + "loginTimeout=30;"
                + "integratedSecurity=false;"
                + "encrypt=false;trustServerCertificate=true";
        try{
          con = DriverManager.getConnection(conexionURL);
        } catch(Exception e){   
            JOptionPane .showMessageDialog(null,"Error al conectar la base de datos:" + e.toString());
        }
        return con;
    }
}
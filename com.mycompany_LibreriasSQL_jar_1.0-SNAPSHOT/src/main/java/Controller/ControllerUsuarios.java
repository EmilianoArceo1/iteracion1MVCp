package Controller;

import Model.modelLibrerias;
import SQL.CrudSQL;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Controlador para la gestión de usuarios.
 * 
 * @author emili
 */
public class ControllerUsuarios {
    public static int idUsuario;
    public static String isbn;
    public static String publicacion;
    public static String editorial;

    // Constructor y otros métodos de la clase...

    public static ResultSet cargarUsuarios() {
        return CrudSQL.cargarRegistros();
    }

    public static boolean registrarUsuario(String nuevoIsbn, String nuevaPublicacion, String nuevaEditorial) {
        return CrudSQL.registrarUsuario(nuevoIsbn, nuevaPublicacion, nuevaEditorial);
    }

    public static boolean actualizarUsuario(int id, String nuevoIsbn, String nuevaPublicacion, String nuevaEditorial) {
        return CrudSQL.actualizarUsuario(id, nuevoIsbn, nuevaPublicacion, nuevaEditorial);
    }

    public static boolean eliminarUsuario(int id) {
        return CrudSQL.eliminarUsuario(id);
    }
    
    // Otros métodos si es necesario...
}


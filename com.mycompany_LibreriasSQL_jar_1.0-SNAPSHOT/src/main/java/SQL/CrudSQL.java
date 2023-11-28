package SQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class CrudSQL {
    // Otro código de la clase...

    public static ResultSet cargarRegistros() {
        try {
            Connection conn = Conexion.getConexion();
            String sql = "SELECT * FROM tabla";
            PreparedStatement stmt = conn.prepareStatement(sql);

            return stmt.executeQuery();
        } catch (SQLException e) {
            // Manejar la excepción según tus necesidades
            e.printStackTrace();
            return null;
        }
    }

    public static boolean registrarUsuario(String nuevoIsbn, String nuevaPublicacion, String nuevaEditorial) {
        try {
            Connection conn = Conexion.getConexion();
            String sql = "INSERT INTO tabla (isbn, publicacion, Editorial) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nuevoIsbn);
            stmt.setString(2, nuevaPublicacion);
            stmt.setString(3, nuevaEditorial);

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            // Manejar la excepción según tus necesidades
            e.printStackTrace();
            return false;
        }
    }

    public static boolean actualizarUsuario(int id, String nuevoIsbn, String nuevaPublicacion, String nuevaEditorial) {
        try {
            Connection conn = Conexion.getConexion();
            String sql = "UPDATE tabla SET isbn=?, publicacion=?, Editorial=? WHERE id=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nuevoIsbn);
            stmt.setString(2, nuevaPublicacion);
            stmt.setString(3, nuevaEditorial);
            stmt.setInt(4, id);

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            // Manejar la excepción según tus necesidades
            e.printStackTrace();
            return false;
        }
    }

    public static boolean eliminarUsuario(int id) {
        try {
            Connection conn = Conexion.getConexion();
            String sql = "DELETE FROM tabla WHERE id=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            // Manejar la excepción según tus necesidades
            e.printStackTrace();
            return false;
        }
    }
}


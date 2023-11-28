package Prueba;



import SQL.CrudSQL;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PruebaCrudSQL {

    public static void main(String[] args) {
        // Insertar datos de ejemplo
        System.out.println("Insertando datos de ejemplo...");
        boolean insercionExitosa = CrudSQL.registrarUsuario("1234567890", "Libro de Prueba", "Editorial de Prueba");
        if (insercionExitosa) {
            System.out.println("Inserción exitosa.\n");
        } else {
            System.out.println("Error en la inserción.\n");
        }

        // Cargar y mostrar registros
        System.out.println("Cargando registros...");
        ResultSet resultSet = CrudSQL.cargarRegistros();
        if (resultSet != null) {
            try {
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String isbn = resultSet.getString("isbn");
                    String publicacion = resultSet.getString("publicacion");
                    String editorial = resultSet.getString("Editorial");

                    System.out.println("ID: " + id + ", ISBN: " + isbn + ", Publicación: " + publicacion + ", Editorial: " + editorial);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } else {
            System.out.println("Error al cargar registros.");
        }
    }
}

package antiplagium.DAO;

import antiplagium.DAL.ConexionJDBC;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author USER
 */
public class RolDAO {

    private static String SQL_GETROLES = "SELECT \"idRol\", \"nombre\", \"descripcion\" FROM \"Rol\"";

    public Vector getRoles() throws SQLException
    {
        Vector tablaResultados = null;
        tablaResultados = ConexionJDBC.ejecutarQuery(SQL_GETROLES);
        return tablaResultados;
    }
}

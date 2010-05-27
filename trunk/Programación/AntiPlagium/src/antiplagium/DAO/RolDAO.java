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
        
    public ResultSet getRolesList() throws SQLException
    {
        ResultSet tablaResultados = null;       
        tablaResultados = ConexionJDBC.ejecutarQueryString(SQL_GETROLES);                
        return tablaResultados;
    }
    
}

package antiplagium.DAO;

import antiplagium.DAL.ConexionJDBC;
import java.sql.*;

public class PrivilegioDAO {

    private static String SQL_GETPRIVILEGIOS = "SELECT RXP.\"idRol\", P.\"idPrivilegio\", \"nombre\", \"descripcion\" " +
                                               "FROM \"Privilegio\" P " +
                                               "LEFT OUTER JOIN \"RolXPrivilegio\" RXP  ON P.\"idPrivilegio\" = RXP.\"idPrivilegio\" " +
                                               "WHERE \"idRol\" = ";

    public ResultSet getPrivilegiosPorRol(Integer idRol) throws SQLException
    {
        ResultSet tablaResultados = null;

        SQL_GETPRIVILEGIOS = SQL_GETPRIVILEGIOS + idRol.toString(); 
        tablaResultados = ConexionJDBC.ejecutarQueryString(SQL_GETPRIVILEGIOS);
        return tablaResultados;
    }

}

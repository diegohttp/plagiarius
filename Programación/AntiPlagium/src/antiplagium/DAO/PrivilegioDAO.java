package antiplagium.DAO;

import antiplagium.DAL.ConexionJDBC;
import java.sql.*;

public class PrivilegioDAO {

    private static String SQL_GETPRIVILEGIOS = "SELECT RXP.\"idRol\", P.\"idPrivilegio\", P.\"nombre\", P.\"descripcion\" " +
                                               "FROM \"Privilegio\" P " +
                                               "LEFT OUTER JOIN \"RolXPrivilegio\" RXP  ON P.\"idPrivilegio\" = RXP.\"idPrivilegio\" " +
                                               "INNER JOIN \"Rol\" R ON RXP.\"idRol\" = R.\"idRol\" " +
                                               "WHERE R.\"nombre\" = " ;

    private static String SQL_PRIVILEGIOS = "SELECT \"idPrivilegio\", \"nombre\", \"descripcion\" " +
                                            "FROM \"Privilegio\" ";

    public ResultSet getPrivilegiosPorRol(String nombreRol) throws SQLException
    {
        ResultSet tablaResultados = null;

        SQL_GETPRIVILEGIOS = SQL_GETPRIVILEGIOS + nombreRol; 
        tablaResultados = ConexionJDBC.ejecutarQueryString(SQL_GETPRIVILEGIOS);
        return tablaResultados;
    }

    public ResultSet getListPrivilegios() throws SQLException
    {
        ResultSet tablaResultados = null;
        tablaResultados = ConexionJDBC.ejecutarQueryString(SQL_PRIVILEGIOS);
        return tablaResultados;
    }

    
}

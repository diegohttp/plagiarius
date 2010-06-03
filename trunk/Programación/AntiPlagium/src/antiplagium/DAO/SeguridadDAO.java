
package antiplagium.DAO;

import antiplagium.DAL.ConexionJDBC;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SeguridadDAO {

    private static String SQL_SEGURIDAD = "SELECT CXP.\"idPrivilegio\", CXP.\"idVentana\", CXP.\"idControl\", C.\"nombre\" " +
                                          "FROM \"ControlXPrivilegio\" CXP " +
                                          "INNER JOIN \"Control\" C on CXP.\"idVentana\" = C.\"idVentana\" and CXP.\"idControl\" = C.\"idControl\" " +
                                          "INNER JOIN \"Ventana\" V on C.\"idVentana\" = V.\"idVentana\" " +
                                          "INNER JOIN \"Privilegio\" P on CXP.\"idPrivilegio\" = P.\"idPrivilegio\" " +
                                          "INNER JOIN \"RolXPrivilegio\" RXP on P.\"idPrivilegio\" = RXP.\"idPrivilegio\" " +
                                          "INNER JOIN \"Rol\" R on RXP.\"idRol\" = R.\"idRol\" " +
                                          "WHERE V.\"nombreVentana\" = '" ;

    public ResultSet getComponentesDeshabilitadosPorRol(String nombreVentana, String nombreRol) throws SQLException
    {
        ResultSet tablaResultados = null;
        String SQL_SELECT = SQL_SEGURIDAD + nombreVentana + "' and R.\"nombre\" = '"+ nombreRol + "'";
        tablaResultados = ConexionJDBC.ejecutarQueryString(SQL_SELECT);
        return tablaResultados;
    }    
}

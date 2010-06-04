package antiplagium.DAO;

import antiplagium.DAL.ConexionJDBC;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class RolDAO {

    private static String SQL_GETROLES = "SELECT \"idRol\", \"nombre\", \"descripcion\" FROM \"Rol\" ";
    private static String SQL_INSERT_ROL = "INSERT INTO \"Rol\"(\"idRol\", \"nombre\", \"descripcion\") " +
                                           "VALUES(" ;

    private static String SQL_GETLAST_ID = "SELECT MAX(\"idRol\") AS idRol FROM   \"Rol\" ";

    private static String SQL_INSERT_PRIVILEGIOXROL = "INSERT INTO \"RolXPrivilegio\"(\"idPrivilegio\", \"idRol\") " +
                                                      "VALUES( " ;

    private static String SQL_SELECT_PRIVILEGIOS_X_ROL = "SELECT \"idPrivilegio\", RXP.\"idRol\" " +
                                                         "FROM \"RolXPrivilegio\" RXP " +
                                                         "INNER JOIN \"Rol\" R on  R.\"idRol\" = RXP.\"idRol\" " +
                                                         "WHERE R.\"nombre\" = '" ;
        
    public ResultSet getRolesList() throws SQLException
    {
        ResultSet tablaResultados = null;       
        tablaResultados = ConexionJDBC.ejecutarQueryString(SQL_GETROLES);                
        return tablaResultados;
    }

    public ResultSet getPrivilegiosPorRol(String nombreROl) throws SQLException
    {
        ResultSet tablaResultados = null;
        String SQL_SELECT = SQL_SELECT_PRIVILEGIOS_X_ROL + nombreROl + "' " ;
        tablaResultados = ConexionJDBC.ejecutarQueryString(SQL_SELECT);
        return tablaResultados;
    }

    public Vector getPrivilegiosPorRol2(String nombreROl) throws SQLException
    {
        Vector vector = new Vector();
        String SQL_SELECT = SQL_SELECT_PRIVILEGIOS_X_ROL + nombreROl + "' " ;
        vector = ConexionJDBC.ejecutarQuery(SQL_SELECT);
        return vector;
    }

    public ResultSet getLastID() throws SQLException
    {
        ResultSet tablaResultados = null;
        tablaResultados = ConexionJDBC.ejecutarQueryString(SQL_GETLAST_ID);        
        return tablaResultados;
    }

    public void  insertRol(Integer idRol, String nombreRol, String descripcion) throws SQLException
    {
        boolean _successful = false;
        String SQL_Insert = null;

        SQL_Insert = SQL_INSERT_ROL + idRol.toString() + ", \'" + nombreRol + "\', \'" + descripcion + "\')" ;
        ConexionJDBC.ejecutarUpdateString(SQL_Insert);
    }

    public void insertDetallePrivilegio(Integer idRol, Integer idPrivilegio) throws SQLException
    {
        String SQL_Insert = null;
        SQL_Insert = SQL_INSERT_PRIVILEGIOXROL + idPrivilegio.toString() + ", " + idRol.toString() + ")" ;
        ConexionJDBC.ejecutarUpdateString(SQL_Insert);
    }    
}

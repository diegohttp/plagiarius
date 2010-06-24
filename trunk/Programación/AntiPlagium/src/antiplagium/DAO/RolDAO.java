package antiplagium.DAO;

import antiplagium.DAL.ConexionJDBC;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class RolDAO {

    private static String SQL_GETROLES = "SELECT \"idRol\", \"nombre\", \"estado\" FROM \"Rol\" WHERE estado = \'ACT\' ";

    private static String SQL_GET_TODOS_ROLES = "SELECT \"idRol\", \"nombre\", \"estado\" FROM \"Rol\" ";

    private static String SQL_INSERT_ROL = "INSERT INTO \"Rol\"(\"idRol\", \"nombre\", \"estado\") " +
                                           "VALUES(" ;

    private static String SQL_GETLAST_ID = "SELECT MAX(\"idRol\") AS idRol FROM   \"Rol\" ";

    private static String SQL_INSERT_PRIVILEGIOXROL = "INSERT INTO \"RolXPrivilegio\"(\"idPrivilegio\", \"idRol\") " +
                                                      "VALUES( " ;

    private static String SQL_UPDATE_ROL = "UPDATE \"Rol\" SET \"idRol\"= " ;

    private static String SQL_SELECT_PRIVILEGIOS_X_ROL = "SELECT \"idPrivilegio\", RXP.\"idRol\" " +
                                                         "FROM \"RolXPrivilegio\" RXP " +
                                                         "INNER JOIN \"Rol\" R on  R.\"idRol\" = RXP.\"idRol\" " +
                                                         "WHERE R.\"nombre\" = '" ;

    //DELETE ROL Y DETALLE
    private static String SQL_DELE_ROL = "UPDATE \"Rol\" SET \"estado\"= \'INA\' WHERE \"idRol\" = ";

    private static String SQL_DELETE_PRIVILEGIO_X_ROL = "DELETE FROM \"RolXPrivilegio\" " +
                                                        "WHERE \"idRol\" = ";
        
    public ResultSet getRolesList() throws SQLException
    {
        ResultSet tablaResultados = null;       
        tablaResultados = ConexionJDBC.ejecutarQueryString(SQL_GETROLES);                
        return tablaResultados;
    }
    
    public ResultSet getAllRolesList() throws SQLException
    {
        ResultSet tablaResultados = null;       
        tablaResultados = ConexionJDBC.ejecutarQueryString(SQL_GET_TODOS_ROLES);                
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

    public void  insertRol(Integer idRol, String nombreRol) throws SQLException
    {        
        String SQL_Insert = null;

        SQL_Insert = SQL_INSERT_ROL + idRol.toString() + ", \'" + nombreRol + "\', \'" + "ACT" + "\')" ;
        ConexionJDBC.ejecutarUpdateString(SQL_Insert);
    }

    public void updateRol(Integer idRol, String nombreRol, String estado) throws SQLException
    {
        boolean _successful = false;
        String SQL_UPDATE = null;
          
        SQL_UPDATE = SQL_UPDATE_ROL + idRol.toString() + ", \"nombre\"= \'" + nombreRol + "', \"estado\"= \'" + estado + "\' WHERE \"idRol\" = " + idRol.toString();
        ConexionJDBC.ejecutarUpdateString(SQL_UPDATE);
    }

    public void insertDetallePrivilegio(Integer idRol, Integer idPrivilegio) throws SQLException
    {
        String SQL_Insert = null;
        SQL_Insert = SQL_INSERT_PRIVILEGIOXROL + idPrivilegio.toString() + ", " + idRol.toString() + ")" ;
        ConexionJDBC.ejecutarUpdateString(SQL_Insert);
    }

    public void deleteRol(Integer idRol) throws SQLException
    {
        String SQL_DELETE;
        SQL_DELETE = SQL_DELE_ROL + idRol.toString();
        ConexionJDBC.ejecutarUpdateString(SQL_DELETE);
    }

    public void deletePrivilegios_ROL(Integer idRol) throws SQLException
    {
        boolean _successful = false;
        String SQL_UPDATE = null;

        SQL_UPDATE = SQL_UPDATE_ROL + idRol.toString();
        ConexionJDBC.ejecutarUpdateString(SQL_UPDATE);
    }
    
    public void deleteDetallePrivilegio(Integer idRol, Integer idPrivilegio) throws SQLException
    {
        String SQL_DELETE = null;
        SQL_DELETE = SQL_DELETE_PRIVILEGIO_X_ROL + idRol.toString() + " and \"idPrivilegio\" = " + idPrivilegio.toString();
        ConexionJDBC.ejecutarUpdateString(SQL_DELETE);
    }
}

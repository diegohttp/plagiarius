package antiplagium.DAO;

import antiplagium.DAL.ConexionJDBC;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RolDAO {

    private static String SQL_GETROLES = "SELECT \"idRol\", \"nombre\", \"descripcion\" FROM \"Rol\" ";
    private static String SQL_INSERT_ROL = "INSERT INTO \"Rol\"(\"idRol\", \"nombre\", \"descripcion\") " +
                                           "VALUES(" ;

    private static String SQL_GETLAST_ID = "SELECT MAX(\"idRol\") AS idRol FROM   \"Rol\" ";
        
    public ResultSet getRolesList() throws SQLException
    {
        ResultSet tablaResultados = null;       
        tablaResultados = ConexionJDBC.ejecutarQueryString(SQL_GETROLES);                
        return tablaResultados;
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

        SQL_INSERT_ROL += idRol.toString() + ", \'" + nombreRol + "\', \'" + descripcion + "\')" ;
        ConexionJDBC.ejecutarQueryString(SQL_INSERT_ROL);
    }



    
}

package antiplagium.BL;

import antiplagium.DAL.ConexionJDBC;
import antiplagium.DAO.SeguridadDAO;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SeguridadBL {

    public void AbrirConexion() throws SQLException, ClassNotFoundException
    {
        ConexionJDBC.abrirConexion();
    }

    public void CerrarConexion() throws SQLException
    {
        ConexionJDBC.cerrarConexion();
    }

    public ResultSet getListControlesDeshabilitadosPorRol(String nombreVentana, Integer idRol) throws SQLException
    {
        ResultSet tablaRoles = null;
        SeguridadDAO rolDao = new SeguridadDAO();
        tablaRoles = rolDao.getComponentesDeshabilitadosPorRol(nombreVentana, idRol);
        return tablaRoles;
    }
}

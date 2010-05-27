package antiplagium.BL;

import antiplagium.DAL.ConexionJDBC;
import antiplagium.DAO.RolDAO;
import java.sql.ResultSet;
import java.sql.SQLException;


public class RolBL {

    public void AbrirConexion() throws SQLException, ClassNotFoundException
    {
        ConexionJDBC.abrirConexion();
    }

    public void CerrarConexion() throws SQLException
    {
        ConexionJDBC.cerrarConexion();
    }

    public ResultSet getListRoles() throws SQLException
    {
        ResultSet tablaRoles = null;

        RolDAO rolDao = new RolDAO();
        tablaRoles = rolDao.getRolesList();

        return tablaRoles;
    }

}

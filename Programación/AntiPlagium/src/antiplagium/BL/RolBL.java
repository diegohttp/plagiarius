package antiplagium.BL;

import antiplagium.BE.RolBE;
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

    public void insertRol(RolBE rolBE) throws SQLException
    {
        RolDAO rolDAO = new RolDAO();
        ResultSet tabla = null;
        Integer id = 0;

        tabla = rolDAO.getLastID();
        if (tabla != null)
        {
            while(tabla.next())
            {
                id = (Integer)tabla.getObject("idRol");
            }
        }
        if (id != 0)
        {
            rolDAO.insertRol(id + 1, rolBE.getNombre(), rolBE.getDescripcion());
        } 
    }

}

package antiplagium.BL;

import antiplagium.BE.RolBE;
import antiplagium.DAL.ConexionJDBC;
import antiplagium.DAO.RolDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;


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

    public ResultSet getPrivilegiosPorROl(String nombreROl) throws SQLException
    {
        ResultSet tablaPrivilegios = null;
        RolDAO rolDAO = new RolDAO();
        tablaPrivilegios = rolDAO.getPrivilegiosPorRol(nombreROl);
        return tablaPrivilegios;
    }

    public Vector getPrivilegiosPorROl2(String nombreROl) throws SQLException
    {
        Vector tablaPrivilegios = null;
        RolDAO rolDAO = new RolDAO();
        tablaPrivilegios = rolDAO.getPrivilegiosPorRol2(nombreROl);
        return tablaPrivilegios;
    }

    public void insertRol(RolBE rolBE, ArrayList<Integer> listPrivilegios) throws SQLException
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

            Iterator i = listPrivilegios.iterator();
            while(i.hasNext())
            {
                rolDAO.insertDetallePrivilegio(id + 1, (Integer)i.next());
            }
        } 
    }
    
    public void updateRol(RolBE rolBE, ArrayList<Integer> listPrivilegios) throws SQLException
    {
        RolDAO rolDAO = new RolDAO();
        ResultSet tabla = null;        
                       
        rolDAO.updateRol(rolBE.getIdRol(), rolBE.getNombre(), rolBE.getDescripcion());
    }
}

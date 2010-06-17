package antiplagium.BL;

import antiplagium.BE.PrivilegioBE;
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
                rolBE.setIdRol(id + 1);
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
    
    public void updateRol(RolBE rolBE, ArrayList<PrivilegioBE> listaPrivilegiosSinModificar, ArrayList<Integer> listPrivilegios) throws SQLException
    {
        RolDAO rolDAO = new RolDAO();        
                       
        rolDAO.updateRol(rolBE.getIdRol(), rolBE.getNombre(), rolBE.getDescripcion());
        Boolean encontrado = false;

        for(int i=0; i<listaPrivilegiosSinModificar.size(); i++)
        {
            for(int j=0; j<listPrivilegios.size(); j++)
            {
                if ((int)listaPrivilegiosSinModificar.get(i).getIdPrivilegio() == (int)listPrivilegios.get(j))
                {
                    encontrado = true;
                    break;
                }
            }
            if (!encontrado) rolDAO.deleteDetallePrivilegio(rolBE.getIdRol(), listaPrivilegiosSinModificar.get(i).getIdPrivilegio());
            else encontrado = false;
        }

        for(int i=0; i<listPrivilegios.size(); i++)
        {            
            for(int j=0 ; j<listaPrivilegiosSinModificar.size(); j++)
            {
                if ( (int)listPrivilegios.get(i) == (int)listaPrivilegiosSinModificar.get(j).getIdPrivilegio() )
                {
                    encontrado = true;
                    break;
                }
            }
            if (!encontrado) rolDAO.insertDetallePrivilegio(rolBE.getIdRol(), listPrivilegios.get(i));
            else encontrado = false;
        }
    }

    public void deleteRol(RolBE rolBE) throws SQLException
    {
        RolDAO rolDAO = new RolDAO();

        rolDAO.deletePrivilegios_ROL(rolBE.getIdRol());
        rolDAO.deleteRol(rolBE.getIdRol());
    }
}

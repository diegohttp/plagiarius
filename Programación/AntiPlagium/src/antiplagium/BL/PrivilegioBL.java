package antiplagium.BL;

import antiplagium.DAL.ConexionJDBC;
import antiplagium.DAO.PrivilegioDAO;
import java.sql.*;

public class PrivilegioBL {

public void AbrirConexion() throws SQLException, ClassNotFoundException
    {
        ConexionJDBC.abrirConexion();
    }

    public void CerrarConexion() throws SQLException
    {
        ConexionJDBC.cerrarConexion();
    }

    public ResultSet getListPrivilegioPorRol(String nombreRol) throws SQLException
    {
        ResultSet tablaPrivilegios = null;
        PrivilegioDAO privilegioDAO = new PrivilegioDAO();
        tablaPrivilegios = privilegioDAO.getPrivilegiosPorRol(nombreRol);

        return tablaPrivilegios;
    }

    public ResultSet getListPrivilegios() throws SQLException
    {
        ResultSet tablaPrivilegios = null;
        PrivilegioDAO privilegioDAO = new PrivilegioDAO();
        tablaPrivilegios = privilegioDAO.getListPrivilegios();
        return tablaPrivilegios;
    }

}

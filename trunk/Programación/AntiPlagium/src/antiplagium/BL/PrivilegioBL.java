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

    public ResultSet getListPrivilegioPorRol(Integer idRol) throws SQLException
    {
        ResultSet tablaPrivilegios = null;
        PrivilegioDAO privilegioDAO = new PrivilegioDAO();
        tablaPrivilegios = privilegioDAO.getPrivilegiosPorRol(idRol);

        return tablaPrivilegios;
    }

}

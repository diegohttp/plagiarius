/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package antiplagium.DAO;

import antiplagium.DAL.ConexionJDBC;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author a20030555
 */
public class EstadoDAO {

    public void AbrirConexion() throws SQLException, ClassNotFoundException
    {
        ConexionJDBC.abrirConexion();
    }

    public void CerrarConexion() throws SQLException
    {
        ConexionJDBC.cerrarConexion();
    }

    public ResultSet ConsultarEstados() throws SQLException{

        String query="SELECT * FROM \"Estado\" ";
        ResultSet registrosEstado = ConexionJDBC.ejecutarQueryString(query);
        return registrosEstado;
    }

}

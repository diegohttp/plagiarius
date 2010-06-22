package antiplagium.BL;

import antiplagium.BE.RegistroOperacionBE;
import antiplagium.DAL.ConexionJDBC;
import antiplagium.DAO.registroOperacionDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RegistroOperacionBL{

    ResultSet listaRegistroOperaciones;
    registroOperacionDAO registroOpDAO;
    RegistroOperacionBE registroOperacionBE;

    public ResultSet ObtenerLogOperaciones(int idUsuario,String nombreUsuario,String nombreCategoria,String cadenaFechaI,String cadenaFechaF,String tipoOperacion){
        try {
            registroOpDAO = new registroOperacionDAO();
            listaRegistroOperaciones = registroOpDAO.ConsultarLogOperaciones(idUsuario,nombreUsuario, nombreCategoria, cadenaFechaI, cadenaFechaF, tipoOperacion);
            return listaRegistroOperaciones;
        } catch (SQLException ex) {
            Logger.getLogger(RegistroOperacionBL.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    public void AbrirConexion() throws SQLException, ClassNotFoundException
    {
        ConexionJDBC.abrirConexion();
    }

    public void CerrarConexion() throws SQLException
    {
        ConexionJDBC.cerrarConexion();
    }

    public void insertOperacion(RegistroOperacionBE operacionBE) throws SQLException
    {
        registroOperacionDAO operacionDAO = new registroOperacionDAO();
        operacionDAO.insertOperacion(operacionBE);
    }


}

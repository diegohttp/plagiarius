/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package antiplagium.BL;

import antiplagium.BE.EstadoBE;
import antiplagium.DAO.EstadoDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author a20030555
 */
public class EstadoBL {

    private EstadoDAO estadoDAO;

    public EstadoBL(){
        estadoDAO=new EstadoDAO();

    }

    public ResultSet ObtenerEstados() throws SQLException, ClassNotFoundException{
        estadoDAO.AbrirConexion();
        ResultSet registros=estadoDAO.ConsultarEstados();
        estadoDAO.CerrarConexion();
        return registros;
    }







}

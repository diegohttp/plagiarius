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

    public ResultSet ConsultarEstados(int idEst,String nomb,String descrip) throws SQLException{

        String query="SELECT * FROM \"Estado\" ";
        String where=" WHERE ";
        Boolean anterior=false;
        if (idEst!=0){
            if (anterior==true) { where+=" and ";}
            anterior=true;
            where+=" \"idEstado\" = "+idEst;
        }
        if ((nomb!=null) && (nomb.compareTo("")!=0)){
            if (anterior==true) { where+=" and ";}
            anterior=true;
            where+=" \"Nombre\" = '"+nomb+"'";
        }
        if ((descrip!=null) && (descrip.compareTo("")!=0)){
            if (anterior==true) { where+=" and ";}
            anterior=true;
            where+=" \"Descripcion\" = '"+descrip+"'";
        }

        if(where.compareTo(" WHERE ")!=0){
            query+=where;
        }

        ResultSet registrosEstado = ConexionJDBC.ejecutarQueryString(query);
        return registrosEstado;
    }
}

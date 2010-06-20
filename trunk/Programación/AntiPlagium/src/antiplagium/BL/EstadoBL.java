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

    public ArrayList<EstadoBE> ObtenerEstados(int idEst,String nomb,String descrip) throws SQLException, ClassNotFoundException{
        estadoDAO.AbrirConexion();
        ResultSet registros=estadoDAO.ConsultarEstados(idEst,nomb,descrip);
        ArrayList<EstadoBE> listaEstados=null;
        EstadoBE estadoBE=null;

        if (registros!=null){
           listaEstados=new ArrayList<EstadoBE>();
           while(registros.next()){
               int idEstado=registros.getInt("idEstado");
               String descripcion=registros.getString("Descripcion");
               String nombre=registros.getString("Nombre");
               //System.out.println(idEstado+nombre+descripcion);
               estadoBE=new EstadoBE(idEstado,nombre,descripcion);
               listaEstados.add(estadoBE);
            }
        }
        estadoDAO.CerrarConexion();
        return listaEstados;
    }

}

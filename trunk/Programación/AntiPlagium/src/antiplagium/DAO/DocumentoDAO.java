/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package antiplagium.DAO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import antiplagium.BE.DocumentoBE;
import antiplagium.BL.DocumentoBL;
import antiplagium.DAL.ConexionJDBC;
/**
 *
 * @author PATTY
 */
public class DocumentoDAO {

     public static boolean registrar(DocumentoBE objDocumento) throws Exception
    {
        boolean boolExito = false;

        ConexionJDBC objConexion = new ConexionJDBC();
        String xml = objDocumento.toXml();

        String strSentencia = "INSERT INTO \"Documento\" (\"idDocumento\",estado,nombre,\"idUsuario\",contenido) VALUES ('" + objDocumento.getIdDocumento() +"','"+ objDocumento.getEstado() +"','"+ objDocumento.getNombre() +"','"+ objDocumento.getUsuario() +"','"+ xml +"');";

        try{
            objConexion.ejecutarSentencia(strSentencia);

            boolExito=true;
        }

        catch (Exception a){
            System.out.println(a.getMessage());
        }
        /*finally{objConexion.SalirUID();}*/

        return boolExito;
    }

    public static ArrayList<DocumentoBE> buscar(DocumentoBE doc) throws FileNotFoundException, IOException{

        ConexionJDBC objConexion = new ConexionJDBC();

        String strSentencia = "SELECT \"idDocumento\",\"estado\",\"nombre\",\"idUsuario\" FROM \"Documento\"";
            strSentencia +=
                " WHERE \"nombre\" like '"+ doc.getNombre()+"'||'%' and " +
                " \"idUsuario\" like '"+ doc.getUsuario()+"'||'%' " +
                " ORDER BY \"nombre\";";

        ArrayList<DocumentoBE> arrDocumento = new ArrayList<DocumentoBE>();
        try {
            ResultSet rs = (ResultSet) objConexion.ejecutarQuery(strSentencia);
            String stridDocumento = "";
            String strestado = "";
            String strnombre = "";
            String stridUsuario = "";
            String strcontenido = "";
            while (rs.next()) {
                stridDocumento = rs.getString(1);
                strestado = rs.getString(2);
                strnombre = rs.getString(3);
                stridUsuario = rs.getString(4);
                arrDocumento.add(new DocumentoBE(Integer.parseInt(stridDocumento), (strestado), strnombre,null));
            }
        }
        catch (Exception a){
            System.out.println(a.getMessage());
        }
        return arrDocumento;
    }

    public static DocumentoBE buscar(int idDocumento) throws FileNotFoundException, IOException{

        ConexionJDBC objConexion = new ConexionJDBC();

        String strSentencia =  " SELECT idDocumento, estado, nombre, idUsuario, contenido FROM Documento ";
            strSentencia += " WHERE idDocumento ='"+idDocumento+"' ";

        DocumentoBE objDocumento = new DocumentoBE();

        try {
            ResultSet rs = (ResultSet) objConexion.ejecutarQuery(strSentencia);

            while (rs.next()) {
                objDocumento.setIdDocumento(rs.getInt(1));
                objDocumento.setEstado(rs.getString(2));
                objDocumento.setNombre(rs.getString(3));
                objDocumento.setUsuario(null);
               // objDocumento.setContenido(rs.getInt(4));
            }
        }
        catch (Exception a){
            System.out.println(a.getMessage());
        }
        return objDocumento;
    }


    public static boolean modificar(DocumentoBE objDocumento)throws FileNotFoundException, IOException {

        ConexionJDBC objConexion = new ConexionJDBC();
        String strSentencia = "UPDATE Documento SET ";
            strSentencia += "estado='"+objDocumento.getEstado()+"'," +
                    " nombre='"+objDocumento.getNombre()+ "'"+
                    " WHERE idDocumento='"+objDocumento.getIdDocumento() +"'";
        try{
            objConexion.ejecutarQuery(strSentencia);
            return true;
        }
        catch (Exception a){
            System.out.println(a.getMessage());
            return false;
        }
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package antiplagium.DAO;

import antiplagium.BE.CategoriaBE;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import antiplagium.BE.DocumentoBE;
import antiplagium.BE.UsuarioBE;
import antiplagium.BL.DocumentoBL;
import antiplagium.DAL.ConexionJDBC;
import java.util.Vector;
/**
 *
 * @author PATTY
 */
public class DocumentoDAO {

     public static boolean registrar(DocumentoBE objDocumento) throws Exception {
        boolean boolExito = false;

        ConexionJDBC objConexion = new ConexionJDBC();
        String xml = objDocumento.toXml();

        String strSentencia = "INSERT INTO \"Documento\" (\"idDocumento\",estado,nombre,\"idUsuario\",contenido,\"idCategoria\") VALUES (" + objDocumento.getIdDocumento() +",'"+ objDocumento.getEstado() +"','"+ objDocumento.getNombre() +"','"+ objDocumento.getUsuario().getIdUsuario() +"','"+ xml +"',"+ objDocumento.getCategoria().getIdCategoria() + ")";
        System.out.println(strSentencia);
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

    public static boolean eliminarDocumento(int IdDocumento){
        ConexionJDBC objConexion = new ConexionJDBC();

        String strSentencia = "UPDATE \"Documento\" SET ";
            strSentencia += "estado = 'inactivo'"+ 
                        " WHERE \"idDocumento\" ="+IdDocumento+";";
        try{
            objConexion.ejecutarSentencia(strSentencia);
            return true;
        }
        catch (Exception a){
            System.out.println(a.getMessage());
            return false;
        }
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
            String contenido = "";

            while (rs.next()) {
                stridDocumento = rs.getString(1);
                strestado = rs.getString(2);
                strnombre = rs.getString(3);
                stridUsuario = rs.getString(4);

                //arrDocumento.add(new DocumentoBE(Integer.parseInt(stridDocumento), (strestado), strnombre,null));
            }
        }
        catch (Exception a){
            System.out.println(a.getMessage());
        }
        return arrDocumento;
    }

    public static DocumentoBE buscar(int idDocumento) throws FileNotFoundException, IOException{

        ConexionJDBC objConexion = new ConexionJDBC();


        String strSentencia =  "SELECT \"idDocumento\",\"estado\",\"nombre\",\"idUsuario\" FROM \"Documento\"";
            strSentencia += " WHERE \"idDocumento\" ="+idDocumento+" ";

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
        String strSentencia = "UPDATE \"Documento\" SET ";
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

    
   
    
    public static ArrayList<DocumentoBE> ListarDocs(DocumentoBE objDocumento)throws FileNotFoundException, IOException, SQLException {

        ConexionJDBC objConexion = new ConexionJDBC();

        String strSentencia = "SELECT * FROM \"Documento\"";

        boolean esprimero=true;
        String prop="", cat="",est="", nom="";

        if (objDocumento.getUsuario() != null) {
            prop="\"idUsuario\" = "+ objDocumento.getUsuario().getIdUsuario();
            if (esprimero) {
                prop = " WHERE "+ prop;
                esprimero=false;
            }
            else prop  =" AND "+ prop;
        }

        if (objDocumento.getNombre().compareTo("")!=0) {
            nom="nombre like '%"+ objDocumento.getNombre() + "%'";
            if (esprimero) {
                prop += " WHERE "+ nom;
                esprimero=false;
            }
            else prop +=" AND " + nom;
        }

        if (objDocumento.getEstado().compareTo("")!=0) {
            est ="estado like '%"+ objDocumento.getEstado() + "%'";
            if (esprimero) {
                prop += " WHERE "+ est;
                esprimero=false;
            }
            else prop +=" AND "+ est;
        }

        if (objDocumento.getCategoria() != null){
            cat ="\"idCategoria\" = "+ objDocumento.getCategoria().getIdCategoria();
            if (esprimero) {
                prop += " WHERE "+ cat;
                esprimero=false;
            }
            else prop += " AND "+ cat;
        }

        strSentencia += prop;

        strSentencia +=" ORDER BY \"idDocumento\"";

        System.out.println(strSentencia);
       
        Vector arrDocumento;
        arrDocumento = objConexion.ejecutarQuery(strSentencia);
        ArrayList<DocumentoBE> gestorDocumento = new ArrayList<DocumentoBE>();

        for (int i=0; i < arrDocumento.size(); ++i){
            Object[] registro = (Object[])arrDocumento.get(i);
            /*DocumentoBE doc = new DocumentoBE();
            doc.setIdDocumento((Integer)registro[0]);
            doc.setEstado((String)registro[1]);
            doc.setNombre((String)registro[2]);
            UsuarioBE objUsuario = new UsuarioBE();
            objUsuario.setIdUsuario(Integer.parseInt((String)registro[3]));
            doc.setUsuario(objUsuario);
            CategoriaBE objCategoria = new CategoriaBE();
            objCategoria.setIdCategoria((Integer)registro[5]);
            doc.setCategoria(objCategoria);*/
            DocumentoBE doc = null;
            String contenido = (String)registro[4];
            doc = DocumentoBL.getFromXml(contenido);
            gestorDocumento.add(doc);
        }
        return gestorDocumento;
    }
}

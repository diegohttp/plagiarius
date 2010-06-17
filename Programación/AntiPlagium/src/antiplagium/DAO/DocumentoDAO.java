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
import antiplagium.BL.CategoriaBL;
import antiplagium.BL.DocumentoBL;
import antiplagium.BL.UsuarioBL;
import antiplagium.DAL.ConexionJDBC;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author PATTY
 */
public class DocumentoDAO {

     public static boolean registrar(DocumentoBE objDocumento) throws Exception {
        boolean boolExito = false;

        ConexionJDBC objConexion = new ConexionJDBC();
        //String xml = objDocumento.toXml();

        String strSentencia = "INSERT INTO \"Documento\" (\"idDocumento\",estado,nombre,\"idUsuario\",contenido,\"idCategoria\") VALUES (" + objDocumento.getIdDocumento() +",'"+ objDocumento.getEstado() +"','"+ objDocumento.getNombre() +"','"+ objDocumento.getUsuario().getIdUsuario() +"','"+ objDocumento.getContenido() +"',"+ objDocumento.getCategoria().getIdCategoria() + ")";
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

    public static boolean existeDocumento(String nombre){
        ConexionJDBC objConexion = new ConexionJDBC();
        String strSentecia = "SELECT * FROM \"Documento\" WHERE nombre = " + nombre + " AND estado = 'activo'";
        try {
            Vector lst = objConexion.ejecutarQuery(strSentecia);
            return lst.size() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(DocumentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
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


     public static DocumentoBE buscarIdDoc(int idDocumento) throws FileNotFoundException, IOException, SQLException{
        DocumentoBE doc = null;

            String strSentencia = "SELECT * FROM \"Documento\" WHERE \"idDocumento\" = " + idDocumento;
            ConexionJDBC objConexion = new ConexionJDBC();
            Vector arrDocumento;
            arrDocumento = objConexion.ejecutarQuery(strSentencia);
            ArrayList<DocumentoBE> gestorDocumento = new ArrayList<DocumentoBE>();
            for (int i = 0; i < arrDocumento.size(); ++i) {
                Object[] registro = (Object[]) arrDocumento.get(i);


            CategoriaBL objCategoriaBL = new CategoriaBL();
            int idCategoria= (Integer)registro[5];
            CategoriaBE cat = objCategoriaBL.buscarIdCategoria(idCategoria);

            UsuarioBL objUsuarioBL = new UsuarioBL();
            String idUsuario= (String)(registro[3]);
            UsuarioBE usr = objUsuarioBL.getUsuarioBE(Integer.parseInt(idUsuario));


                gestorDocumento.add(new DocumentoBE((Integer) registro[0], (String) registro[1], (String) registro[2], usr, cat));
            }
            doc = gestorDocumento.get(0);
            return doc;

           // public DocumentoBE(int idDocumento, String estado, String nombre, UsuarioBE idUsuario,CategoriaBE categoria)


    }


    public static boolean modificar(DocumentoBE objDocumento)throws FileNotFoundException, IOException {

        ConexionJDBC objConexion = new ConexionJDBC();
        String strSentencia = "UPDATE \"Documento\" SET ";
        strSentencia += " nombre = '"+objDocumento.getNombre()+ "',"+
                " \"idCategoria\" = " + objDocumento.getCategoria().getIdCategoria();
        strSentencia += ", contenido = '" + objDocumento.getContenido() + "'";
        strSentencia += " WHERE \"idDocumento\" = " + objDocumento.getIdDocumento();
        System.out.println(strSentencia);
        try{
            objConexion.ejecutarSentencia(strSentencia);
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
            /*  DocumentoBE doc = new DocumentoBE();
                doc.setIdDocumento((Integer)registro[0]);
            */
            DocumentoBE doc = null;
            String contenido = (String)registro[4];
            int idCategoria = (Integer)registro[5];
            CategoriaBE categoria = CategoriaBL.buscarIdCategoria(idCategoria);
            //doc = DocumentoBL.getFromXml(contenido);
            doc = new DocumentoBE();
            doc.setCategoria(categoria);
            doc.setNombre((String)registro[2]);
            doc.setEstado((String)registro[1]);
            doc.setContenido(contenido);
            UsuarioBE objUsuario = new UsuarioBE();
            objUsuario.setIdUsuario(Integer.parseInt((String)registro[3]));
            doc.setUsuario(objUsuario);
            doc.setIdDocumento((Integer)registro[0]);
            gestorDocumento.add(doc);
        }
        return gestorDocumento;
    }

    public static boolean validarNombre(String nombre) {
        boolean exito = false;
        ConexionJDBC objConexion = new ConexionJDBC();
        String strSentencia = "SELECT nombre FROM \"Documento\" WHERE upper(nombre) = '" + nombre + "'";
        try {
            Vector res = objConexion.ejecutarQuery(strSentencia);
            return res.size() == 0;
        } catch (SQLException ex) {
            exito = false;
            Logger.getLogger(DocumentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return exito;
    }

    public static DocumentoBE buscarIdDocumento(int idDocumento) {
        String strSentencia = "SELECT * FROM \"Documento\" WHERE \"idDocumento\" = " + idDocumento;
        DocumentoBE doc = null;
        ConexionJDBC objConexion = new ConexionJDBC();
        try {
            Vector res = objConexion.ejecutarQuery(strSentencia);
            for (int i=0; i < res.size(); ++i){
                Object[] registro = (Object[])res.get(i);
                /*  DocumentoBE doc = new DocumentoBE();
                    doc.setIdDocumento((Integer)registro[0]);
                */
                String contenido = (String)registro[4];
                int idCategoria = (Integer)registro[5];
                CategoriaBE categoria = CategoriaBL.buscarIdCategoria(idCategoria);
                //doc = DocumentoBL.getFromXml(contenido);
                doc = new DocumentoBE();
                doc.setCategoria(categoria);
                doc.setNombre((String)registro[2]);
                doc.setEstado((String)registro[1]);
                doc.setContenido(contenido);
                UsuarioBE objUsuario = new UsuarioBE();
                objUsuario.setIdUsuario(Integer.parseInt((String)registro[3]));
                doc.setUsuario(objUsuario);
                doc.setIdDocumento((Integer)registro[0]);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DocumentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return doc;
    }
}

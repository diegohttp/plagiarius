/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package antiplagium.DAO;

import antiplagium.BE.CategoriaBE;
import antiplagium.BE.DocumentoBE;
import antiplagium.BL.DocumentoBL;
import antiplagium.BE.ResultadoDeteccionBE;
import antiplagium.BE.UsuarioBE;
import antiplagium.BL.CategoriaBL;
import antiplagium.DAL.ConexionJDBC;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

/**
 *
 * @author PATTY
 */
public class ResultadoDeteccionDAO {


   public static ArrayList<ResultadoDeteccionBE> ListarDocsDetectados(ResultadoDeteccionBE objResultadoDeteccion, Date Fechaini, Date Fechafin)throws FileNotFoundException, IOException, SQLException {

        ConexionJDBC objConexion = new ConexionJDBC();

        String strSentencia = "SELECT \"Documento1\", \"Documento2\", \"PorcentajePlagio\", \"Resultado\", \"Fecha\"  FROM \"ResultadoDeteccion\", \"Documento\"";

        boolean esprimero=true;
        String prop="", cat="",fechaini="", fechafin="", ids="";

        if (objResultadoDeteccion.getDocumento1().getUsuario() != null) {
            prop="\"idUsuario\" = "+ objResultadoDeteccion.getDocumento1().getUsuario().getIdUsuario();
            if (esprimero) {
                prop = " WHERE "+ prop;
                esprimero=false;
            }
            else prop  =" AND "+ prop;
        }

        if (objResultadoDeteccion.getDocumento1().getCategoria() != null){
            cat ="\"idCategoria\" = "+ objResultadoDeteccion.getDocumento1().getCategoria().getIdCategoria();
            if (esprimero) {
                prop += " WHERE "+ cat;
                esprimero=false;
            }
            else prop += " AND "+ cat;
        }

        if (Fechaini != null){
            fechaini = "\"Fecha\" > "+ Fechaini;
            if (esprimero) {
                prop += " WHERE "+ fechaini;
                esprimero=false;
            }
            else prop += " AND "+ fechaini;
        }

        if (Fechafin != null){
            fechafin = "\"Fecha\" > "+ Fechafin;
            if (esprimero){
                prop += " WHERE "+ fechafin;
                esprimero=false;
            }
            else prop += " AND "+ fechafin;
        }

        ids = "\"idDocumento\" = \"Documento1\" ";
        if (esprimero){
                prop += " WHERE "+ ids;
                esprimero=false;
            }
            else prop += " AND "+ ids;


        strSentencia += prop;

        //strSentencia +=" ORDER BY \"idDocumento\"";

        System.out.println(strSentencia);

        Vector arrResultado;
        arrResultado = objConexion.ejecutarQuery(strSentencia);
        ArrayList<ResultadoDeteccionBE> gestorResultado = new ArrayList<ResultadoDeteccionBE>();

        for (int i=0; i < arrResultado.size(); ++i){
            Object[] registro = (Object[])arrResultado.get(i);



            DocumentoBE Documento1 = null;
            ResultadoDeteccionBE Resultado = null;
        
//            int idCategoria = (Integer)registro[5];
//            CategoriaBE categoria = CategoriaBL.buscarIdCategoria(idCategoria);
//
//            doc = new DocumentoBE();
//            doc.setCategoria(categoria);
//            UsuarioBE objUsuario = new UsuarioBE();
//            objUsuario.setIdUsuario(Integer.parseInt((String)registro[3]));
//            doc.setUsuario(objUsuario);

            Resultado = new ResultadoDeteccionBE();
            DocumentoBL objDocumentoBL = new DocumentoBL();

            int idDocumento1= (Integer)registro[1];
            DocumentoBE Doc1 = objDocumentoBL.buscarIdDocumento(idDocumento1);
            Resultado.setDocumento1(Doc1);

            int idDocumento2= (Integer)registro[2];
            DocumentoBE Doc2 = objDocumentoBL.buscarIdDocumento(idDocumento2);
            Resultado.setDocumento2(Doc2);

            float porcentaje= (Float)registro[3];
            Resultado.setPorcentajePlagio(porcentaje);

            String resultado = (String)registro[4];
            Resultado.setResultado(resultado);

            Date fecha = (Date)registro[5];
            Resultado.setFecha(fecha);

            gestorResultado.add(Resultado);
        }
        return gestorResultado;
    }

}

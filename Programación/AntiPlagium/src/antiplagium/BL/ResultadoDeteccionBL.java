/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package antiplagium.BL;

import antiplagium.BE.DocumentoBE;
import antiplagium.BE.ResultadoDeteccionBE;
import antiplagium.DAO.ResultadoDeteccionDAO;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author PATTY
 */
public class ResultadoDeteccionBL {


     public static ArrayList<ResultadoDeteccionBE> ListarDocsDetectados(ResultadoDeteccionBE objResultado, Date Fechaini, Date Fechafin) throws FileNotFoundException, IOException, SQLException {
        return ResultadoDeteccionDAO.ListarDocsDetectados(objResultado,Fechaini,Fechafin);
    }


}

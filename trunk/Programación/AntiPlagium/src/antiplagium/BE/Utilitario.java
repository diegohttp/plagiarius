/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package antiplagium.BE;

import antiplagium.DAL.ConexionJDBC;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.ResultSet;

/**
 *
 * @author a20057070
 */
public final class Utilitario {
    public static boolean esAlphanumerico(Character caracter){
        char c = caracter.charValue();
        if ( !(Character.isLetterOrDigit(c) //si es letra
                || c == ' ' //o un espacio
                || c == 8 //o backspace
            ))
            return false;
        else
            return true;
    }
    public static boolean esLetra(Character caracter){
        char c = caracter.charValue();
        if ( !(Character.isLetter(c) //si es letra
                || c == ' ' //o un espacio
                || c == 8 //o backspace
            ))
            return false;
        else
            return true;
    }
    public static boolean esEmailValido(String text){
        Pattern regex = Pattern.compile("^([0-9a-zA-Z]([-.\\w]*[0-9a-zA-Z])*@([0-9a-zA-Z][-\\w]*[0-9a-zA-Z]\\.)+[a-zA-Z]{2,9})$");
        Matcher m = regex.matcher(text);
        return m.matches();

    }

    //Ejemplo de llamada Utilitario.generaCodigo("Usuario", 5)
    //intCantidadCaracteres es el numero de caracteres de ese ID en la base de datos
    //tienen que revisar cuantos caracteres tiene el ID de esa tabla: hay de 5, 10 y 15

    public static String generaCodigo(String strNombreTabla, int intCantidadCaracteres) throws FileNotFoundException, IOException {
        ConexionJDBC objConexion = new ConexionJDBC();
        String strSentencia = "SELECT MAX(Id"+strNombreTabla+") FROM "+strNombreTabla;
        String strId = "";


        try {
            ResultSet rs = (ResultSet) objConexion.ejecutarQuery(strSentencia);

            if (rs.next()) {
                strId = rs.getString(1);
                if (strId!=null && !strId.equals("")) {
                    int intId = Integer.parseInt(strId);
                    intId++;
                    strId = "" + intId;
                    while (strId.length() < intCantidadCaracteres)
                        strId = "0" + strId;
                }
                else{
                    strId="";
                    for( int i=1; i<intCantidadCaracteres;i++) strId +="0";
                    strId +=1;
                }
             }
             else{
                 strId="";
                 for( int i=1; i<intCantidadCaracteres;i++) strId +="0";
                 strId +=1;
             }

        }
        catch (Exception a){
            System.out.println(a.getMessage());
        }

        return strId;
    }
}

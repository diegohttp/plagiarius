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

    public static boolean esDigito(Character caracter){
        char c = caracter.charValue();
        if ( !(Character.isDigit(c) //si es letra
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

    public static int generaCodigo(String strNombreTabla) throws FileNotFoundException, IOException {
        ConexionJDBC objConexion = new ConexionJDBC();
        String strSentencia = "SELECT MAX(\"id"+strNombreTabla+"\") FROM \""+strNombreTabla+"\"";
        String strId = "";
        /* para debuging */
        System.out.println(strSentencia);

        try {
            ResultSet rs = (ResultSet) objConexion.ejecutarQueryResultSet(strSentencia);
            int intId;
            if (rs.next()){
                strId = rs.getString(1);
                if (strId!=null && !strId.equals("")) {
                    intId = Integer.parseInt(strId);
                    intId++;
                    return intId;
                }
                else{
                    intId = 1;
                    return intId;
                }
             }
             else{
                 intId = 1;
                 return 1;
             }

        }
        catch (Exception a){
            System.out.println(a.getMessage());
        }
        return 0;
    }
}

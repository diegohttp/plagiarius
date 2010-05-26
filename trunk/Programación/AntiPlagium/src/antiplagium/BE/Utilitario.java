/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package antiplagium.BE;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
}

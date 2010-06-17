package antiplagium.BE;

import com.thoughtworks.xstream.XStream;
import antiplagium.BE.ErrorXMLBE;
import java.awt.Component;
import java.io.FileReader;
import java.io.Serializable;
import java.util.HashMap;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class GestorError implements Serializable{
    private static HashMap<String,String> errores;
    private static Component ventana;

    public static void populate(String url) throws Exception
    {
        XStream xml = new XStream();
        configurarXML(xml);

        ErrorXMLBE[] temp;

        FileReader archivo = new FileReader(url);
        temp = (ErrorXMLBE[])xml.fromXML(archivo);
        archivo.close();

        errores = new HashMap<String,String>();

        for(int i=0; i<temp.length; i++)
        {
            errores.put(temp[i].getNombre().toLowerCase(), temp[i].getMensaje());
        }
    }

    private static void configurarXML(XStream xml)
    {
		xml.alias("Errores", ErrorXMLBE[].class);
		xml.alias("Error", ErrorXMLBE.class);
    }

    public static String getError(String nombre)
    {
        return errores.get(nombre.toLowerCase());
    }

    public  static void showError(String nombre)
    {
        JOptionPane.showMessageDialog(ventana, getError(nombre.toLowerCase()), "ERROR", JOptionPane.ERROR_MESSAGE);
    }
}

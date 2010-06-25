package antiplagium.BE;

import com.thoughtworks.xstream.XStream;
import java.awt.Component;
import java.io.FileReader;
import java.util.HashMap;
import javax.swing.JOptionPane;


public class GestorTiposOperacion {

    private static HashMap<String,String> TipoOperaciones;
    private static Component ventana;

    public static void populate(String url) throws Exception
    {
        XStream xml = new XStream();
        configurarXML(xml);
        
        TipoOperacionXMLBE[] temp;

        FileReader archivo = new FileReader(url);
        temp = (TipoOperacionXMLBE[])xml.fromXML(archivo);
        archivo.close();

        TipoOperaciones = new HashMap<String,String>();

        for(int i=0; i<temp.length; i++)
        {
            TipoOperaciones.put(temp[i].getNombre().toLowerCase(), temp[i].getdescripcion());
        }
    }

    private static void configurarXML(XStream xml)
    {
		xml.alias("TiposOperaciones", TipoOperacionXMLBE[].class);
		xml.alias("TipoOperacion", TipoOperacionXMLBE.class);
    }

    public static String getTipoOperacion(String nombre)
    {
        String operacion = "";
        
        if (nombre.compareToIgnoreCase("ingreso")==0) operacion = "Inicio de sesion";
        else if (nombre.compareToIgnoreCase("salida")==0) operacion = "Salida del sistema";
        else if (nombre.compareToIgnoreCase("consulta")==0) operacion = "Consulta al sistema";
        else if (nombre.compareToIgnoreCase("modifica")==0) operacion = "Modificacion de registro";
        else if (nombre.compareToIgnoreCase("registra")==0) operacion = "Creacion de nuevo registro";
        else if (nombre.compareToIgnoreCase("eliminacion")==0) operacion = "Eliminacion de registro";
        else if (nombre.compareToIgnoreCase("comparacion")==0) operacion = "Comparacion de documentos";
        else if (nombre.compareToIgnoreCase("reporte")==0) operacion = "Generacion de reporte";

        return operacion;
    }

    public  static void showError(String nombre)
    {
        JOptionPane.showMessageDialog(ventana, getTipoOperacion(nombre.toLowerCase()), "ERROR", JOptionPane.ERROR_MESSAGE);
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package prueba;

import org.apache.poi.poifs.eventfilesystem.POIFSReaderEvent;
import org.apache.poi.poifs.eventfilesystem.POIFSReaderListener;

/**
 *
 * @author a20057070
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String filename = "/usr/home/a20057070/Texto de prueba para leer.doc";
        AnalizadorWord analizador = new AnalizadorWord(filename);
        try {
            analizador.analizar();
        } catch (Exception e2) {
            System.out.println("Error"+e2.toString());
        }

        System.out.println(analizador);
   }

}

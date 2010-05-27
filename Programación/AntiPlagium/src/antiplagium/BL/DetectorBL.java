/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package antiplagium.BL;

/**
 *
 * @author a20057070
 */
import antiplagium.BE.ConexionOracionBE;
import antiplagium.BE.DocumentoBE;
import antiplagium.BE.OracionBE;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
/**
 *
 * @author Administrador
 */
public class DetectorBL {
    public ArrayList<ConexionOracionBE> listaConexiones= new ArrayList<ConexionOracionBE>();
    public static ArrayList<String> listaPalNoSignificativas= new ArrayList<String>();
    public int comparar(DocumentoBL doc1, DocumentoBL doc2){
        int numOr1= doc1.getNumeroOraciones();
        int numOr2= doc2.getNumeroOraciones();

        for (int i=0; i<numOr1; i++){
            ConexionOracionBE con=null;
            for (int j=0; j<numOr2; j++){
                int resultado=compararOraciones(doc1.getOracion(i),doc2.getOracion(j));
                if (resultado>=70) {
                    ConexionOracionBE con2= new ConexionOracionBE(doc1.getIdDocumento(), doc2.getIdDocumento(),i, j, resultado );
                    if (con==null) con=con2;
                    else if (con2.getPorcentaje()>con.getPorcentaje()) con=con2;
                    if (con.getPorcentaje()==100) break;

                }
            }
            this.listaConexiones.add(con);
        }

        return promedioDeConexionOracionBEes();
    }

    public static void cargarPalabrasNoSignificativas(){
        BufferedReader entrada = null;
        try {

            File f = new File("PNS.txt");
            entrada = new BufferedReader(new FileReader(f));
            while (entrada.ready()){
                String linea=entrada.readLine();
                DetectorBL.listaPalNoSignificativas.add(linea);
            }
        } catch (Exception ex) {
            System.out.print("error"+ex);
        }
    }
    public int promedioDeConexionOracionBEes(){
        int sum=0;
        for (int i=0; i<listaConexiones.size(); i++){
            sum+=listaConexiones.get(i).getPorcentaje();
        }
        if (listaConexiones.size()==0) return 0;
        return sum/listaConexiones.size();
    }
    public int compararOraciones(OracionBE or1, OracionBE or2){

        int numPal1=or1.getNumeroPalabras();
        int numPal2=or2.getNumeroPalabras();
        int numRep=0;

        for (int i=0; i<numPal1; i++){
            if (or2.contienePalabra(or1.getPalabra(i))) numRep++;
        }
        int porc1=(int)((float)numRep/numPal1*100);
        int porc2=(int)((float)numRep/numPal2*100);
        return (porc1+porc2)/2;
    }
}

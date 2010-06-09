/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package antiplagium.BL;

import antiplagium.BE.*;
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
    private int resultado;
    public static ArrayList<String> listaPalNoSignificativas= new ArrayList<String>();
    public static String letrasNoSignificativas= "";


    public void comparar(DocumentoBE doc1, DocumentoBE doc2){
        int numOr1= doc1.getListaOraciones().size();
        int numOr2= doc2.getListaOraciones().size();

        for (int i=0; i<numOr1; i++){
            ConexionOracionBE con=null;
            for (int j=0; j<numOr2; j++){
                int resultadoOr=compararOraciones(doc1.getListaOraciones().get(i),doc2.getListaOraciones().get(j));
                if (resultadoOr>=70) {
                    ConexionOracionBE con2= new ConexionOracionBE(doc1.getIdDocumento(), doc2.getIdDocumento(),i, j, resultadoOr );
                    if (con==null) con=con2;
                    else if (con2.getPorcentaje()>con.getPorcentaje()) {
                        con=con2;
                        if (con.getPorcentaje()==100) break;
                    }

                }
            }
            if (con!=null) this.listaConexiones.add(con);
        }

        resultado=  promedioDeConexiones();
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

    public static void cargarLetrasNoSignificativas(){
        BufferedReader entrada = null;
        try {

            File f = new File("LNS.txt");
            entrada = new BufferedReader(new FileReader(f));
            while (entrada.ready()){
                String linea=entrada.readLine();
                DetectorBL.letrasNoSignificativas+=linea;

            }
        } catch (Exception ex) {
            System.out.print("error"+ex);
        }
    }
    public int promedioDeConexiones(){
        int sum=0;
        for (int i=0; i<listaConexiones.size(); i++){
            sum+=listaConexiones.get(i).getPorcentaje();
        }
        if (listaConexiones.size()==0) return 0;
        return sum/listaConexiones.size();
    }
    public int compararOraciones(OracionBE or1, OracionBE or2){

        int numPal1=or1.getHashPalabras().size();
        int numPal2=or2.getHashPalabras().size();
        int numRep=0;

        for (int i=0; i<numPal1; i++){
            if (or2.getHashPalabras().containsKey(or1.getListaPalabras().get(i).toString())) numRep++;
        }
        int porc1=(int)((float)numRep/numPal1*100);
        int porc2=(int)((float)numRep/numPal2*100);
        return (porc1+porc2)/2;
    }

    public ArrayList<ConexionOracionBE> getListaConexiones() {
        return listaConexiones;
    }

    public void setListaConexiones(ArrayList<ConexionOracionBE> listaConexiones) {
        this.listaConexiones = listaConexiones;
    }

    public int getResultado() {
        return resultado;
    }

    public void setResultado(int resultado) {
        this.resultado = resultado;
    }
}




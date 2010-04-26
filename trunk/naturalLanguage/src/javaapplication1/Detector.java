/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package javaapplication1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Locale;

/**
 *
 * @author Administrador
 */
public class Detector {
    public ArrayList<Conexion> listaConexiones= new ArrayList<Conexion>();
    public static ArrayList<String> listaPalNoSignificativas= new ArrayList<String>();
    public int comparar(Documento doc1, Documento doc2){
        int numOr1= doc1.listaOraciones.size();
        int numOr2= doc2.listaOraciones.size();

        for (int i=0; i<numOr1; i++){
            Conexion con=null;
            for (int j=0; j<numOr2; j++){
                int resultado=compararOraciones(doc1.listaOraciones.get(i),doc2.listaOraciones.get(j));
                if (resultado>=70) {
                    Conexion con2= new Conexion(doc1.numeroDocumento, doc2.numeroDocumento,i, j, resultado );
                    if (con==null) con=con2;
                    else if (con2.porcentaje>con.porcentaje) con=con2;
                    if (con.porcentaje==100) break;
                    
                }
            }
            this.listaConexiones.add(con);
        }

        return promedioDeConexiones();
    }

    public static void cargarPalabrasNoSignificativas(){
        BufferedReader entrada = null;
        try {

            File f = new File("PNS.txt");
            entrada = new BufferedReader(new FileReader(f));
            while (entrada.ready()){
                String linea=entrada.readLine();
                Detector.listaPalNoSignificativas.add(linea);
            }
        } catch (Exception ex) {
            System.out.print("error"+ex);
        }
    }
    public int promedioDeConexiones(){
        int sum=0;
        for (int i=0; i<listaConexiones.size(); i++){
            sum+=listaConexiones.get(i).porcentaje;
        }
        if (listaConexiones.size()==0) return 0;
        return sum/listaConexiones.size();
    }
    public int compararOraciones(Oracion or1, Oracion or2){

        int numPal1=or1.hashPalabras.size();
        int numPal2=or2.hashPalabras.size();
        int numRep=0;

        for (int i=0; i<numPal1; i++){            
            if (or2.hashPalabras.containsKey(or1.listaPalabras.get(i).toString())) numRep++;
        }
        int porc1=(int)((float)numRep/numPal1*100);
        int porc2=(int)((float)numRep/numPal2*100);
        return (porc1+porc2)/2;
    }
}




/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package javaapplication1;

import java.util.ArrayList;

/**
 *
 * @author Administrador
 */
public class Detector {
    public ArrayList<Conexion> listaConexiones= new ArrayList<Conexion>();
    public int comparar(Documento doc1, Documento doc2){
        int numOr1= doc1.listaOraciones.size();
        int numOr2= doc2.listaOraciones.size();

        for (int i=0; i<numOr1; i++){
            for (int j=0; j<numOr2; j++){
                int resultado=compararOraciones(doc1.listaOraciones.get(i),doc2.listaOraciones.get(j));
                if (resultado>=70) {
                    Conexion con= new Conexion(doc1.numeroDocumento, doc2.numeroDocumento,i, j, resultado );
                    listaConexiones.add(con);
                }
            }
        }

        return promedioDeConexiones();
    }

    public int promedioDeConexiones(){
        int sum=0;
        for (int i=0; i<listaConexiones.size(); i++){
            sum+=listaConexiones.get(i).porcentaje;
        }
        return sum/listaConexiones.size();
    }
    public int compararOraciones(Oracion or1, Oracion or2){

        int numPal1=or1.listaPalabras.size();
        int numPal2=or2.listaPalabras.size();
        int numRep=0;

        for (int i=0; i<numPal1; i++){
            if (or2.hashPalabras.containsKey(or1.listaPalabras.get(i))) numRep++;
            
        }
        int porc1=(int)((float)numRep/numPal1*100);
        int porc2=(int)((float)numRep/numPal2*100);
        return (porc1+porc2)/2;
    }
}




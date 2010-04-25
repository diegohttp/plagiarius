/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package javaapplication1;

/**
 *
 * @author Administrador
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Detector dec= new Detector();
        Documento doc1= new Documento("arch1.txt",1);
        Documento doc2= new Documento("arch2.txt",2);

        int res=dec.comparar(doc1, doc2);
        int res2=(int)((float)res*dec.listaConexiones.size()/doc1.listaOraciones.size());


        System.out.println("Número de oraciones plagiadas:"+dec.listaConexiones.size());
        System.out.println("Promedio de porcentaje de plagio en oraciones:"+res);
        System.out.println("Porcentaje del documento plagiado:"+res2);

    }

}

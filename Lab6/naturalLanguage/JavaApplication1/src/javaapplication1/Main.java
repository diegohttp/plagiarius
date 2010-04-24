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
        Documento doc1= new Documento("doc1.txt",1), doc2= new Documento("doc2.txt",2);
        
        int res=dec.comparar(doc1, doc2);

        System.out.println(""+res);

    }

}

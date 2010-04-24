/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package javaapplication1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

/**
 *
 * @author Administrador
 */
public class Documento {
    public int numeroDocumento;
    public String nombre="";
    public ArrayList<Oracion> listaOraciones= new ArrayList<Oracion>();

    public Documento(String nom, int num){
        this.numeroDocumento=num;
        File f = new File( nom );
        try {
            BufferedReader entrada = new BufferedReader( new FileReader( f ) );
            while (entrada.ready()){
                String linea=entrada.readLine();
                String[] palabras= linea.split(" ");
                Oracion or = new Oracion();
                for (int i=0; i<palabras.length; i++){
                    or.listaPalabras.add(palabras[i]);
                    or.hashPalabras.put(palabras[i], i);
                }
                this.listaOraciones.add(or);

            }
        } catch (Exception e){
        }
    }


}

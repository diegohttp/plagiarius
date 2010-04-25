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
public class Documento {
    public int numeroDocumento;
    public String nombre="";
    public ArrayList<Oracion> listaOraciones= new ArrayList<Oracion>();

    public Documento(String nombre, int num){
        this.numeroDocumento=num;
        BufferedReader entrada = null;
        try {

            File f = new File(nombre);
            entrada = new BufferedReader(new FileReader(f));
            while (entrada.ready()){
                Oracion or= new Oracion();
                String linea=entrada.readLine();
                linea=linea.toLowerCase(Locale.ENGLISH);
                if (linea.compareTo("")==0) continue;
                String [] listaPalabras=linea.split(" ");
                for (int i=0; i<listaPalabras.length; i++){
                    String pal=listaPalabras[i];                    
                    pal= limpiarPalabra(pal);
                    if (pal.compareTo("")==0) continue;

                    or.listaPalabras.add(pal);
                    or.hashPalabras.put(pal, i);
                }
                this.listaOraciones.add(or);
            }


        } catch (Exception ex) {
            System.out.print("error"+nombre);
        }
    }

    public String limpiarPalabra(String palabra){
        String pal="";
        for (int i=0; i<palabra.length(); i++){
            char c= palabra.charAt(i);
            if (c==',' || c=='.' || c=='?' || c=='¿' || c=='!' || c=='¡'){
                continue;
            }
            
            switch (c) {
                case 'á': c='a'; break;
                case 'é': c='e'; break;
                case 'í': c='i'; break;
                case 'ó': c='o'; break;
                case 'ú': c='u'; break;
            }

            pal+=c;
        }

        return pal;
    }

}








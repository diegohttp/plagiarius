/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrador
 */
public class Main {

    public static int numDoc = 0;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Detector.cargarPalabrasNoSignificativas();

        BD bd = new BD();
        cargarDocumentos(bd);

        String nombre = JOptionPane.showInputDialog("Ingresar nonbre de documento a comparar:");

        Detector dec = null;

        ArrayList<Documento> documentoEnParrafos = Documento.CargarDocumentoParrafos("docs/"+nombre, -1, 4);

        int res = 0;

        for (int numParr = 0; numParr < documentoEnParrafos.size(); numParr++) {
            for (int i = 0; i < bd.hashDocumentos.size(); i++) {
                String nomActual = bd.listaNombres.get(i);
                if (nomActual.compareToIgnoreCase(nombre) != 0) {
                    dec = new Detector();
                    res = dec.comparar(documentoEnParrafos.get(numParr), (Documento) bd.hashDocumentos.get(nomActual));
                    int res2 = (int) ((float) res * dec.listaConexiones.size() / documentoEnParrafos.get(numParr).listaOraciones.size());
                    System.out.println("Documentos comparados: " + nombre + " (parrafo "+numParr+") contra " + nomActual);
                    System.out.println("Número de oraciones plagiadas:" + dec.listaConexiones.size());
                    System.out.println("Promedio de porcentaje de plagio en oraciones:" + res);
                    System.out.println("Porcentaje del documento plagiado:" + res2);
                    System.out.println();
                }
            }
        }


    }

    public static void cargarDocumentos(BD bd) {

        BufferedReader entrada = null;
        try {
            File f = new File("DocumentosBD.txt");
            entrada = new BufferedReader(new FileReader(f));
            int i = 0;
            while (entrada.ready()) {
                String linea = entrada.readLine();
                Documento doc = new Documento("docs/" + linea, i);
                bd.hashDocumentos.put(linea, doc);
                bd.listaNombres.add(linea);
                i++;
            }
        } catch (Exception ex) {
            System.out.print("error" + ex);
        }
    }
}

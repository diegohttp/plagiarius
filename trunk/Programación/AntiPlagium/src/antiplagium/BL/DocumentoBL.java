package antiplagium.BL;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import antiplagium.BE.OracionBE;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Locale;

/**
 *
 * @author KIM
 */
public class DocumentoBL {

    public int idDocumento;
    public String nombre = "";
    public ArrayList<OracionBE> listaOraciones = new ArrayList<OracionBE>();

    public DocumentoBL() {
    }

    public DocumentoBL(String contenido, int id) {
        this.idDocumento = id;
        BufferedReader entrada = null;
        try {
            entrada = new BufferedReader(new StringReader(contenido));
            while (entrada.ready()) {
                OracionBE or = new OracionBE();
                String linea = entrada.readLine();
                linea = linea.toLowerCase(Locale.ENGLISH);
                if (linea.compareTo("") == 0) {
                    continue;
                }
                String[] listaPalabras = linea.split(" ");
                for (int i = 0; i < listaPalabras.length; i++) {
                    String pal = listaPalabras[i];
                    //Quitar palabras repetidas y no significativas
                    if (or.getListaPalabras().contains(pal) || DetectorBL.listaPalNoSignificativas.contains(pal)) {
                        continue;
                    }

                    pal = limpiarPalabra(pal);
                    if (pal.compareTo("") == 0) {
                        continue;
                    }

                    or.getListaPalabras().add(pal);
                    or.getHashPalabras().put(pal, i);
                }
                if (or.getListaPalabras().size() > 0) {
                    this.listaOraciones.add(or);
                }
            }


        } catch (Exception ex) {
            System.out.print("error" + nombre);
        }
    }

    public static String limpiarPalabra(String palabra) {
        String pal = "";
        for (int i = 0; i < palabra.length(); i++) {
            char c = palabra.charAt(i);
            if (c == ',' || c == '.' || c == '?' || c == '¿' || c == '!' || c == '¡') {
                continue;
            }

            switch (c) {
                case 'á':
                    c = 'a';
                    break;
                case 'é':
                    c = 'e';
                    break;
                case 'í':
                    c = 'i';
                    break;
                case 'ó':
                    c = 'o';
                    break;
                case 'ú':
                    c = 'u';
                    break;
            }

            pal += c;
        }

        return pal;
    }

}








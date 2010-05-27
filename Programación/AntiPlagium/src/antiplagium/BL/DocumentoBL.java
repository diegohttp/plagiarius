package antiplagium.BL;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import antiplagium.BE.OracionBE;
import com.thoughtworks.xstream.XStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Locale;

import java.io.FileInputStream;
import org.apache.poi.hpsf.PropertySetFactory;
import org.apache.poi.hpsf.SummaryInformation;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.poifs.eventfilesystem.POIFSReader;
import org.apache.poi.poifs.eventfilesystem.POIFSReaderEvent;
import org.apache.poi.poifs.eventfilesystem.POIFSReaderListener;

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

    private String toXml(){
        XStream xstream = new XStream();
        xstream.alias("documento", DocumentoBL.class);
        xstream.alias("oracion", OracionBE.class);
        return xstream.toXML(this);
    }
    public DocumentoBL(String contenido) {

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

    public static String obtenerContenido(File f) {
        String contenido = "";
        try {
            String extension = f.getAbsolutePath().substring(f.getAbsolutePath().lastIndexOf('.'), f.getAbsolutePath().lastIndexOf('.') + 4);
 
            if (extension.compareToIgnoreCase(".txt") == 0) {
                BufferedReader entrada = new BufferedReader(new FileReader(f));
                while (entrada.ready()) {
                    contenido += entrada.readLine() + "\n";
                }

            } else if (extension.compareToIgnoreCase(".doc") == 0) {

                AnalizadorWord analizador = new AnalizadorWord(f.getAbsolutePath());

                    analizador.analizar();



                contenido= analizador.getTexto();

            } else;//MENSAJE DE ERROR DE FORMATO
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        System.out.print(contenido);
        return contenido;
    }
}

class AnalizadorWord {

    private int numeroCaracteres;
    private int numeroPalabras;
    private int numeroPaginas;
    private String titulo;
    private String autor;
    private String comentarios;
    private String texto;
    private String nombreFichero;

    public AnalizadorWord(String nombreFichero) {
        this.nombreFichero = nombreFichero;
    }

    void setTexto(String text) {
        this.texto = text;
    }

    void setTitulo(String title) {
        this.titulo = title;
    }

    void setAutor(String author) {
        this.autor = author;
    }

    void setComentarios(String comments) {
        this.comentarios = comments;
    }

    void setNumeroCaracteres(int charCount) {
        this.numeroCaracteres = charCount;
    }

    void setNumeroPalabras(int wordCount) {
        this.numeroPalabras = wordCount;
    }

    void setNumeroPaginas(int pageCount) {
        this.numeroPaginas = pageCount;
    }

    public String getNombreFichero() {
        return this.nombreFichero;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public String getAutor() {
        return this.autor;
    }

    public void analizar() throws Exception {
        POIFSReader r1 = new POIFSReader();

        FileInputStream fis = null;

        // Registramos el listener para después analizar la información.

        StandardReaderListener stdReader = new StandardReaderListener();

        stdReader.setDatos(this);

        r1.registerListener(stdReader, "\005SummaryInformation");

        try {

            // Forzamos la lectura del documento.
            fis = new FileInputStream(this.nombreFichero);
            r1.read(fis);
        } catch (Exception e) {
            System.out.println("Error->" + e.toString());
        } finally {
            if (fis != null) {
                fis.close();
            }
        }

    }

    public String toString() {
        StringBuffer sb = new StringBuffer("");

        sb.append("\n TITULO DEL DOCUMENTO:" + getTitulo());
        sb.append("\n AUTOR DEL DOCUMENTO:" + getAutor());
        sb.append("\n COMENTARIOS DEL DOCUMENTO:" + getComentarios());
        sb.append("\n NUMERO DE CARACTERES:" + getNumeroCaracteres());
        sb.append("\n NUMERO DE PALABRAS:" + getNumeroPalabras());
        sb.append("\n NUMERO DE PAGINAS:" + getNumeroPaginas());
        sb.append("\n ------ TEXTO --------");
        sb.append("\n");
        sb.append(getTexto());
        sb.append("\n ------ TEXTO --------");
        return sb.toString();
    }

    public String getComentarios() {
        return this.comentarios;
    }

    public int getNumeroCaracteres() {
        return this.numeroCaracteres;
    }

    public int getNumeroPalabras() {
        return this.numeroPalabras;
    }

    public int getNumeroPaginas() {
        return this.numeroPaginas;
    }

    public String getTexto() {
        return this.texto;
    }
}

class StandardReaderListener implements POIFSReaderListener {

    private AnalizadorWord datos = null;

    public void setDatos(AnalizadorWord datos) {
        this.datos = datos;
    }

    public void processPOIFSReaderEvent(POIFSReaderEvent event) {
        // Clase que almacena las características estándar de un documento.
        SummaryInformation si = null;

        try {
            si = (SummaryInformation) PropertySetFactory.create(event.getStream());
        } catch (Exception ex) {
            throw new RuntimeException("Property set stream \"" +
                    event.getPath() + event.getName() + "\": " + ex);
        }

        /* Recogemos los datos que nos interesan y los almacenamos en la clase AnalizadorWord.*/

        datos.setTitulo(si.getTitle());
        datos.setAutor(si.getAuthor());
        datos.setComentarios(si.getComments());
        datos.setNumeroCaracteres(si.getCharCount());
        datos.setNumeroPalabras(si.getWordCount());
        datos.setNumeroPaginas(si.getPageCount());

        /* Usamos la clase WordExtractor para obtener el texto del documento */
        WordExtractor we = null;
        try {
            FileInputStream fis = new FileInputStream(datos.getNombreFichero());
            we = new WordExtractor(fis);
            fis.close();
        } catch (Exception e1) {
            System.out.println("Error->" + e1.toString());
        }
        datos.setTexto(we.getText());
    }
}





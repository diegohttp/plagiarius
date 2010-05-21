/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package prueba;

import java.io.FileInputStream;
import org.apache.poi.poifs.eventfilesystem.POIFSReader;
import org.apache.poi.poifs.eventfilesystem.POIFSReaderListener;

/**
 *
 * @author a20057070
 */
public class AnalizadorWord {
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

    public String getNombreFichero(){
        return this.nombreFichero;
    }
    public String getTitulo(){
        return this.titulo;
    }
    public String getAutor(){
        return this.autor;
    }

    public void analizar() throws Exception {
        POIFSReader r1 = new POIFSReader();

        FileInputStream fis=null;

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
            if(fis!=null)
                fis.close();
        }

    }

    public String toString() {
        StringBuffer sb = new StringBuffer("");

        sb.append("\n TITULO DEL DOCUMENTO:"+getTitulo());
        sb.append("\n AUTOR DEL DOCUMENTO:"+getAutor());
        sb.append("\n COMENTARIOS DEL DOCUMENTO:"+getComentarios());
        sb.append("\n NUMERO DE CARACTERES:"+getNumeroCaracteres());
        sb.append("\n NUMERO DE PALABRAS:"+getNumeroPalabras());
        sb.append("\n NUMERO DE PAGINAS:"+getNumeroPaginas());
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

    public String getTexto(){
        return this.texto;
    }
}

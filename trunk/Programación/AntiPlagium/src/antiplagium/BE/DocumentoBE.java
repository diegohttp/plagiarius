///*
// * To change this template, choose Tools | Templates
// * and open the template in the editor.
// */
package antiplagium.BE;

import antiplagium.BL.DetectorBL;
import antiplagium.BL.DocumentoBL;
import com.thoughtworks.xstream.XStream;
import java.io.BufferedReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Locale;

///**
// *
// * @author PATTY
public class DocumentoBE {

    private int idDocumento;
    private String estado;
    private String nombre;
    private UsuarioBE idUsuario;
    private CategoriaBE categoria;
    private ArrayList<OracionBE> listaOraciones = new ArrayList<OracionBE>();

    public DocumentoBE() {
    }

    public DocumentoBE(int idDocumento, String estado, String nombre, UsuarioBE idUsuario) {
        this.estado = estado;
        this.idDocumento = idDocumento;
        this.idUsuario = idUsuario;
        this.nombre = nombre;
    }

    public DocumentoBE(int id, String est, String nom, UsuarioBE Us, String contenido) {
        this.idDocumento = id;
        this.estado = est;
        this.nombre = nom;
        this.idUsuario = Us;

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

                    pal = DocumentoBL.limpiarPalabra(pal);
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
            System.out.print("error" + ex.toString());
        }
    }

    public int getIdDocumento() {
        return this.idDocumento;
    }

    public void setIdDocumento(int idDocumento) {
        this.idDocumento = idDocumento;
    }

    public String getEstado() {
        return this.estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public UsuarioBE getUsuario() {
        return this.idUsuario;
    }
    //en la BD dice string!!

    public void setUsuario(UsuarioBE idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String toXml() {
        XStream xstream = new XStream();
        xstream.alias("documento", DocumentoBE.class);
        xstream.alias("oracion", OracionBE.class);
        return xstream.toXML(this);
    }

    public void setListaraciones(ArrayList<OracionBE> lista) {
        this.listaOraciones = lista;
    }

    public OracionBE getOracion(int idx) {
        return this.listaOraciones.get(idx);
    }

    public int getNumeroOraciones() {
        return this.listaOraciones.size();
    }

    public void addOracion(OracionBE oracion) {
        this.listaOraciones.add(oracion);
    }

    public String toString() {
        String contenido = "";
        for (int i = 0; i < this.listaOraciones.size(); i++) {
            OracionBE or = this.listaOraciones.get(i);
            for (int j = 0; j < or.getListaPalabras().size(); j++) {
                contenido += or.getListaPalabras().get(j);
            }
            contenido += "\n";

        }
        return contenido;
    }
}

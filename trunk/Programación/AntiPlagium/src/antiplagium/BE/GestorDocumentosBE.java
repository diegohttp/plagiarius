/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package antiplagium.BE;

import java.util.ArrayList;

/**
 *
 * @author a20057070
 */
public class GestorDocumentosBE {
    private ArrayList<DocumentoBE> gestorDocumento;
    public GestorDocumentosBE(){
        this.gestorDocumento = new ArrayList<DocumentoBE>();
    }
    public void GestorDocumentosBE(ArrayList<DocumentoBE> gs){
        this.gestorDocumento = gs;
    }
    public int cantElementos(){
        return this.gestorDocumento.size();
    }

    public void remove(int i){
        this.gestorDocumento.remove(i);
    }
    public void add(DocumentoBE elem){
        if (elem != null) this.gestorDocumento.add(elem);
    }
    public DocumentoBE get(int idx){
        if (idx < 0 || this.gestorDocumento.size() - 1 < idx)
            return null;
        return this.gestorDocumento.get(idx);
    }
    public boolean contains(DocumentoBE doc){
        return this.gestorDocumento.contains(doc);
    }
}

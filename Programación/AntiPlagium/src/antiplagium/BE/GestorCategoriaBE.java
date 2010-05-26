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
public class GestorCategoriaBE {
    private ArrayList<CategoriaBE> gestorCatergoria;
    public GestorCategoriaBE(){
        gestorCatergoria = new ArrayList<CategoriaBE>();
    }
    public void GestorCategoria(ArrayList<CategoriaBE> gs){
        this.gestorCatergoria = gs;
    }
    public CategoriaBE get(int idx){
        if (idx < 0 || this.gestorCatergoria.size() - 1 < idx) return null;
        else return this.get(idx);
    }
    public void add(CategoriaBE elem){
        this.gestorCatergoria.add(elem);
    }
    public int cantElementos(){
        return this.gestorCatergoria.size();
    }

}

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
    public CategoriaBE get(int idx){
        if (this.gestorCatergoria.isEmpty() || this.gestorCatergoria.size() - 1 < idx) return null;
        else return this.get(idx);
    }
    public void add(CategoriaBE elem){
        this.gestorCatergoria.add(elem);
    }
    public int cantElementos(){
        return this.gestorCatergoria.size();
    }

}

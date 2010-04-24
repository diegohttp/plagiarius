/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package secuenciasmaximales;
import java.util.ArrayList;

/**
 *
 * @author alulab
 */
public class NodoPalabra {
    private int idPalabra;
    private ArrayList<Integer> pos;
    private ArrayList<Enlace> sig;

    NodoPalabra(int idxPalabra){
        this.idPalabra = idxPalabra;
        this.pos = new ArrayList<Integer>();
        this.sig = new ArrayList<Enlace>();
    }

    public void insertarReferencia(int pos){
        this.pos.add(pos);
    }

    public void insertarEnlace(int sigNodo,int idxReferencia){
        sig.add(new Enlace(sigNodo,idxReferencia));
    }

    public int getUltimaReferncia(){
        return pos.size() - 1;
    }

    public int getIdPalabra(){
        return this.idPalabra;
    }

    public int getNextNodo(int ref){
        return this.sig.get(ref).getSigNodo();
    }

    public int getNextReferencia(int ref){
        return this.sig.get(ref).getReferencia();
    }

    public ArrayList<Integer> getPosiciones(){
        return this.pos;
    }

    public ArrayList<Enlace> getSiguientes(){
        return this.sig;
    }
}

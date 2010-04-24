/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package secuenciasmaximales;

/**
 *
 * @author Renzo
 */
public class NodoOcurrencia {
    private int idDoc;
    private int idNodo;

    NodoOcurrencia(int idDoc,int idNodo){
        this.idDoc = idDoc;
        this.idNodo = idNodo;
    }
    public int getIdNodo(){
        return this.idNodo;
    }
    public int getIdDoc(){
        return this.idDoc;
    }
}

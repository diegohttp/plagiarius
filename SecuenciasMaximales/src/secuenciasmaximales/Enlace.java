/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package secuenciasmaximales;

/**
 *
 * @author alulab
 */
public class Enlace {
    private int sigNodo;
    private int idxReferencia;
    Enlace(int sigNodo,int idxReferencia){
        this.idxReferencia = idxReferencia;
        this.sigNodo = sigNodo;
    }

    public int getSigNodo(){
        return this.sigNodo;
    }

    public int getReferencia(){
        return this.idxReferencia;
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package antiplagium.BE;

import java.awt.Point;

/**
 *
 * @author a20057070
 */
public class ConexionOracionBE {
    private Point documentosConectados= new Point();
    private Point oracionesConectadas= new Point();
    private int porcentaje=0;

    public ConexionOracionBE(int numDoc1, int numDoc2, int numOr1, int numOr2, int porc){
        documentosConectados.x=numDoc1;
        documentosConectados.y=numDoc2;

        oracionesConectadas.x=numOr1;
        oracionesConectadas.y=numOr2;

        porcentaje=porc;
    }
    public int getPorcentaje(){
        return this.porcentaje;
    }

    public Point getDocumentosConectados() {
        return documentosConectados;
    }

    public void setDocumentosConectados(Point documentosConectados) {
        this.documentosConectados = documentosConectados;
    }

    public Point getOracionesConectadas() {
        return oracionesConectadas;
    }

    public void setOracionesConectadas(Point oracionesConectadas) {
        this.oracionesConectadas = oracionesConectadas;
    }
}

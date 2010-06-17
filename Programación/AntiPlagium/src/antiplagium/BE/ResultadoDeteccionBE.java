/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package antiplagium.BE;

import java.util.Date;

/**
 *
 * @author PATTY
 */
public class ResultadoDeteccionBE {
    private int idDeteccion;
    private DocumentoBE Documento1;
    private DocumentoBE Documento2;
    private int PorcentajePlagio;
    private String Resultado;
    private Date Fecha;

    public void ResultadoComparacion(DocumentoBE Documento1, DocumentoBE Documento2, int PorcentajePlagio, Date Fecha) {
        this.Documento1 = Documento1;
        this.Documento2 = Documento2;
        this.PorcentajePlagio = PorcentajePlagio;
        this.Fecha = Fecha;
    }

    public int getidDeteccion(){
       return this.idDeteccion;
    }

    public void setidDeteccion(int idDeteccion){
        this.idDeteccion = idDeteccion;
    }

    public DocumentoBE getDocumento1() {
        return this.Documento1;
    }

     public void setDocumento1(DocumentoBE Documento1) {
        this.Documento1 = Documento1;
    }

    public DocumentoBE getDocumento2(){
        return this.Documento2;
    }

   public void setDocumento2(DocumentoBE Documento2){
       this.Documento2 = Documento2;
   }

    public String getResultado(){
        return this.Resultado;
    }
    public void setResultado(String Resultado){
        this.Resultado = Resultado;
    }

    public int getPorcentajePlagio(){
        return this.PorcentajePlagio;
    }

    public void setPorcentajePlagio(int PorcentajePlagio){
        this.PorcentajePlagio = PorcentajePlagio;
    }
    public Date getFecha(){
        return this.Fecha;
    }

    public void setFecha(Date Fecha){
       this.Fecha = Fecha;
    }


}

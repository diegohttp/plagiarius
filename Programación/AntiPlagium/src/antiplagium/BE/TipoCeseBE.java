/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package antiplagium.BE;

/**
 *
 * @author a20057070
 */
public class TipoCeseBE {
    private int idTipoCese;
    private String descripcion;
    private String nombre;
    public TipoCeseBE(int idTipoCese,String descripcion,String nombre){
        this.descripcion = descripcion;
        this.idTipoCese = idTipoCese;
        this.nombre = nombre;
    }
    public int getIdTipoCese(){
        return this.idTipoCese;
    }
    public String getNombre(){
        return this.nombre;
    }
    public String getDescripcion(){
        return this.descripcion;
    }
    public void setIdTipoCese(int idTipoCese){
        this.idTipoCese = idTipoCese;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }
}

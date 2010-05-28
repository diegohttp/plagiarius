/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package antiplagium.BE;

/**
 *
 * @author piere
 */
public class TipoCeseBE {


    private int idTipoCEse;
     private String nombre;
    private String descripcion;

    public TipoCeseBE(int id,String nomb,String desc){
        this.idTipoCEse=id;
        this.nombre=nomb;
        this.descripcion=desc;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getIdTipoCEse() {
        return idTipoCEse;
    }

    public void setIdTipoCEse(int idTipoCEse) {
        this.idTipoCEse = idTipoCEse;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }





}


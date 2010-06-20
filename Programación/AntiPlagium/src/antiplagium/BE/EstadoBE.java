/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package antiplagium.BE;

/**
 *
 * @author a20030555
 */
public class EstadoBE {

    private int idEstado;
    private String nombre;
    private String descripcion;

    public EstadoBE(int idestado,String nombre,String descripcion){
        this.idEstado=idestado;
        this.nombre=nombre;
        this.descripcion=descripcion;

    }

    public EstadoBE() {

    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String toString(){
        return this.nombre;
    }


}

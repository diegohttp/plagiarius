/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package antiplagium.BE;

/**
 *
 * @author PATTY
 */
public class CategoriaBE {
    private int idCategoria;
    private String descripcion;
    private String nombre;
    public CategoriaBE(int idCategoria,String descripcion,String nombre){
        this.descripcion = descripcion;
        this.idCategoria = idCategoria;
        this.nombre = nombre;
    }
    public int getIdCategoria(){
        return this.idCategoria;
    }
    public String getNombre(){
        return this.nombre;
    }
    public String getDescripcion(){
        return this.descripcion;
    }
    public void setIdCategoria(int idCategoria){
        this.idCategoria = idCategoria;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }
}

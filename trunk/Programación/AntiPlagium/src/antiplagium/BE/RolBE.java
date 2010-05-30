/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package antiplagium.BE;

import java.util.ArrayList;

/**
 *
 * @author USER
 */
public class RolBE {

    private Integer idRol;
    private String  nombre;
    private String  descripcion;

    private ArrayList<Integer> privilegios;

    public void RolBE(String nombre,String descripcion)
    {
        this.setNombre(nombre);
        this.setDescripcion(descripcion);
    }
    
    public Integer getIdPrivilegio() {
        return idRol;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public String getDescripcion() {
        return descripcion;
    }

    public ArrayList<Integer> getPrivilegios() {
        return privilegios;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
 
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }



}

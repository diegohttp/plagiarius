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

    private Integer idPrivilegio;
    private String  nombre;
    private String  descripcion;

    private ArrayList<Integer> privilegios;

    public void RolBE(String nombre,String descripcion)
    {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
    
    public Integer getIdPrivilegio() {
        return idPrivilegio;
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



}

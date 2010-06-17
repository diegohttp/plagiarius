package antiplagium.BE;

import java.util.ArrayList;


public class RolBE {

    private Integer idRol;
    private String  nombre;
    private String  descripcion;

    private ArrayList<Integer> privilegios;

    public RolBE()
    {
        this.setIdRol(0);
        this.setNombre("");
        this.setDescripcion("");        
    }

    public RolBE(int idRol, String nombre,String descripcion)
    {
        this.setIdRol(idRol);
        this.setNombre(nombre);
        this.setDescripcion(descripcion);
    }

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


    public Integer getIdRol() {
        return idRol;
    }

    public void setIdRol(Integer idRol) {
        this.idRol = idRol;
    }

    @Override
    public String toString()
    {
        return this.getNombre();
    }
            
}

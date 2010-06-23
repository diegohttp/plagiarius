package antiplagium.BE;

import java.util.ArrayList;


public class RolBE {

    private Integer idRol;
    private String  nombre;
    private String  estado;

    private ArrayList<Integer> privilegios;

    public RolBE()
    {
        this.setIdRol(0);
        this.setNombre("");
        this.setEstado("");
    }

    public RolBE(int idRol, String nombre,String estado)
    {
        this.setIdRol(idRol);
        this.setNombre(nombre);
        this.setEstado(estado);
    }

    public void RolBE(String nombre,String estado)
    {
        this.setNombre(nombre);
        this.setEstado(estado);
    }
    
    public Integer getIdPrivilegio() {
        return idRol;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public String getEstado() {
        return estado;
    }

    public ArrayList<Integer> getPrivilegios() {
        return privilegios;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
 
    public void setEstado(String descripcion) {
        this.estado = descripcion;
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

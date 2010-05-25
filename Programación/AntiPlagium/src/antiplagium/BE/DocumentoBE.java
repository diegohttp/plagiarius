///*
// * To change this template, choose Tools | Templates
// * and open the template in the editor.
// */
package antiplagium.BE;

import java.util.ArrayList;

///**
// *
// * @author PATTY
public class DocumentoBE {
    private int idDocumento;
    private int estado;
    private String nombre;
    private int idUsuario;
    /* Nota: Patty Agrege este atributo, porque lo usa la clase Detector para hacer las comparaciones de docs */
    private ArrayList<OracionBE> listaOraciones = new ArrayList<OracionBE>();
    DocumentoBE(int idDocumento,int estado,String nombre,int idUsuario){
        this.estado = estado;
        this.idDocumento = idDocumento;
        this.idUsuario = idUsuario;
        this.nombre = nombre;
    }
    DocumentoBE(int idDocumento,int estado,String nombre,int idUsuario,ArrayList<OracionBE> listaOraciones){
        this.estado = estado;
        this.idDocumento = idDocumento;
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.listaOraciones = listaOraciones;
    }
    public int getIdDocumento(){
        return this.idDocumento;
    }
  public int getEstado(){
      return this.estado;
  }
  public int getIdUsuario(){
        return this.idUsuario;
  }
  public String getNombre(){
        return this.nombre;
  }
    public OracionBE getOracion(int idx){
        return this.listaOraciones.get(idx);
    }
    public int getNumeroOraciones(){
        return this.listaOraciones.size();
   }
   public void addOracion(OracionBE oracion){
        this.listaOraciones.add(oracion);
    }
}

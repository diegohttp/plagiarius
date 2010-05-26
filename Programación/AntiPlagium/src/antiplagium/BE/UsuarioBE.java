/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package antiplagium.BE;

import java.util.ArrayList;
import java.util.Date;

public class UsuarioBE {

    private int idUsuario;
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String nombreUsuario;
    private String password;
    private Date fechaRegistro;
    private Date fechaVencimiento;
    private Date fechaCese;
    private String estado;
    private RolBE idRol;
    private ArrayList<CategoriaBE> categorias;
    private TipoCeseBE idTipoCese;

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public ArrayList<CategoriaBE> getCategorias() {
        return categorias;
    }

    public void setCategorias(ArrayList<CategoriaBE> categorias) {
        this.categorias = categorias;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaCese() {
        return fechaCese;
    }

    public void setFechaCese(Date fechaCese) {
        this.fechaCese = fechaCese;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public RolBE getIdRol() {
        return idRol;
    }

    public void setIdRol(RolBE idRol) {
        this.idRol = idRol;
    }

    public TipoCeseBE getIdTipoCese() {
        return idTipoCese;
    }

    public void setIdTipoCese(TipoCeseBE idTipoCese) {
        this.idTipoCese = idTipoCese;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UsuarioBE ( int idUsuario,String nombres,String apellidoPaterno,String apellidoMaterno,String nombreUsuario,String password,Date fechaRegistro,Date fechaVencimiento,Date fechaCese,String estado,RolBE idRol,ArrayList<CategoriaBE> categorias, TipoCeseBE idTipoCese){

           this.idUsuario=idUsuario;
           this.nombres=nombres;
           this.apellidoPaterno=apellidoPaterno;
           this.apellidoMaterno=apellidoMaterno;
           this.nombreUsuario=nombreUsuario;
           this.password=password;
           this.fechaRegistro=fechaRegistro;
           this.fechaVencimiento=fechaVencimiento;
           this.fechaCese=fechaCese;
           this.estado=estado;
           this.idRol=idRol;
           this.categorias=categorias;
           this.idTipoCese=idTipoCese;
     }

    public UsuarioBE(){

    }





}

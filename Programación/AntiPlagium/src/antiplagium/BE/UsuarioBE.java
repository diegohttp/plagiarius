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
    private EstadoBE estadoBE;
    private RolBE rolBE;
    private ArrayList<CategoriaBE> categorias;
    private TipoCeseBE tipoCeseBE;
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public EstadoBE getEstadoBE() {
        return estadoBE;
    }

    public void setEstadoBE(EstadoBE estadoBE) {
        this.estadoBE = estadoBE;
    }

    public RolBE getRolBE() {
        return rolBE;
    }

    public void setRolBE(RolBE rolBE) {
        this.rolBE = rolBE;
    }


    public TipoCeseBE getTipoCeseBE() {
        return tipoCeseBE;
    }

    public void setTipoCeseBE(TipoCeseBE tipoCeseBE) {
        this.tipoCeseBE = tipoCeseBE;
    }

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

    public UsuarioBE ( int idUsuario,String nombres,String apellidoPaterno,String apellidoMaterno,String nombreUsuario,String password,Date fechaRegistro,Date fechaVencimiento,Date fechaCese,EstadoBE estadoBE,RolBE rolBE,ArrayList<CategoriaBE> categorias, TipoCeseBE tipoCeseBE, String email){

           this.idUsuario=idUsuario;
           this.nombres=nombres;
           this.apellidoPaterno=apellidoPaterno;
           this.apellidoMaterno=apellidoMaterno;
           this.nombreUsuario=nombreUsuario;
           this.password=password;
           this.fechaRegistro=fechaRegistro;
           this.fechaVencimiento=fechaVencimiento;
           this.fechaCese=fechaCese;
           this.estadoBE=estadoBE;
           this.rolBE=rolBE;
           this.categorias=categorias;
           this.tipoCeseBE=tipoCeseBE;
           this.email=email;
     }

    public UsuarioBE(){

    }





}

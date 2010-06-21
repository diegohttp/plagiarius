package antiplagium.BE;

import java.util.Date;

public class RegistroOperacionBE {

    private Integer idOperacion;
    private Integer idUsuario;
    private String nombreVentana;
    private Date fecha;
    private String tipoOperacion;
    private String descripcion;

    public RegistroOperacionBE(Integer idUsuario, Date fechaOperacion)
    {
        this.idUsuario = idUsuario;        
        this.fecha = fechaOperacion;    
    }

    public void setOperacion(String nombreVentana, String tipoOperacion, String descripcion)
    {
        this.nombreVentana = nombreVentana;
        this.tipoOperacion = tipoOperacion;
        this.descripcion = descripcion;
    }
    
    public Integer getIdOperacion()
    {
        return idOperacion;
    }

    public void setIdOperacion(int idOperacion)
    {
        this.idOperacion = idOperacion;
    }

    public Integer getIdUsuario()
    {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario)
    {
        this.idUsuario = idUsuario;
    }

    public String getNombreVentana()
    {
        return nombreVentana;
    }

    public void setNombreVentana(String nombreVentana)
    {
        this.nombreVentana = nombreVentana;
    }

    public Date getFechaOperacion() 
    {
        return fecha;
    }

    public void setFechaOperacion(Date fechaOperacion)
    {
        this.fecha = fechaOperacion;
    }

    public String getTipoOperacion()
    {
        return tipoOperacion;
    }

    public void setTipoOperacion(String tipoOperacion)
    {
        this.tipoOperacion = tipoOperacion;
    }

    public String getDescripcion()
    {
        return descripcion;
    }

    public void setDescripcion(String descripcion)
    {
        this.descripcion = descripcion;
    }
}

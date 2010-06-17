package antiplagium.BE;

import java.io.Serializable;

public class TipoOperacionXMLBE implements Serializable
{
    private String nombre;
    private String descripcion;

    public String getNombre()
    {
        return nombre;
    }

    public String getdescripcion()
    {
        return descripcion;
    }
}

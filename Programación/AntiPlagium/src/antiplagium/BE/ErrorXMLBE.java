package antiplagium.BE;
import java.io.Serializable;

public class ErrorXMLBE implements Serializable
{
    private String nombre;
    private String mensaje;

    public String getNombre()
    {
        return nombre;
    }

    public String getMensaje()
    {
        return mensaje;
    }
}

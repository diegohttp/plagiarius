package antiplagium.BE;

public class PrivilegioBE
{
    private Integer idPrivilegio;
    private String  nombrePrivilegio;

    public PrivilegioBE(Integer idPrivilegio, String nombrePrivilegio)
    {
        this.idPrivilegio = idPrivilegio;
        this.nombrePrivilegio = nombrePrivilegio;
    }
    
    public Integer getIdPrivilegio() {
        return idPrivilegio;
    }

    public void setIdPrivilegio(Integer idPrivilegio) {
        this.idPrivilegio = idPrivilegio;
    }

    public String getNombrePrivilegio() {
        return nombrePrivilegio;
    }

    public void setNombrePrivilegio(String nombrePrivilegio) {
        this.nombrePrivilegio = nombrePrivilegio;
    }
}

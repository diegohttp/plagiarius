package antiplagium.DAO;

import antiplagium.BE.RegistroOperacionBE;
import java.sql.SQLException;
import antiplagium.DAL.ConexionJDBC;

public class registroOperacionDAO {

//"INSERT INTO \"Operacion\"(\"idOperacion\", \"idUsuario\", \"nombreVentana\", \"fecha\", \"tipoOperacion\", \"descripcion\") "  +
//"VALUES (1, 1, 'administrarRoles', '05/16/2010', 'guardar registro', 'guardar registro') " ;

    private String SQL_INSERT_OPERACION = "INSERT INTO \"Operacion\"(\"idOperacion\", \"idUsuario\", \"nombreVentana\", \"fecha\", \"tipoOperacion\", \"descripcion\") "  +
                                      "VALUES ( " ;
    

    public void  insertRol(RegistroOperacionBE registroOperacion) throws SQLException
    {
        String SQL_Insert = null;

        SQL_Insert = SQL_INSERT_OPERACION + 
                     registroOperacion.getIdUsuario().toString() + ", " +
                     registroOperacion.getNombreVentana()  + ", " +
                     registroOperacion.getFechaOperacion() + ", " +
                     registroOperacion.getTipoOperacion()  + ", " +
                     registroOperacion.getDescripcion()    + " )" ;

        ConexionJDBC.ejecutarUpdateString(SQL_Insert);
    }

}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package antiplagium.BL;

import antiplagium.BE.OperacionBE;
import java.util.ArrayList;

/**
 *
 * @author piere
 */
public class OperacionBL {
    private ArrayList<OperacionBE> listaOp;

    public ArrayList<OperacionBE> getListaOp() {
        return listaOp;
    }

    public OperacionBL(){

        listaOp=new ArrayList<OperacionBE>();
        listaOp.add(new OperacionBE(1,"Cargar Documento","El usuario ha subido a la BD un documento"));
        listaOp.add(new OperacionBE(2,"Eliminar Documento","El usuario ha eliminado a la BD un documento"));
        listaOp.add(new OperacionBE(3,"Comparar Documento","El usuario realizo la comparacion de un documento"));
        listaOp.add(new OperacionBE(4,"Cambiar Contrasena","El usuario cambio la contrasena"));
        listaOp.add(new OperacionBE(5,"Emitir Reportes de deteccion","El usuario emitio reportes de deteccion"));
    }


}

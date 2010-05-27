/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package antiplagium.BL;

/**
 *
 * @author PATTY
 */

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import antiplagium.DAO.CategoriaDAO;
import antiplagium.BE.*;


public class CategoriaBL {


    public boolean registrarCategoria(CategoriaBE objCategoria) throws Exception {

        if(CategoriaDAO.registrar(objCategoria)){
            return true;
        }
        return false;
    }

    public boolean modificarCategoria(CategoriaBE objCategoria ) throws Exception {

        if (CategoriaDAO.modificar(objCategoria)){
            return true;
        }

        return false;
    }

    public ArrayList<CategoriaBE> buscarCategoria(String descripcion, String nombre) throws FileNotFoundException, IOException, SQLException{
        return CategoriaDAO.buscar(descripcion,nombre);
    }

    public CategoriaBE buscarCategoria(int idCategoria) throws FileNotFoundException, IOException{
        return CategoriaDAO.buscar(idCategoria);
    }
}





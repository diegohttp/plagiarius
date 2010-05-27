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


    public boolean registrarCategoria(String descripcion, String nombre) throws Exception {
        boolean exito = false;

       // CategoriaBE objCategoria = new CategoriaBE (Integer.parseInt (Utilitario.generaCodigo("Categoria",4)), descripcion, nombre);

        CategoriaBE objCategoria = new CategoriaBE (1, descripcion, nombre);
        
        if(CategoriaDAO.registrar((CategoriaBE)objCategoria)){
            exito = CategoriaDAO.registrar(objCategoria);
        }
        return exito;
    }

    public boolean modificarCategoria(CategoriaBE objCategoria ) throws Exception {

        boolean exito = false;

        if (CategoriaDAO.modificar((CategoriaBE)objCategoria)){
            exito = CategoriaDAO.modificar(objCategoria);
        }

        return exito;
    }

    public ArrayList<CategoriaBE> buscarCategoria(String descripcion, String nombre) throws FileNotFoundException, IOException, SQLException{
        return CategoriaDAO.buscar(nombre,descripcion);
    }

    public CategoriaBE buscarCategoria(int idCategoria) throws FileNotFoundException, IOException{
        return CategoriaDAO.buscar(idCategoria);
    }
}





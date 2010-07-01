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
import antiplagium.DAL.ConexionJDBC;
import java.util.logging.Level;
import java.util.logging.Logger;


public class CategoriaBL {


    public boolean registrarCategoria(CategoriaBE objCategoria) throws Exception {
        ConexionJDBC.abrirConexion();
        if(CategoriaDAO.registrar(objCategoria)){
            return true;
        }
        return false;
    }

    public boolean modificarCategoria(CategoriaBE objCategoria ) throws Exception {
        ConexionJDBC.abrirConexion();
        if (CategoriaDAO.modificar(objCategoria)){
            return true;
        }
        return false;
    }

    public ArrayList<CategoriaBE> buscarCategoria(String descripcion, String nombre) {
        try {
            return CategoriaDAO.buscar(descripcion, nombre);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CategoriaBL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CategoriaBL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CategoriaBL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static int indexCategoria(ArrayList<CategoriaBE> arrCategoria,String nomCategoria){

        int intIndex=-1;
        for( int i=0; i< arrCategoria.size();i++){
            if (arrCategoria.get(i).getNombre().compareTo(nomCategoria)==0){
                intIndex=i;
            }
        }

        return intIndex;
    }

    public static CategoriaBE buscarIdCategoria(int idCategoria){
        CategoriaBE cat = CategoriaDAO.buscarIdCategoria(idCategoria);
        return cat;
    }
}
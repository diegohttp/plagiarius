/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package antiplagium.BE;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author a20057070
 */
public class OracionBE {
        private ArrayList<String> listaPalabras= new ArrayList<String>();
        private HashMap<String,Integer> hashPalabras= new HashMap<String,Integer>();
        public int getNumeroPalabras(){
            return this.hashPalabras.size();
        }
        public boolean contienePalabra(String palabra){
            return this.hashPalabras.containsKey(palabra);
        }
        public String getPalabra(int idx){
            return this.listaPalabras.get(idx);
        }

    public HashMap<String, Integer> getHashPalabras() {
        return hashPalabras;
    }

    public void setHashPalabras(HashMap<String, Integer> hashPalabras) {
        this.hashPalabras = hashPalabras;
    }

    public ArrayList<String> getListaPalabras() {
        return listaPalabras;
    }

    public void setListaPalabras(ArrayList<String> listaPalabras) {
        this.listaPalabras = listaPalabras;
    }

}

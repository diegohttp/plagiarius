/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package secuenciasmaximales;
import java.util.ArrayList;
import java.util.HashMap;
/**
 *
 * @author alulab
 */
public class Documento {
    private int idDoc;
    private ArrayList<NodoPalabra> alstNodoPalabra;
    private HashMap<Integer,Integer> palabraDoc;
    private int nodoAnterior;
    int posActual;
    int contNodos;
    Documento(int idDoc){
        this.idDoc = idDoc;
        this.alstNodoPalabra = new ArrayList<NodoPalabra>();
        this.palabraDoc = new HashMap<Integer,Integer>();
        this.nodoAnterior = -1;
        this.posActual = 0;
        this.contNodos = 0;
    }
    public void insertarNodoPalabra(int idxWord){
        if (palabraDoc.containsKey(idxWord)){
            //System.out.println(idxWord + " ya existia en el doc");
            /* Obtenemos el nodo que corresponde a la palabra en este documento */
            int idxNodo = palabraDoc.get(idxWord);
            alstNodoPalabra.get(idxNodo).insertarReferencia(posActual);
            if (nodoAnterior >= 0){
                int idxReferencia = alstNodoPalabra.get(idxNodo).getUltimaReferncia();
                alstNodoPalabra.get(nodoAnterior).insertarEnlace(idxNodo, idxReferencia);
            }
            /* Cambiamos el puntero al nodoAnterior al nodoActual */
            nodoAnterior = idxNodo;
        }
        else {
            //System.out.println(idxWord + " no existia en el doc");
            /* Si es la primera vez que es insertado en el documento */
            palabraDoc.put(idxWord, contNodos);
            /* aumetamos la cantidad de nodos */
            int idxNodo = contNodos++;
            alstNodoPalabra.add(new NodoPalabra(idxWord));
            alstNodoPalabra.get(idxNodo).insertarReferencia(posActual);
            if (nodoAnterior >= 0){
                int idxReferencia = alstNodoPalabra.get(idxNodo).getUltimaReferncia();
                alstNodoPalabra.get(nodoAnterior).insertarEnlace(idxNodo, idxReferencia);
            }
            nodoAnterior = idxNodo;
        }
        /* aumentamos la cantidad de palabras del documento */
        posActual++;
    }

    public void cerrarEnlaces(){
        alstNodoPalabra.get(nodoAnterior).insertarEnlace( -1, -1);
    }

    public void recorrerDocumento(){
        int nodoActual = 0;
        int referenciaNodo = 0;
        while (nodoActual >= 0){
            System.out.println(alstNodoPalabra.get(nodoActual).getIdPalabra());
            int tmpNodo = alstNodoPalabra.get(nodoActual).getNextNodo(referenciaNodo);
            int tmpRef = alstNodoPalabra.get(nodoActual).getNextReferencia(referenciaNodo);
            nodoActual = tmpNodo;
            referenciaNodo = tmpRef;
        }
    }

    public int getId(){
        return this.idDoc;
    }

    public ArrayList<NodoPalabra> getNodos(){
        return this.alstNodoPalabra;
    }

    public int contienePalabra(int idWord){
    /*
        Devuelve -1 : si el idWord buscado no esta en el documento
     *  Caso contrario :  Devuelve el numero de nodo que tiene la palabra en ese
     *                    documento
    */
        if (palabraDoc.containsKey(idWord))
            return this.palabraDoc.get(idWord);
        else
            return -1;
    }
}

package controller;

import java.util.ArrayList;
import java.util.List;

import model.ArbolBinario;
import model.Nodo;

public class ArbolController {
    ArbolBinario arbol;

    public ArbolController(ArbolBinario arbol) {
        this.arbol = arbol;

    }

    /*
     * public void insertar(int valor) {
     * if (arbol.getRaiz() == null)
     * arbol.setRaiz(new Nodo(valor));
     * Nodo nodoAux = arbol.getRaiz();
     * while (nodoAux != null) {
     * if (valor <= nodoAux.getValor()) {
     * nodoAux = nodoAux.getIzquierdo();
     * } else {
     * nodoAux = nodoAux.getDerecho();
     * 
     * }
     * }
     * if (nodoAux == null)
     * nodoAux.setValor(nodoAux.getValor());
     * }
     * El nodoAux Comienza con el valor de la raiz
     */
    private void insertarRecursivo(int valor, Nodo nodoAux, Nodo nodoPadre) {
        if (valor <= nodoAux.getValor()) {
            nodoPadre = nodoAux;
            nodoAux = nodoAux.getIzquierdo();
            if (nodoAux == null)
                nodoPadre.setIzquierdo(new Nodo(valor));
            else
                insertarRecursivo(valor, nodoAux, nodoPadre);
        } else {
            nodoPadre = nodoAux;
            nodoAux = nodoAux.getDerecho();
            if (nodoAux == null)
                nodoPadre.setDerecho(new Nodo(valor));
            else
                insertarRecursivo(valor, nodoAux, nodoPadre);

        }

    }

    public void insertar(int valor) {

        if (arbol.getRaiz() == null) {
            arbol.setRaiz(new Nodo(valor));
            return;
        } else {
            Nodo nodoAux = arbol.getRaiz();
            Nodo nodoPadre = nodoAux;
            insertarRecursivo(valor, nodoAux, nodoPadre);
        }

    }

    private boolean buscarRecursivo(int valor, Nodo nodoAux, Nodo nodoPadre) {

        if (nodoAux == null)
            return false;
        if (valor < nodoAux.getValor()) {
            nodoPadre = nodoAux;
            nodoAux = nodoAux.getIzquierdo();

            return buscarRecursivo(valor, nodoAux, nodoPadre);
        }
        if (valor > nodoAux.getValor()) {
            nodoPadre = nodoAux;
            nodoAux = nodoAux.getDerecho();

            return buscarRecursivo(valor, nodoAux, nodoPadre);
        }
        if (valor == nodoAux.getValor()) {
            return true;

        }
        return false;

    }

    public boolean buscar(int valor) {
        if (arbol.getRaiz() == null) {
            return false;
        } else {
            Nodo nodoAux = arbol.getRaiz();
            Nodo nodoPadre = nodoAux;
            return buscarRecursivo(valor, nodoAux, nodoPadre);
        }

    }

    public List<Integer> devolverOrdenadoRecursivo(Nodo nodoAux, Nodo nodoPadre, List<Integer> listaDevolver) {// todo

        return null;
    }

    public List<Integer> devolverOrdenado() {// todo
        List<Integer> listaDevolver = new ArrayList<>();
        if (arbol.getRaiz() == null) {
            return null;
        } else {
            Nodo nodoAux = arbol.getRaiz();
            Nodo nodoPadre = nodoAux;
            return devolverOrdenadoRecursivo(nodoAux, nodoPadre, listaDevolver);
        }

    }
}

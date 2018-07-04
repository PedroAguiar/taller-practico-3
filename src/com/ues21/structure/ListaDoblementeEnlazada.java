package com.ues21.structure;

import com.ues21.model.Consultorio;

public class ListaDoblementeEnlazada implements IListaDoblementeEnlazada {

    private NodoDoble inicio,fin;

    public ListaDoblementeEnlazada() {
        this(null, null);
    }

    public ListaDoblementeEnlazada(NodoDoble inicio, NodoDoble fin) {
        this.inicio = inicio;
        this.fin = fin;
    }

    public NodoDoble getInicio() {
        return this.inicio;
    }

    public NodoDoble getFin() {
        return this.fin;
    }

    @Override
    public boolean isEmpty() {
        return this.inicio == null;
    }

    @Override
    public void vaciar() {
        this.inicio = null;
        this.fin = null;
    }

    public void insertarPrimero(Object data) {
        if (isEmpty()) {
            this.inicio = this.fin = new NodoDoble(data);
        } else {
            NodoDoble nuevo = new NodoDoble(null, data, this.inicio);
            nuevo.getNext().setPrev(nuevo);
            this.inicio = nuevo;
        }
    }

    public void insertarUltimo(Object data) {
        if (isEmpty()) {
            this.inicio =  this.fin = new NodoDoble(data);
        } else {
            NodoDoble nuevo = new NodoDoble(this.fin, data, null);
            nuevo.getPrev().setNext(nuevo);
            this.fin = nuevo;
        }
    }



    public void eliminarPrimero() {
        this.inicio = this.inicio.getNext();
        this.inicio.setPrev(null);
    }

    public void eliminarUltimo() {
        this.fin = this.fin.getPrev();
        this.fin.setNext(null);
    }

    public void eliminarMedio(NodoDoble next, NodoDoble prev) {
        prev.setNext(next);
        next.setPrev(prev);
        next.getPrev().setNext(null);
        prev.getNext().setNext(null);
    }

    public void eliminarMedio(NodoDoble nodo) {
        nodo.getPrev().setNext(nodo.getNext());
        nodo.getNext().setPrev(nodo.getPrev());
        nodo.setPrev(null);
        nodo.setNext(null);
    }

    @Override
    public void listarAscendente() {
        if (this.isEmpty()) {
            System.out.println("La lista esta vacia.");
        }
        NodoDoble aux = this.inicio;
        int index = 0;
        while (aux != null) {
            System.out.printf("%d " + aux.getDato().toString() + "\n", index);
            aux = aux.getNext();
            index++;
        }
    }

    @Override
    public void listarDescendiente() {
        if (this.isEmpty()) {
            System.out.println("La lista esta vacia.");
        }
        NodoDoble aux = this.fin;
        while (aux != null) {
            System.out.println(aux.getDato().toString());
            aux = aux.getPrev();
        }
    }

    public void insertarMedio(NodoDoble next, NodoDoble prev, Object dato) {
        if (isEmpty()) {
            System.out.println("La lista esta vacia.");
            return;
        }
        NodoDoble aux = this.inicio;
        while (aux.getNext() != null) {
            if (aux.getNext().getDato().equals(next.getDato()) && aux.getPrev().getDato().equals(prev.getDato())) {
                NodoDoble nuevo = new NodoDoble(prev, dato, next);
                next.setPrev(nuevo);
                prev.setNext(nuevo);
            }
            aux = aux.getNext();
        }
    }
}

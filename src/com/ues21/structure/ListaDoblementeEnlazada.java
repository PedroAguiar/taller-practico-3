package com.ues21.structure;

public class ListaDoblementeEnlazada implements IListaDoblementeEnlazada {

    private NodoDoble inicio;
    private NodoDoble fin;

    public ListaDoblementeEnlazada() {
        inicio = null;
        fin = null;
    }
    public NodoDoble getInicio() {
        return this.inicio;
    }

    public NodoDoble getFin() {
        return this.fin;
    }

    public boolean isEmpty() {
        return this.inicio == null;
    }

    public void vaciar() {
        this.inicio = null;
        this.fin = null;
    }
    
    public void insertar (Object dato) {
        NodoDoble nvo = new NodoDoble (dato);
        this.inicio = nvo;
        this.fin = nvo;
    }

    public void insertarPrimero (Object dato) {
        if (isEmpty())
            this.inicio = this.fin = new NodoDoble (dato);
        else {
            NodoDoble nvo = new NodoDoble (dato);
            nvo.setNext(inicio);
            nvo.setPrev(null);
            nvo.getNext().setPrev(nvo);
            this.inicio = nvo;
        }
    }

    public void insertarUltimo (Object dato) {
        if (isEmpty())
            this.inicio = this.fin = new NodoDoble (dato);
        else {
            NodoDoble nvo = new NodoDoble (dato);
            nvo.setNext(null);
            nvo.setPrev(this.fin);
            nvo.getPrev().setNext(nvo);
            this.fin = nvo;
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
    
    public void eliminarMedio (NodoDoble auxSig, NodoDoble auxAnt) {
        auxAnt.setNext(auxSig);
        auxSig.setPrev(auxAnt);
        auxSig.getPrev().setPrev(null);
        auxAnt.getNext().setNext(null);
    }

    public void eliminarMedio(NodoDoble nodoAEliminar) {
        nodoAEliminar.getPrev().setNext(nodoAEliminar.getNext());
        nodoAEliminar.getNext().setPrev(nodoAEliminar.getPrev());
        nodoAEliminar.setPrev(null);
        nodoAEliminar.setNext(null);
    }
    
    public void listarAscendente() {
        if (this.isEmpty()) {
            System.out.println ("La lista está vacía.");
        }
        NodoDoble aux = this.getInicio();
        int index = 0;
        while (aux != null) {
            System.out.println(index++ + aux.getDato().toString());
            aux = aux.getNext();
        }
    }
    
    public void listarDescendiente() {
        if (this.isEmpty()) {
            System.out.println ("La lista está vacía.");
            return;
        }
        NodoDoble aux = this.getFin();
        while (aux != null) {
            System.out.println(aux.getDato().toString());
            aux = aux.getPrev();
        }
    }

    public void insertarOrdenado(Object dato) {
        if (dato != null) {
            if (this.isEmpty()) {
                this.insertarPrimero(dato);
            } else {
                NodoDoble nodoAux = this.getInicio();
                while (nodoAux != null) {
                    if((((Comparable) dato).compareTo(nodoAux.getDato())) < 0) {
                        if(nodoAux.getPrev() != null) {
                            this.insertarMedio(nodoAux, nodoAux.getPrev(), dato);
                            return;
                        } else {
                            this.insertarPrimero(dato);
                            return;
                        }
                    } else if (((Comparable) dato).compareTo(nodoAux.getDato()) == 0) {
                        if(nodoAux.getPrev() != null) {
                            this.insertarMedio(nodoAux, nodoAux.getPrev(), dato);
                            return;
                        } else {
                            this.insertarPrimero(dato);
                            return;
                        }
                    }
                    nodoAux = nodoAux.getNext();
                }
                this.insertarUltimo(dato);
            }
        }
    }

    public void insertarMedio(NodoDoble next, NodoDoble prev, Object dato) {
        if (isEmpty()) {
            System.out.println("La lista esta vacia.");
            return;
        }
        NodoDoble aux = this.inicio;
        while (aux.getNext() != null) {
            if (((Comparable) aux.getNext().getDato()).compareTo(next.getDato()) < 0 &&
                ((Comparable) aux.getPrev().getDato()).compareTo(prev.getDato()) > 0) {
                NodoDoble nuevo = new NodoDoble(prev, dato, next);
                next.setPrev(nuevo);
                prev.setNext(nuevo);
            }
            aux = aux.getNext();
        }
    }
}

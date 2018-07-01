package com.ues21.structure;

import com.ues21.structure.exception.ElementNotFoundException;

public class ListaSimplementeEnlazada implements IListaSimplementeEnlazada {

    private NodoSimple first;

    @Override
    public void add(Object data) {
        NodoSimple nodo = new NodoSimple(data,null);
        if(first == null) {
            first = nodo;
        } else {
            NodoSimple aux = first;
            while (aux.getNext() != null) {
                aux = aux.getNext();
            }
            aux.setNext(nodo);
        }
    }

    @Override
    public Object get(int index) throws ElementNotFoundException {
        int currentIntex = 0;
        NodoSimple aux = first;
        while (aux != null) {
            if (currentIntex == index) {
                return aux.getDato();
            }
            aux = aux.getNext();
            currentIntex++;
        }
        throw new ElementNotFoundException("No se ha encotnrado ningun elemento con indice: " + index);
    }

    @Override
    public void remove(Object data) {
        if (this.first.getDato().equals(data)) {
            this.first = this.first.getNext();
        } else {
            NodoSimple previo = first;
            NodoSimple aux = first;

            while (aux.getNext() != null) {
                if (aux.getDato().equals(data)) {
                    previo.setNext(aux.getNext());
                }
                previo = aux;
                aux = aux.getNext();
            }
        }

    }

    @Override
    public int size() {
        if (first == null) {
            return 0;
        } else {
            NodoSimple aux = first;
            int size = 1;
            while (aux.getNext() != null) {
                size++;
            }
            return size;
        }
    }
}

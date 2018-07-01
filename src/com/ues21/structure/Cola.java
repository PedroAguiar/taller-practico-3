package com.ues21.structure;

import com.ues21.structure.exception.DesbordamientoInferior;

public class Cola {

    private NodoSimple first;
    private NodoSimple last;

    public Cola() {
        this.first = null;
        this.last = null;
    }

    public Cola(NodoSimple first, NodoSimple last) {
        this.first = first;
        this.last = last;
    }

    public void put(Object x) {
        NodoSimple nuevo = new NodoSimple(x);
        if (isEmpty()) {
            first = nuevo;
        } else {
            last.setNext(nuevo);
            last.getNext().setNext(null);
        }
    }

    public boolean isEmpty() {
        return first == null && last == null;
    }

    public void clear() {
        first = null;
        last = null;
    }

    public Object getFirst() throws DesbordamientoInferior {
        if (isEmpty()) {
            throw new DesbordamientoInferior("La cola está vacía.");
        }
        return first.getDato();
    }

    public void removeFirst() throws DesbordamientoInferior {
        if (isEmpty()) {
            throw new DesbordamientoInferior("La cola está vacía.");
        }
        first.setNext(first.getNext());
    }
}

package com.ues21.structure;

import com.ues21.structure.exception.DesbordamientoInferior;

public class Cola implements ICola {

    private NodoSimple first;

    public Cola() {
        this.first = null;
    }

    public Cola(NodoSimple first, NodoSimple last) {
        this.first = first;
    }

    public void put(Object x) {
        NodoSimple nuevo = new NodoSimple(x);
        if (isEmpty()) {
            first = nuevo;
        } else if (!first.hasNext()) {
            first.setNext(nuevo);
        } else if (first.hasNext()) {
            NodoSimple aux = first.getNext();
            while (aux.hasNext()) {
                aux = aux.getNext();
            }
            aux.setNext(nuevo);
        }
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void clear() {
        first = null;
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
    
    public void listar() {
        if (isEmpty()) {
            System.out.println("La cola esta vacia");
            return;
        }
        NodoSimple aux = this.first;
        while(aux != null) {
            System.out.println(aux.getDato() + ", ");
            aux = aux.getNext();
        }
    }
}

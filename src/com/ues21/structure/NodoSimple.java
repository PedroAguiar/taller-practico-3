package com.ues21.structure;

public class NodoSimple {

    private Object dato;
    private NodoSimple next;

    public NodoSimple() {
        this.dato = null;
        this.next = null;
    }

    public NodoSimple(Object dato) {
        this.dato = dato;
    }
    public NodoSimple(Object dato, NodoSimple nodo) {
        this.dato = dato;
        this.next = nodo;
    }

    public Object getDato() {
        return this.dato;
    }

    public void setDato(Object dato) {
        this.dato = dato;
    }

    public NodoSimple getNext() {
        return this.next;
    }

    public void setNext(NodoSimple node) {
        this.next = node;
    }
}

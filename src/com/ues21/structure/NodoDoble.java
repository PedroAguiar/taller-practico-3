package com.ues21.structure;

public class NodoDoble {

    private Object dato;
    private NodoDoble next;
    private NodoDoble prev;

    public NodoDoble() {
        this.dato = null;
        this.next = null;
    }

    public NodoDoble(Object dato) {
        this.dato = dato;
    }
    public NodoDoble(NodoDoble prev, Object dato, NodoDoble nodo) {
        this.dato = dato;
        this.next = nodo;
        this.prev = prev;
    }

    public Object getDato() {
        return this.dato;
    }

    public void setDato(Object dato) {
        this.dato = dato;
    }

    public NodoDoble getNext() {
        return this.next;
    }

    public void setNext(NodoDoble node) {
        this.next = node;
    }

    public void setPrev(NodoDoble node) {
        this.prev = node;
    }

    public NodoDoble getPrev() {
        return this.prev;
    }
}

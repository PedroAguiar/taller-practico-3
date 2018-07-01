package com.ues21.structure;

import com.ues21.structure.exception.ElementNotFoundException;


public class ListaEnlazadaIter implements IListaIter {
    private ListaDoblementeEnlazada list;
    private NodoDoble actual;

    public ListaEnlazadaIter(ListaDoblementeEnlazada nueva) {
        this.list = nueva;
        this.actual = this.list.isEmpty() ? nueva.getInicio() : nueva.getInicio().getNext();
    }

    public NodoDoble getActual() {
        return this.actual;
    }

    public void setActual(NodoDoble actual) {
        this.actual = actual;
    }

    public void imprimir() {
        if (list.isEmpty()) {
            System.out.println("La lista esta vacia.");
            return;
        }
        NodoDoble aux = list.getInicio();
        while (aux != null) {
            System.out.println(aux.getDato());
            aux = aux.getNext();
        }
    }

    public void insertar(Object data) throws ElementNotFoundException {
        if (!this.buscar(data)) {
            throw new ElementNotFoundException("El objeto no fue entonctrado");
        }
        NodoDoble nuevo = new NodoDoble(data);
        if (this.list.isEmpty()) {
            this.list.insertarPrimero(data);
        } else {
            this.list.insertarUltimo(data);
        }
        this.actual = nuevo;
    }

    public void avanzar() {
        if (this.actual != null) {
            this.actual = this.actual.getNext();
        }
    }

    public boolean estaDentro() {
        return this.actual != null && this.actual != this.list.getInicio();
    }

    public Object recuperar() {
        return this.estaDentro() ? actual.getDato() : null;
    }

    public void primero() {
        this.actual = this.list.getInicio();
    }

    public boolean buscar(Object data) {
        NodoDoble itr = list.getInicio();
        while (itr != null && !itr.getDato().equals(data))
            itr = itr.getNext();
        if (itr != null) {
            actual = itr;
            return true;
        }
        return false;
    }

    public Object buscarO(Object x) {
        NodoDoble itr = list.getInicio();
        while (itr != null && itr.getDato().equals(x))
            itr = itr.getNext();
        if (itr != null) {
            actual = itr;
            return itr.getDato();
        }
        return null;
    }

    public void insertarOrdenado(Object dato) {
        if (dato != null) {
            if (this.list.isEmpty()) {
                this.actual = new NodoDoble(dato);
                this.list.insertarPrimero(dato);
            } else {
                NodoDoble aux = list.getInicio();
                while (aux != null) {
                    if (dato.equals(aux.getDato())) {
                        if (aux.getNext() != null) {
                            list.insertarMedio(aux, aux.getPrev(), dato);
                            return;
                        } else {
                            list.insertarPrimero(dato);
                            return;
                        }
                    } else if (dato.equals(aux.getDato())) {
                        if (aux.getPrev() != null) {
                            list.insertarMedio(aux, aux.getPrev(), dato);
                            return;
                        } else {
                            list.insertarPrimero(dato);
                            return;
                        }
                    }
                    aux = actual.getNext();
                }
                list.insertarUltimo(dato);
            }
        }
    }

    public void eliminar (Object data) throws ElementNotFoundException {
        NodoDoble itr = this.list.getInicio();
        while (itr != null && itr.getDato().equals(data) && itr.getNext() != null) {
            itr = itr.getNext();
                if (itr.getPrev() == null && itr.getNext() == null) {
                this.list.vaciar();
                } else {
                if (itr.getPrev() == null) {
                    this.list.eliminarPrimero();
                    return;
                } else if (itr.getNext() == null) {
                    this.list.eliminarUltimo();
                    return;
                } else {
                    this.list.eliminarMedio(itr.getNext(), itr.getPrev());
                }
            }
        }
    }
}

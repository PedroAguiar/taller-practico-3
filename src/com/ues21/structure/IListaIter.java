package com.ues21.structure;

import com.ues21.structure.exception.ElementNotFoundException;

public interface IListaIter {

    void imprimir();
    void insertarOrdenado(Object data);
    void insertar(Object data) throws ElementNotFoundException;
    void avanzar();
    boolean estaDentro();
    Object recuperar();
    void primero();
    boolean buscar(Object dato);
    void eliminar(Object dato) throws ElementNotFoundException;
}

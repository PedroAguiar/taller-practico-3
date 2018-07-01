package com.ues21.structure;

import com.ues21.structure.exception.ElementNotFoundException;

public interface IListaSimplementeEnlazada {

    void add(Object data);
    Object get(int index) throws ElementNotFoundException;
    void remove(Object data);
    int size();

}

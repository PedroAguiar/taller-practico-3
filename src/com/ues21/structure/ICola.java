package com.ues21.structure;

import com.ues21.structure.exception.DesbordamientoInferior;

public interface ICola {

    void put(Object x);
    boolean isEmpty();
    void clear();
    Object getFirst() throws DesbordamientoInferior;
    void removeFirst() throws DesbordamientoInferior;
}

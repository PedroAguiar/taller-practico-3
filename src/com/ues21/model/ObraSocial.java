package com.ues21.model;

import com.ues21.model.exception.ObraSocialTypeNotFound;

public enum ObraSocial {
    
    PARTICULAR(0),
    OSDE(1),
    SWISS_MEDICAL(2),
    MET(3),
    OTRA(4);
    
    public final int obraSocialId;
    
    ObraSocial(int obraSocialId) {
        this.obraSocialId = obraSocialId;
    }
    
    public static ObraSocial findObraSocialType(int obraSocialId) throws ObraSocialTypeNotFound {
        for (ObraSocial obraSocial : ObraSocial.values()) {
            if (obraSocial.obraSocialId == obraSocialId) {
                return obraSocial;
            }
        }
        throw new ObraSocialTypeNotFound(String.format("No existe ninguna obra social con id: %d", obraSocialId));
    }
}

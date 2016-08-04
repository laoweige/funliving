package com.funliving.info.resource.repr;

import java.util.Date;
import com.funliving.info.repository.entity.Facility;

public class FacilityJson {

    public FacilityJson(Facility entity){

        this.id=entity.getId();
        this.apartmentId=entity.getApartmentId();
        this.facility=entity.getFacility();
    }

    /**
     *
     */
    private int id;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     */
    private int apartmentId;
    public int getApartmentId() {
        return apartmentId;
    }
    public void setApartmentId(int apartmentId) {
        this.apartmentId = apartmentId;
    }

    /**
     *
     */
    private int facility;
    public int getFacility() {
        return facility;
    }
    public void setFacility(int facility) {
        this.facility = facility;
    }

}

package com.funliving.info.resource.repr;

import java.util.Date;

import com.funliving.info.common.FacilityMap;
import com.funliving.info.repository.entity.Facility;

public class FacilityJson {

    public FacilityJson(){

    }
    public FacilityJson(int facility,String name){
        this.facility = facility;
        this.name = name;
        this.logo = facility+".png";

    }

    private String name;
    private String logo;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    @Override
    public String toString() {
        return "FacilityJson{" +
                "name='" + name + '\'' +
                ", logo='" + logo + '\'' +
                ", facility=" + facility +
                '}';
    }

    public FacilityJson(Facility entity){
        this.facility=entity.getFacility();
        FacilityJson facilityJson = FacilityMap.instance().getFacilities().get(this.facility);
        if(facilityJson!=null) {
            this.name = facilityJson.getName();
            this.logo = facilityJson.getLogo();
        }
    }

    private int facility;
    public int getFacility() {
        return facility;
    }
    public void setFacility(int facility) {
        this.facility = facility;
    }
}

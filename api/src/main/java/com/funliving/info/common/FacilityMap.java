package com.funliving.info.common;

import com.funliving.info.repository.entity.Facility;
import com.funliving.info.resource.repr.FacilityJson;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

public class FacilityMap {
    private static FacilityMap facilityMap;
    public static FacilityMap instance(){
        if(facilityMap!=null)
            return facilityMap;
        try {
            Gson gson = new Gson();
            String path = gson.getClass().getResource("/").getPath() + "facility.json";
            if (path.contains("build")) {
                path = path.replace("classes", "resources");
            }
            System.out.println(path);
            String content = FileHelper.read(path);
            String className = FacilityMap.class.getName();
            Class<?> type = Class.forName(className);
            facilityMap = (FacilityMap) gson.fromJson(content, type);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return facilityMap;
    }


    private Map<Integer, FacilityJson> facilities = new HashMap<>();
    private int size;

    public Map<Integer, FacilityJson> getFacilities() {
        return facilities;
    }

    public void setFacilities(Map<Integer, FacilityJson> facilities) {
        this.facilities = facilities;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "FacilityMap{" +
                "facilities=" + facilities +
                ", size=" + size +
                '}';
    }
}

package com.funliving.info.resource.repr;

import com.funliving.info.repository.entity.Picture;

public class PictureJson {

    public PictureJson(Picture entity){

        this.id=entity.getId();
        this.name=entity.getName();
        this.path=entity.getPath();

    }

    private int id;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    private String path;
    public String getPath() {
        return path;
    }
    public void setPath(String path) {
        this.path = path;
    }

}

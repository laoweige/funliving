package com.funliving.info.resource.repr;

/**
 * Created by Administrator on 2016/8/9.
 */
public class HotJson {
    public HotJson(){}

    public HotJson(Object id,Object name,int type){
        this.id = id.toString();
        this.name = name.toString();
        this.type = type;
    }

    private String id;
    private String name;
    private int type;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}

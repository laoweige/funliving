package com.funliving.info.resource.repr;

import com.funliving.info.repository.entity.Distance;

/**
 * Created by Administrator on 2016/8/25.
 */
public class DistanceJson {
    public DistanceJson(){};
    public DistanceJson(Distance distance){
        this.walk = distance.getWalk();
        this.drive = distance.getDrive();
        this.metro = distance.getMetro();
    }
    private int walk;
    private int metro;
    private int drive;

    public int getWalk() {
        return walk;
    }

    public void setWalk(int walk) {
        this.walk = walk;
    }

    public int getMetro() {
        return metro;
    }

    public void setMetro(int metro) {
        this.metro = metro;
    }

    public int getDrive() {
        return drive;
    }

    public void setDrive(int drive) {
        this.drive = drive;
    }
}

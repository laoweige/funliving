package com.funliving.info.resource.repr;

import com.funliving.info.repository.entity.Introduce;

public class IntroduceJson {

    public IntroduceJson(Introduce entity){

        this.id=entity.getId();
        this.title=entity.getTitle();
        this.content=entity.getContent();

    }

    private int id;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    private String title;
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    private String content;
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
}

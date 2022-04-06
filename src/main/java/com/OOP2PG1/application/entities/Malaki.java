package com.OOP2PG1.application.entities;

public class Malaki {
    private String id;
    private String name;
    private String creator;

    public Malaki(String id, String name, String creator) {
        this.id = id;
        this.name = name;
        this.creator = creator;
    }

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

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }
}

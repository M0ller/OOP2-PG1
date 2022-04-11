package com.OOP2PG1.application.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "sites")
public class Site {
    @Id
    private String id;

    private String site_name;
    private String creator;
    private String creator_name;

    // default constructor - not that I can figure out why it needs one and why it wants to call a non existant super class...
    public Site()
    {
        super();
    }

    public Site(String id, String site_name, String creator, String creator_name) {
        this.id = id;
        this.site_name = site_name;
        this.creator = creator;
        this.creator_name = creator_name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSite_name() {
        return site_name;
    }

    public void setSite_name(String site_name) {
        this.site_name = site_name;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getCreator_name() {
        return creator_name;
    }

    public void setCreator_name(String creator_name) {
        this.creator_name = creator_name;
    }
}

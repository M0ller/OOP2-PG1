package com.OOP2PG1.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "roles")
public class SiteRoles {
        @Id
        private String id;

        private ERole name;

        private String urlHeader;

    public SiteRoles(ERole name, String urlHeader) {
        this.name = name;
        this.urlHeader = urlHeader;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ERole getName() {
        return name;
    }

    public void setName(ERole name) {
        this.name = name;
    }

    public String getUrlHeader() {
        return urlHeader;
    }

    public void setUrlHeader(String urlHeader) {
        this.urlHeader = urlHeader;
    }

    @Override
    public String toString() {
        return "siteRoles{" +
                "id='" + id + '\'' +
                ", name=" + name +
                ", urlHeader='" + urlHeader + '\'' +
                '}';
    }
}

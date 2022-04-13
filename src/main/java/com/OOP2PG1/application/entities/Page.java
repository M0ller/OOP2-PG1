package com.OOP2PG1.application.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Document(collection = "pages")
public class Page {

    @Id
    private String id;

    @NotBlank
    @Size(max = 30)
    private String titlePage;

    private String urlTitlePage;

    private String urlSite;

    private String siteId;

    private String adminId;

    public Page() {}

    public Page(String titlePage, String urlTitlePage, String urlSite, String siteId, String adminId) {
        this.titlePage = titlePage;
        this.urlTitlePage = urlTitlePage;
        this.urlSite = urlSite;
        this.siteId = siteId;
        this.adminId = adminId;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getTitlePage() {
        return titlePage;
    }
    public void setTitlePage(String titlePage) {
        this.titlePage = titlePage;
    }
    public String getUrlTitlePage() {
        return urlTitlePage;
    }
    public void setUrlTitlePage(String urlTitlePage) {
        this.urlTitlePage = urlTitlePage;
    }

    public String getSiteId() {
        return siteId;
    }
    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    public String getUrlSite() {
        return urlSite;
    }
    public void setUrlSite(String urlSite) {
        this.urlSite = urlSite;
    }

    public String getAdminId() {
        return adminId;
    }
    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

}

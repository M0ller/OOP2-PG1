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
    private String parentSiteTitle;
    private String siteId;
    private String adminId;

    private String description;
    private String log;
    private String wallpaper;
    private String colorTheme;
    private String font;


    public Page() {}

    public Page(String titlePage, String urlTitlePage, String parentSiteTitle, String siteId, String adminId, String description, String log, String wallpaper, String colorTheme, String font) {
        this.titlePage = titlePage;
        this.urlTitlePage = urlTitlePage;
        this.parentSiteTitle = parentSiteTitle;
        this.siteId = siteId;
        this.adminId = adminId;

        this.description = description;
        this.log = log;
        this.wallpaper = wallpaper;
        this.colorTheme = colorTheme;
        this.font = font;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLog() {
        return log;
    }

    public void setLog(String log) {
        this.log = log;
    }

    public String getWallpaper() {
        return wallpaper;
    }

    public void setWallpaper(String wallpaper) {
        this.wallpaper = wallpaper;
    }

    public String getColorTheme() {
        return colorTheme;
    }

    public void setColorTheme(String colorTheme) {
        this.colorTheme = colorTheme;
    }

    public String getFont() {
        return font;
    }

    public void setFont(String font) {
        this.font = font;
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

    public String getParentSiteTitle() {
        return parentSiteTitle;
    }
    public void setParentSiteTitle(String parentSiteTitle) {
        this.parentSiteTitle = parentSiteTitle;
    }

    public String getAdminId() {
        return adminId;
    }
    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    @Override
    public String toString() {
        return "Page{" +
                "\nid='" + id + '\'' +
                ", \ntitlePage='" + titlePage + '\'' +
                ", \nurlTitlePage='" + urlTitlePage + '\'' +
                ", \nurlSite='" + parentSiteTitle + '\'' +
                ", \nsiteId='" + siteId + '\'' +
                ", \nadminId='" + adminId + '\'' +
                ", \ndescription='" + description + '\'' +
                ", \nlog='" + log + '\'' +
                ", \nwallpaper='" + wallpaper + '\'' +
                ", \ncolorTheme='" + colorTheme + '\'' +
                ", \nfont='" + font + '\'' +
                "\n}";
    }
}

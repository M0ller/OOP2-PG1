package com.OOP2PG1.application.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Document(collection = "site")
public class Site {

    @Id
    private String id;

    @NotBlank
    @Size(max = 30)
    private String title;

    private String urlHeader;

    private String description;

    private String log;

    private String wallpaper;

    private String colorTheme;

    private String font;

    private String adminId;

    public Site() {}

    public Site(String title, String urlHeader, String description, String log, String wallpaper, String colorTheme, String font, String adminId) {
        this.title = title;
        this.urlHeader = urlHeader;
        this.description = description;
        this.log = log;
        this.wallpaper = wallpaper;
        this.colorTheme = colorTheme;
        this.font = font;
        this.adminId = adminId;
    }
    public String getUrlHeader() {
        return urlHeader;
    }

    public void setUrlHeader(String urlHeader) {
        this.urlHeader = urlHeader;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    @Override
    public String toString() {
        return "Site{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", titleCheck='" + urlHeader + '\'' +
                ", description='" + description + '\'' +
                ", log='" + log + '\'' +
                ", wallpaper='" + wallpaper + '\'' +
                ", colorTheme='" + colorTheme + '\'' +
                ", font='" + font + '\'' +
                ", adminId='" + adminId + '\'' +
                '}';
    }
}

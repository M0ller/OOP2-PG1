package com.OOP2PG1.models;

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

    private String description;

    private String log;

    private String icon;

    private String wallpaper;

    private String colorTheme;

    private String font;

    public Site() {}

    public Site(String title, String description, String log, String icon, String wallpaper, String colorTheme, String font) {
        this.title = title;
        this.description = description;
        this.log = log;
        this.icon = icon;
        this.wallpaper = wallpaper;
        this.colorTheme = colorTheme;
        this.font = font;
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

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
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
}

package com.OOP2PG1.security.services;

import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class SiteDetailsImpl {

    private String id;

    private String title;

    private String description;

    private String log;

    private String icon;

    private String wallpaper;

    private String colorTheme;

    private String font;

    public SiteDetailsImpl(String id, String title, String description, String log, String icon, String wallpaper, String colorTheme, String font) {
        this.id = id;
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

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getLog() {
        return log;
    }

    public String getIcon() {
        return icon;
    }

    public String getWallpaper() {
        return wallpaper;
    }

    public String getColorTheme() {
        return colorTheme;
    }

    public String getFont() {
        return font;
    }
}

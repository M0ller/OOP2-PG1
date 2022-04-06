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

}

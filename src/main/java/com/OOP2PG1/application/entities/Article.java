package com.OOP2PG1.application.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

@Document(collection = "articles")
public class Article {

    @Id
    private String id;

    @NotBlank
    @Size(max = 30)
    private String articleTitle;
    private String urlArticleTitle;
    private String parentSiteTitle;
    private String parentPageTitle;
    private String creator;
    private String startdate;
    private String enddate;

    private String headerTitle;
    private String textarea;
    private String wallpaper;

    public Article() {}

    public Article(String id, String articleTitle, String urlArticleTitle, String parentSiteTitle, String parentPageTitle, String creator, String startdate, String enddate, String headerTitle, String textarea, String wallpaper) {
        this.id = id;
        this.articleTitle = articleTitle;
        this.urlArticleTitle = urlArticleTitle;
        this.parentSiteTitle = parentSiteTitle;
        this.parentPageTitle = parentPageTitle;
        this.creator = creator;
        this.startdate = startdate;
        this.enddate = enddate;
        this.headerTitle = headerTitle;
        this.textarea = textarea;
        this.wallpaper = wallpaper;
    }


    public String getParentSiteTitle() {
        return parentSiteTitle;
    }

    public String getHeaderTitle() {
        return headerTitle;
    }

    public void setHeaderTitle(String headerTitle) {
        this.headerTitle = headerTitle;
    }

    public String getWallpaper() {
        return wallpaper;
    }

    public void setWallpaper(String wallpaper) {
        this.wallpaper = wallpaper;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getUrlArticleTitle() {
        return urlArticleTitle;
    }

    public void setUrlArticleTitle(String urlArticleTitle) {
        this.urlArticleTitle = urlArticleTitle;
    }

    public String getParentSiteTitleId() {
        return parentSiteTitle;
    }

    public void setParentSiteTitle(String parentSiteTitle) {
        this.parentSiteTitle = parentSiteTitle;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public String getParentPageTitle() {
        return parentPageTitle;
    }

    public void setParentPageTitle(String parentPageTitle) {
        this.parentPageTitle = parentPageTitle;
    }

    public String getTextarea() {
        return textarea;
    }

    public void setTextarea(String textarea) {
        this.textarea = textarea;
    }

    public String getStartdate() {
        return startdate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    public String getEnddate() {
        return enddate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }

    @Override
    public String toString() {
        return "Article{" +
                "\nid='" + id + '\'' +
                ", \narticleTitle='" + articleTitle + '\'' +
                ", \nurlArticleTitle='" + urlArticleTitle + '\'' +
                ", \nparentSiteTitle='" + parentSiteTitle + '\'' +
                ", \nparentPageTitle='" + parentPageTitle + '\'' +
                ", \ncreator='" + creator + '\'' +
                ", \nstartdate='" + startdate + '\'' +
                ", \nenddate='" + enddate + '\'' +
                ", \nheaderTitle='" + headerTitle + '\'' +
                ", \ntextarea='" + textarea + '\'' +
                ", \nwallpaper='" + wallpaper + '\'' +
                "\n}";
    }
}

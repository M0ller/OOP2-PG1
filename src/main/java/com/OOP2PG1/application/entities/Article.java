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

    private String parentSiteId;

    private String parentPageId;

    private String textarea;

    private String creator;

    private Date startdate;

    private Date enddate;

    public Article() {}

    public Article(String articleTitle, String urlArticleTitle, String parentSiteId, String parentPageId, String textarea, String creator, Date startdate, Date enddate) {
        this.articleTitle = articleTitle;
        this.urlArticleTitle = urlArticleTitle;
        this.parentSiteId = parentSiteId;
        this.parentPageId = parentPageId;
        this.textarea = textarea;
        this.creator = creator;
        this.startdate = startdate;
        this.enddate = enddate;
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

    public String getParentSiteId() {
        return parentSiteId;
    }

    public void setParentSiteId(String parentSiteId) {
        this.parentSiteId = parentSiteId;
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

    public String getParentPageId() {
        return parentPageId;
    }

    public void setParentPageId(String parentPageId) {
        this.parentPageId = parentPageId;
    }

    public String getTextarea() {
        return textarea;
    }

    public void setTextarea(String textarea) {
        this.textarea = textarea;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    @Override
    public String toString() {
        return "Article{" +
                "\nid='" + id + '\'' +
                ", \narticleTitle='" + articleTitle + '\'' +
                ", \nurlArticleTitle='" + urlArticleTitle + '\'' +
                ", \nparentSiteId='" + parentSiteId + '\'' +
                ", \nparentPageId='" + parentPageId + '\'' +
                ", \ntextarea='" + textarea + '\'' +
                ", \ncreator='" + creator + '\'' +
                ", \nstartdate=" + startdate +
                ", \nenddate=" + enddate +
                "\n}";
    }
}

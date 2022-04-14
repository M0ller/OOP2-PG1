package com.OOP2PG1.payload.request;

import javax.validation.constraints.NotBlank;

public class SiteRoleRequest {

    @NotBlank
    private String username;

    @NotBlank
    private String urlHeader;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUrlHeader() {
        return urlHeader;
    }

    public void setUrlHeader(String urlHeader) {
        this.urlHeader = urlHeader;
    }

}

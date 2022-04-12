package com.OOP2PG1.application.services;

import com.OOP2PG1.application.entities.Site;
import com.OOP2PG1.application.repositories.SiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SiteService {

    SiteRepository siteRepository;

    Site site;

    public SiteService() {}

    @Autowired
    public SiteService(SiteRepository siteRepository) {
        this.siteRepository = siteRepository;
    }

//    getOneSite(){}
//
//    List<Site> getAllSites() {return siteRepository.findAll(); }


}

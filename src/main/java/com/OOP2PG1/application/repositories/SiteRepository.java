package com.OOP2PG1.application.repositories;

import com.OOP2PG1.application.entities.Site;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;


import java.util.List;
import java.util.Optional;

public interface SiteRepository extends MongoRepository<Site, String> {
//    Site findAll(String id);

//     List<Site> getAllSites(String site_name);
//   @Query("{Site:'?0'}")
//   Site findBySiteName(String site_name);
//    public List<Site> findByAllSiteId(String id);
}

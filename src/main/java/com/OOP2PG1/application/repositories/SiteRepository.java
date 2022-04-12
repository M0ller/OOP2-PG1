package com.OOP2PG1.application.repositories;

import com.OOP2PG1.application.controllers.SiteController;
import com.OOP2PG1.application.entities.Site;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;


import java.util.List;
import java.util.Optional;

public interface SiteRepository extends MongoRepository<Site, String> {

    Optional<Site> findByTitle(String title);

    Boolean existsByTitle(String title);
}

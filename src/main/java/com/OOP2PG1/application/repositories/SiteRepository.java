package com.OOP2PG1.application.repositories;

import com.OOP2PG1.application.controllers.SiteController;
import com.OOP2PG1.application.entities.Site;
import org.springframework.data.domain.Example;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.FluentQuery;


import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public interface SiteRepository extends MongoRepository<Site, String> {

    Optional<Site> findByTitle(String title);

//   Site findByadminId(String adminId);

    Optional<Site> findByurlHeader(String urlHeader);

    Boolean existsByurlHeader(String urlHeader);

    Boolean existsByTitle(String title);
}

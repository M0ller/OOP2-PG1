package com.OOP2PG1.repository;

import com.OOP2PG1.models.Site;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface SiteRepository extends MongoRepository<Site, String> {

    Optional<Site> findByTitle(String title);

    Boolean existsByTitle(String title);
}

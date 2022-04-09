package com.OOP2PG1.application.repositories;

import com.OOP2PG1.application.entities.Site;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SiteRepository extends MongoRepository<Site, String> {

}

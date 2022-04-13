package com.OOP2PG1.application.repositories;

import com.OOP2PG1.application.entities.Site;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface SiteRepository extends MongoRepository<Site, String> {

    Optional<Site> findById(String id);

    String findAllByurlHeader(String urlHeader);

    Site findByurlHeader(String urlHeader);

    List<Site> findByAdminId(String AdminId);

    Boolean existsByurlHeader(String urlHeader);

    Optional<Site> deleteByurlHeader(String siteName);

}
//   Site findByadminId(String adminId);
//    Optional<Site> findBy<?>(String <?>);
//    Optional<Site> findBy<?>Or<?>(String <?>);
//    Optional<Site> findBy<urlHeader>Or<AdminId>(String <?>);
//    Optional<Site> find<?>By<?>(String <?>);
//    Optional<Site> find<?>By<?><?>(String <?>);

//    List<Site> findBy<AdminId>(String <?>);
package com.OOP2PG1.application.repositories;

import com.OOP2PG1.application.entities.Site;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface ArticleRepository extends MongoRepository<Site, String> {

    Optional<Site> findByTitle(String title);

//   Site findByadminId(String adminId);

    Optional<Site> findByurlHeader(String urlHeader);
//    Optional<Site> findBy<?>(String <?>);
//    Optional<Site> findBy<?>Or<?>(String <?>);
//    Optional<Site> findBy<urlHeader>Or<AdminId>(String <?>);
//    Optional<Site> find<?>By<?>(String <?>);
//    Optional<Site> find<?>By<?><?>(String <?>);

//    List<Site> findBy<AdminId>(String <?>);

    List<Site> findByAdminId(String AdminId);

    Boolean existsByurlHeader(String urlHeader);

    Boolean existsByTitle(String title);

}

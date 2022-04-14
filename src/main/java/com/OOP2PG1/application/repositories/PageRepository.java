package com.OOP2PG1.application.repositories;

import com.OOP2PG1.application.entities.Page;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface PageRepository extends MongoRepository<Page, String> {

    Page findByUrlTitlePage(String urlTitlePage);
    Boolean existsByUrlTitlePage(String titlePage);

    List<Page> findByAdminId(String urlHeader);

    Optional<Page> deleteByurlTitlePage(String pageTitle);

    // Boolean existsByurlHeader(String urlHeader);
    // Site findByurlHeader(String urlHeader);
}

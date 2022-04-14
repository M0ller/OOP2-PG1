package com.OOP2PG1.application.repositories;

import com.OOP2PG1.application.entities.Article;
import com.OOP2PG1.application.entities.Site;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface ArticleRepository extends MongoRepository<Article, String> {

    Article findByurlArticleTitle(String urlArticleTitle);

    Boolean existsByurlArticleTitle(String urlArticleTitle);

    Optional<Article> deleteByurlArticleTitle(String urlArticleTitle);

}

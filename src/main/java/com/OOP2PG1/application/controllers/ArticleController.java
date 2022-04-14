package com.OOP2PG1.application.controllers;

import com.OOP2PG1.application.entities.Article;
import com.OOP2PG1.application.entities.Page;
import com.OOP2PG1.application.entities.Site;
import com.OOP2PG1.application.repositories.ArticleRepository;
import com.OOP2PG1.application.repositories.SiteRepository;
import com.OOP2PG1.payload.response.MessageResponse;
import com.OOP2PG1.security.services.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    ArticleRepository articleRepository;

    MessageResponse messageResponse;

    UserDetailsImpl currentUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        return userDetails;
    }

    @GetMapping()
    //@PreAuthorize("permitAll()")
    public List<Article> getAllSites() {
        return articleRepository.findAll();
    }

    @PutMapping("/edit")
    @PreAuthorize("permitAll()") //("hasRole('ADMIN')")
    public ResponseEntity<?> editArticle(@RequestBody Article article) {

        if(!articleRepository.existsByurlArticleTitle(article.getArticleTitle().toLowerCase() )){ // add adminId check
            return ResponseEntity.badRequest().body(article.getArticleTitle() + " Dosen't Exist " );
        }
        if(articleRepository.existsByurlArticleTitle(article.getArticleTitle().toLowerCase())){
            Article temp = new Article();
            temp.setArticleTitle(article.getArticleTitle());
            temp.setUrlArticleTitle(article.getArticleTitle().toLowerCase() );
            temp.setParentPageTitle(article.getParentPageTitle());
            temp.setParentSiteTitle(article.getParentSiteTitle());
            temp.setCreator(article.getCreator()); // can change to add current().user

            temp.setHeaderTitle(article.getHeaderTitle());
            temp.setStartdate(article.getStartdate()); // Add check for publish dates
            temp.setEnddate(article.getEnddate());    // Add check for publish dates
            temp.setTextarea(article.getTextarea());
            temp.setWallpaper(article.getWallpaper());

            temp.setId( articleRepository.findByurlArticleTitle( article.getArticleTitle().toLowerCase() ).getId() );

            articleRepository.save(temp);
            return ResponseEntity.ok(new MessageResponse("You Updated your Article "+ article.getArticleTitle() + "!" ));
        }
        return ResponseEntity.badRequest().body("Error Something went wrong. Sorry!");
    }

    @PostMapping("/create")
    @PreAuthorize("permitAll()") // @PreAuthorize("hasRole('user')")
    public ResponseEntity<?> create(@RequestBody Article article){ //SiteRequest siteRequest

        if(articleRepository.existsByurlArticleTitle(article.getArticleTitle().toLowerCase())){
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Article Already Exist!"));
        }
        article.getArticleTitle();
        article.setUrlArticleTitle(article.getArticleTitle().toLowerCase());
        article.getTextarea();
        article.getStartdate();
        article.getEnddate();
        article.getParentPageTitle(); //page.setAdminId(currentUser().getUsername());
        article.getParentSiteTitleId();
        article.setCreator(currentUser().getUsername());

        articleRepository.save(article);
        return ResponseEntity.ok(new MessageResponse("Article Created successfully! You Created "+ article.getArticleTitle()
        ));
    }

    @GetMapping("/{body}")
    @PreAuthorize("permitAll()")
    public ResponseEntity<?> getArticleTitle(@PathVariable String body){
        if(!articleRepository.existsByurlArticleTitle(body.toLowerCase() )){
            return ResponseEntity.badRequest().body("This Article dosen't exist!");
        }
        return ResponseEntity.ok("This Article Exist! \n"+ articleRepository.findByurlArticleTitle(body.toLowerCase()).toString());
    }

    @DeleteMapping("/{body}")
    @PreAuthorize("permitAll()")
    public ResponseEntity<?> deleteArticleByTitle(@PathVariable String body){

        if(articleRepository.existsByurlArticleTitle(body.toLowerCase() ) ){
            articleRepository.deleteByurlArticleTitle(body.toLowerCase());
            return ResponseEntity.ok(body + " Got Deleted!");
        }else if(!articleRepository.existsByurlArticleTitle(body.toLowerCase() )){
            return ResponseEntity.badRequest().body(" Article dosen't Exist!");
        }
        return ResponseEntity.badRequest().body(" Article didn't get deleted!");
    }

}

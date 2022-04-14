package com.OOP2PG1.application.controllers;

import com.OOP2PG1.application.entities.Page;
import com.OOP2PG1.application.entities.Site;
import com.OOP2PG1.application.repositories.PageRepository;
import com.OOP2PG1.application.repositories.SiteRepository;
import com.OOP2PG1.payload.response.MessageResponse;
import com.OOP2PG1.security.services.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/page")
public class PageController {

    Site site;

    @Autowired
    PageRepository pageRepository;
    MessageResponse messageResponse;

    SiteRepository siteRepository;

    UserDetailsImpl currentUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        return userDetails;
    }

    @GetMapping()
    //@PreAuthorize("permitAll()")
    public List<Page> getAllPages() {
        return pageRepository.findAll();
    }

    @PutMapping("/edit")
    @PreAuthorize("permitAll()") //("hasRole('ADMIN')")
    public ResponseEntity<?> editPage(@RequestBody Page page) {

        if(!pageRepository.existsByUrlTitlePage(page.getTitlePage().toLowerCase() )){ // add adminId check
            return ResponseEntity.badRequest().body(page.getTitlePage() + " Dosen't Exist " );
        }
        if(pageRepository.existsByUrlTitlePage(page.getTitlePage().toLowerCase())){
            Page temp = new Page();
            temp.setTitlePage(page.getTitlePage());
            temp.setUrlTitlePage(page.getTitlePage().toLowerCase() );
            temp.setParentSiteTitle(page.getParentSiteTitle());
            temp.setAdminId(page.getAdminId());
            temp.setId( pageRepository.findByUrlTitlePage( page.getTitlePage().toLowerCase() ).getId() );

            temp.setDescription(page.getDescription());
            temp.setColorTheme(page.getColorTheme());
            temp.setFont(page.getFont());
            temp.setLog(page.getLog());
            temp.setWallpaper(page.getWallpaper());

            pageRepository.save(temp);
            return ResponseEntity.ok(new MessageResponse("You Updated your Page "+ page.getTitlePage() + "!" ));
        }
        return ResponseEntity.badRequest().body("Error Something went wrong. Sorry!");
    }

    @PostMapping("/create")
    @PreAuthorize("permitAll()") // @PreAuthorize("hasRole('user')")
    public ResponseEntity<?> create(@RequestBody Page page){

        if(pageRepository.existsByUrlTitlePage(page.getTitlePage().toLowerCase())){
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Page Already Exist! " )); // siteRepository.findById(siteRepository.findById( ))
        }
        //siteRepository.findByTitle()

        page.getTitlePage();
        page.setUrlTitlePage(page.getTitlePage().toLowerCase());
        page.setAdminId(currentUser().getUsername());
        page.getParentSiteTitle();
        //page.getSiteId();
        //page.setSiteId(site.getId());

        page.getDescription();
        page.getLog();
        page.getWallpaper();
        page.getColorTheme();
        page.getFont();
        pageRepository.save(page);

        return ResponseEntity.ok(new MessageResponse("Page Created successfully! You Created "+ page.getTitlePage()
        ));
    }

    @PutMapping
    @PreAuthorize("hasRole('ADMIN')")
    public String update(){
        return "Site updated";
    }

    @PatchMapping
    @PreAuthorize("hasRole('ADMIN')")
    public String updateProperty(){
        return "Single Site property updated";
    }

    @DeleteMapping("/{body}")
    @PreAuthorize("permitAll()")// ("hasRole('ADMIN')")
    public ResponseEntity<?> deletePageByTitle(@PathVariable String body){

        if(pageRepository.existsByUrlTitlePage(body.toLowerCase() ) ){
            pageRepository.deleteByurlTitlePage(body.toLowerCase());
            return ResponseEntity.ok(body + " Got Deleted!");
        }else if(!pageRepository.existsByUrlTitlePage(body.toLowerCase() )){
            return ResponseEntity.badRequest().body(" Page dosen't Exist!");
        }
        return ResponseEntity.badRequest().body(" Page didn't get deleted!");
    }


    @GetMapping("/{body}")
    @PreAuthorize("permitAll()")
    public ResponseEntity<?> getPageTitle(@PathVariable String body){
        if(!pageRepository.existsByUrlTitlePage(body.toLowerCase())){
            return ResponseEntity.badRequest().body("This page dosen't exist!");
        }
        return ResponseEntity.ok("This Page Exist! \n"+ pageRepository.findByUrlTitlePage(body.toLowerCase())); // .toString()
    }

    @GetMapping("/get/{userPages}") // takes this parameter
    @PreAuthorize("permitAll()")
    public List<Page> getAdminId(@PathVariable String userPages){ // pass it into this method
        return pageRepository.findByAdminId(userPages);
    }


}

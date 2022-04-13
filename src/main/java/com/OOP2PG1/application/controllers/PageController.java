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

//    @GetMapping("/{id}")
//    @PreAuthorize("permitAll()")
//    public Site get(@PathVariable String id) {
//        return siteRepository.findById(id).get();
//    }
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
        page.setAdminId(currentUser().getUsername()); //site.getAdminId()
        page.getSiteId();
        //page.setSiteId(site.getId()); //

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

    @DeleteMapping
    @PreAuthorize("hasRole('ADMIN')")
    public String delete(){
        return "Site deleted";
    }


    @GetMapping("/{pageTitle}")
    @PreAuthorize("permitAll()")
    public Page getPageTitle(@PathVariable String pageTitle){
        Page temp = new Page();
        if(pageRepository.findByUrlTitlePage(pageTitle.toLowerCase()).get() == null){
            temp.setTitlePage("");
            temp.setTitlePage("This page dosen't exist!");
            return temp;
        }
        return pageRepository.findByUrlTitlePage(pageTitle.toLowerCase()).get();
    }

    @GetMapping("/get/{userPages}") // takes this parameter
    @PreAuthorize("permitAll()")
    public List<Page> getAdminId(@PathVariable String userPages){ // pass it into this method
        return pageRepository.findByAdminId(userPages);
    }



    //
//    @GetMapping("/all")
//    public String allAccess() {
//        return "Public Content.";
//    }
//
//    @GetMapping("/user")
//    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
//    public String userAccess() {
//        return "User Content.";
//    }
//
//    @GetMapping("/mod")
//    @PreAuthorize("hasRole('MODERATOR')")
//    public String moderatorAccess() {
//        return "Moderator Board.";
//    }
//
//    @GetMapping("/admin")
//    @PreAuthorize("hasRole('ADMIN')")
//    public String adminAccess() {
//        return "Admin Board.";
//    }

}

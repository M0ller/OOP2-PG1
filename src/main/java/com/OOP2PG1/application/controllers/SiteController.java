package com.OOP2PG1.application.controllers;

import com.OOP2PG1.application.entities.Site;
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
@RequestMapping("/site")
public class SiteController {

//    @Autowired
//    JwtUtils jwtUtils;

    @Autowired
    SiteRepository siteRepository;

    MessageResponse messageResponse;

//    @Autowired
//    SiteDetailsImpl siteDetailsImpl;

    UserDetailsImpl currentUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        return userDetails;
    }

    @GetMapping()
    //@PreAuthorize("permitAll()")
    public List<Site> getAllSites() {
        return siteRepository.findAll();
    }

//    @GetMapping("/{id}")
//    @PreAuthorize("permitAll()")
//    public Site get(@PathVariable String id) {
//        return siteRepository.findById(id).get();
//    }

    // fix control checks
    // fix adminId in frontend
    //
    @PostMapping("/create") // Add control's later
    @PreAuthorize("permitAll()") // @PreAuthorize("hasRole('user')")
    public ResponseEntity<?> create(@RequestBody Site site){ //SiteRequest siteRequest

        if(siteRepository.existsByurlHeader(site.getTitle().toLowerCase())){
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Site Already Exist!"));
        }

        //for postman use: site.setAdminId(currentUser().getId());
        //site.setAdminId(currentUser().getId());
        //for front end: site.getAdminId();  // gets the current user in the browser in the createSite.js user.username
        site.getTitle();
        site.setUrlHeader(site.getTitle().toLowerCase());
        site.getDescription();
        site.getLog();
        site.getWallpaper();
        site.getColorTheme();
        site.getFont();
        site.getAdminId();

        siteRepository.save(site);
        return ResponseEntity.ok(new MessageResponse("Site Created successfully! You Created "+ site.getTitle()
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


    @GetMapping("/{urlHeader}") // takes this parameter
    @PreAuthorize("permitAll()")
    public Site getSiteName(@PathVariable String urlHeader){ // pass it into this method
        String temp = urlHeader.toLowerCase();
        return siteRepository.findByurlHeader(temp).get();
    }

    @GetMapping("/get/{urlHeader}") // takes this parameter
    @PreAuthorize("permitAll()")
    public List<Site> getAdminId(@PathVariable String urlHeader){ // pass it into this method
        return siteRepository.findByAdminId(urlHeader);
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

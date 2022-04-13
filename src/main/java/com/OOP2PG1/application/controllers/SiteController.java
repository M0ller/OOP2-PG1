package com.OOP2PG1.application.controllers;

import com.OOP2PG1.application.entities.Page;
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



//    @GetMapping("/{id}")
//    @PreAuthorize("permitAll()")
//    public Site get(@PathVariable String id) {
//        return siteRepository.findById(id).get();
//    }

    // fix control checks
    // fix adminId in frontend
    //
//    @PatchMapping("site/edit")
//    @PreAuthorize("permitAll()") //("hasRole('ADMIN')")
//    public String updateProperty(@RequestBody ){
//        return "Single Site property updated";
//    }

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



//    @PutMapping
//    @PreAuthorize("hasRole('ADMIN')")
//    public String update(){
//        return "Site updated";
//    }
//    @DeleteMapping
//    @PreAuthorize("hasRole('ADMIN')")
//    public String delete(){
//        return "Site deleted";
//    }

    @GetMapping()
    //@PreAuthorize("permitAll()")
    public List<Site> getAllSites() {
        return siteRepository.findAll();
    }

    @GetMapping("/{body}") // Get Specific
    @PreAuthorize("permitAll()")
    public ResponseEntity<?> getSiteName(@PathVariable String body){ // pass it into this method
        if(!siteRepository.existsByurlHeader(body.toLowerCase() )){
            return ResponseEntity.badRequest().body("This Site dosen't exist!");
        }
        return ResponseEntity.ok("This Site Exist! \n"+ siteRepository.findByurlHeader(body.toLowerCase()).toString());
    }

    @DeleteMapping("/{body}") // Delete a Site
    @PreAuthorize("permitAll()")
    public ResponseEntity<?> deleteSiteByTitle(@PathVariable String body){

        if(siteRepository.existsByurlHeader(body.toLowerCase() ) ){
            siteRepository.deleteByurlHeader(body.toLowerCase());
            return ResponseEntity.ok(body + " Got Deleted!");
        }else if(!siteRepository.existsByurlHeader(body.toLowerCase() )){
            return ResponseEntity.badRequest().body(" Site dosen't Exist!");
        }
        return ResponseEntity.badRequest().body(" Site didn't get deleted!");
    }

    @GetMapping("/get/{userPages}") // Get All sites this user have
    @PreAuthorize("permitAll()")
    public List<Site> getAdminId(@PathVariable String userPages){ // pass it into this method
        return siteRepository.findByAdminId(userPages);
    }


}

package com.OOP2PG1.application.controllers;

import com.OOP2PG1.application.entities.Site;
import com.OOP2PG1.application.repositories.SiteRepository;
import com.OOP2PG1.application.services.SiteDetailsImpl;
import com.OOP2PG1.payload.response.JwtResponse;
import com.OOP2PG1.payload.response.MessageResponse;
import com.OOP2PG1.security.jwt.JwtUtils;
import com.OOP2PG1.security.services.UserDetailsImpl;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.repository.Query;
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

    @Autowired
    SiteDetailsImpl siteDetailsImpl;

    // This method returns a UserDetailsImpl object.
    UserDetailsImpl currentUser(){
        //retrieve the authentication from the current logged-in user ( its id, username, password, email and roles.) and places it into a new Authentication object called authentication.
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        // pass the authenticated user object as a UserDetailsImpl object into a UserDetailsImpl object called userDetails.
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        // returns the userDetails object of that user (which contains id, email, password and that users roles.)
        return userDetails;
    }

    @GetMapping()
    //@PreAuthorize("permitAll()")
    public List<Site> get() {
        return siteRepository.findAll();
    }

    @GetMapping("/{id}")
    @PreAuthorize("permitAll()")
    public Site get(@PathVariable String id) {
        return siteRepository.findById(id).get();
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public Site create(@RequestBody Site site){
        site.setCreator(currentUser().getId());
        site.setCreator_name(currentUser().getUsername());
        return siteRepository.save(site);
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


    @GetMapping("/{site_name}")
    @PreAuthorize("permitAll()")
    public ResponseEntity<?> getSite_name(String site_name){
//       siteRepository.findBySiteName(currentUser().getId()).getSite_name();
//       siteRepository.findById(currentUser().getId()).get();

        return  ResponseEntity.ok(new MessageResponse("Found this Site: " + site_name));
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

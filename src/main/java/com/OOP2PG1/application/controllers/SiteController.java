package com.OOP2PG1.application.controllers;

import com.OOP2PG1.application.entities.Site;
import com.OOP2PG1.application.entities.SiteRequest;
import com.OOP2PG1.application.repositories.SiteRepository;
import com.OOP2PG1.application.services.SiteDetailsImpl;
import com.OOP2PG1.models.ERole;
import com.OOP2PG1.models.Role;
import com.OOP2PG1.models.User;
import com.OOP2PG1.payload.request.SignupRequest;
import com.OOP2PG1.payload.response.MessageResponse;
import com.OOP2PG1.security.services.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

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

    @GetMapping("/{id}")
    @PreAuthorize("permitAll()")
    public Site get(@PathVariable String id) {
        return siteRepository.findById(id).get();
    }

    // fix control checks
    // fix adminId in frontend
    //
    @PostMapping("/create") // Add control's later
    @PreAuthorize("permitAll()") // @PreAuthorize("hasRole('user')")
    public ResponseEntity<?> create(@RequestBody Site site ){ //SiteRequest siteRequest

//        System.out.println("\n"+"FOUND THIS:" +siteRepository.findSiteByTitle(site.getTitle())+"\n");

//        if(siteRepository.existsByTitle(site.getTitleCheck())){
//            return ResponseEntity.badRequest().body(new MessageResponse("Error: Title " + site.getTitle() + " Already Exist"));
//        }
//        System.out.println();

//        siteRepository.findSiteByName(site.getTitle());

//        System.out.println("\n" + "HEREEEEEEEEEEEEEEEEEEEEEEEEE: "+ siteRepository.findSiteByName(site.getTitle()).toString() + "\n");


//        if(siteRepository.findAll().contains(site.getTitle())){
//            return ResponseEntity.badRequest().body(new MessageResponse("Error: Site Title"));
//        }

//        System.out.println(siteRepository.findAll());

//        if(siteRepository.findAll().equals(site.getTitle())){
//            System.out.println("Found Something");
//        }

//        if(siteRequest.getTitle().equalsIgnoreCase(temp) ){
//            return  ResponseEntity.badRequest().body(new MessageResponse("Error: Site Title"));
//        }
//        if( siteRepository.existsByTitle(site.getTitle().equalsIgnoreCase(site.getTitle()))){
//
//            return  ResponseEntity.badRequest().body(new MessageResponse("Error: Site Title"+ site.getTitle() +" is already taken!"));
//        }

        //for postman use: site.setAdminId(currentUser().getId());
        //site.setAdminId(currentUser().getId());
        //for front end: site.getAdminId();  // gets the current user in the browser in the createSite.js user.username
        site.getTitle();
        site.setTitleCheck(site.getTitle().toLowerCase());
        site.getDescription();
        site.getLog();
        site.getWallpaper();
        site.getColorTheme();
        site.getFont();
        site.getAdminId();

//        Site site = new Site(siteRequest.getTitle(), siteRequest.getDescription(), siteRequest.getLog(), siteRequest.getWallpaper(), siteRequest.getColorTheme(), siteRequest.getFont(), siteRequest.getAdminId());

        siteRepository.save(site);
        return ResponseEntity.ok(new MessageResponse("Site Created successfully! Site input is: "
//                + site.getTitle()
//                + " Site in database: " + siteRepository.findByTitle(site.getTitle())
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


    @GetMapping("/get/{title}")
    @PreAuthorize("permitAll()")
    public Site getSiteName(@PathVariable String title){
        return siteRepository.findByTitle(title).get();
    }

    @GetMapping("/test/{title}")
    @PreAuthorize("permitAll()")
    public List<Site> gettest(@PathVariable String title){
        return siteRepository.findByadminId(title);
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

package com.OOP2PG1.application.controllers;

import com.OOP2PG1.application.entities.Site;
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
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
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

    @PostMapping("/create") // Add control's later
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> create(@RequestBody Site site){
        if(siteRepository.existsByTitle(site.getTitle())){
            return  ResponseEntity.badRequest().body(new MessageResponse("Error: Site Title is already taken!"));
        }
//        if(siteRepository.findByTitle(site.getTitle().toLowerCase()).equals(site.getTitle().toLowerCase())){
//            return  ResponseEntity.badRequest().body(new MessageResponse("Error: Site Title is already taken!"));
//        }

        site.setAdminId(currentUser().getId());
        site.getTitle();
        site.getDescription();
        site.getLog();
        site.getIcon();
        site.getWallpaper();
        site.getColorTheme();
        site.getFont();
        siteRepository.save(site);
//        return ResponseEntity.ok(new MessageResponse("Site Created successfully! " + siteRepository.existsByTitle(site.getTitle().toLowerCase()) + " this happend " + site.getTitle().toLowerCase()));
        return ResponseEntity.ok(new MessageResponse("Site Created successfully! " ));
    }

//    @PostMapping("/signup")
//    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
//        // compare userRepository username to signUpRequest username. If true then the user already exist
//        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
//            return ResponseEntity
//                    .badRequest()
//                    .body(new MessageResponse("Error: Username is already taken!"));
//        }
//        // compare userRepository email to signUpRequest email. If true then the email already exist
//        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
//            return ResponseEntity
//                    .badRequest()
//                    .body(new MessageResponse("Error: Email is already in use!"));
//        }
//        // signUpRequest passed both if statements.
//        // Create new user's account
//        // passing signUpRequest data to a user object.
//        // Create new user's account
//        User user = new User(signUpRequest.getUsername(),
//                signUpRequest.getEmail(),
//                encoder.encode(signUpRequest.getPassword())); // passing the signUpRequest password into encoder method before passing it to the user object.
//
//        Set<String> strRoles = signUpRequest.getRoles();// passing signUpRequest roles to strRoles
//        Set<Role> roles = new HashSet<>(); // creating a new HasSet as a Role object
//
//        user.setRoles(roles); // pass the roles that exist into the user object
//        userRepository.save(user); // save the user object into the database
//
//        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
//    }

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

//    @GetMapping("/{site_name}")
//    //@PreAuthorize("permitAll()")
//    public Site getSite(@PathVariable String site_name) {
////        siteRepository.findById(currentUser().getId()).get().getSite_name()
//        return (Site) siteRepository.findByString(site_name).getAllSites();
//    }

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

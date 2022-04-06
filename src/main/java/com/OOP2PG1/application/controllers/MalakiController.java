package com.OOP2PG1.application.controllers;

import com.OOP2PG1.application.entities.Malaki;
import com.OOP2PG1.application.repositories.MalakiRepository;
import com.OOP2PG1.security.services.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/malaki")
public class MalakiController {

    @Autowired
    MalakiRepository malakiRepository;

    UserDetailsImpl currentUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        return userDetails;
    }

    @GetMapping()
    @PreAuthorize("permitAll()")
    public List<Malaki> get() {
        return malakiRepository.findAll();
    }

    @GetMapping("/{id}")
    @PreAuthorize("permitAll()")
    public Malaki get(@PathVariable String id) {
        return malakiRepository.findById(id).get();
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public Malaki create(@RequestBody Malaki malaki){
        malaki.setCreator(currentUser().getId());
        return malakiRepository.save(malaki);
    }

    @PutMapping
    @PreAuthorize("hasRole('ADMIN')")
    public String update(){
        return "Malaki updated";
    }

    @PatchMapping
    @PreAuthorize("hasRole('ADMIN')")
    public String updateProperty(){
        return "Single Malaki property updated";
    }

    @DeleteMapping
    @PreAuthorize("hasRole('ADMIN')")
    public String delete(){
        return "Malaki deleted";
    }

}

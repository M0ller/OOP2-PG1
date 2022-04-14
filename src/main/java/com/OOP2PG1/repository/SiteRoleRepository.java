package com.OOP2PG1.repository;

import com.OOP2PG1.models.ERole;
import com.OOP2PG1.models.Role;
import com.OOP2PG1.models.SiteRoles;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface SiteRoleRepository extends MongoRepository<Role, String> {
    Optional<SiteRoles> findByName(ERole name);

}

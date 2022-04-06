package com.OOP2PG1.repository;

import com.OOP2PG1.models.ERole;
import com.OOP2PG1.models.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface RoleRepository extends MongoRepository<Role, String> {
  Optional<Role> findByName(ERole name);
}

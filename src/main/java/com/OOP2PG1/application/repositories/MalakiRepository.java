package com.OOP2PG1.application.repositories;

import com.OOP2PG1.application.entities.Malaki;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MalakiRepository extends MongoRepository<Malaki, String> {

}

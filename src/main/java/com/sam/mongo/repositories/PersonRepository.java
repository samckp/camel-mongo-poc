package com.sam.mongo.repositories;

import com.sam.mongo.model.Person;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PersonRepository extends MongoRepository<Person, String> {

    public List<Person> findByFirstName(String firstName);
    public List<Person> findByLastName(String lastName);
    public List<Person> findAll();
}

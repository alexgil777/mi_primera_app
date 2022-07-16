package com.microservice.demo.java.repository;

import com.microservice.demo.java.document.GroseriaDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMessageRepository extends MongoRepository<GroseriaDocument, String> {

}

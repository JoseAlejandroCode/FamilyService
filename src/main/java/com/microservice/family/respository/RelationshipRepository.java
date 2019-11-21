package com.microservice.family.respository;

import com.microservice.family.model.document.Relationship;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface RelationshipRepository extends ReactiveMongoRepository<Relationship, String> {
}

package com.microservice.family.respository;

import com.microservice.family.model.document.Family;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface FamilyRepository extends ReactiveMongoRepository<Family, String> {
}

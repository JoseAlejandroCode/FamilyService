package com.microservice.family.respository;

import com.microservice.family.model.document.Family;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface FamilyRepository extends ReactiveMongoRepository<Family, String> {
  Flux<Family> findByIdStudent(String idStudent);
}

package com.microservice.family.service;

import com.microservice.family.model.document.Family;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface FamilyService {
  Flux<Family> findAll();
  Mono<Family> findById(String id);
  Mono<Family> create(Family family);
  Mono<Family> update(Family family, String id);
  Mono<Void> delete(String id);
}

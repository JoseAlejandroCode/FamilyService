package com.microservice.family.service;

import com.microservice.family.model.dto.FamilyDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface FamilyService {
  Flux<FamilyDto> findAll();
  Mono<FamilyDto> findById(String id);
  Mono<FamilyDto> create(FamilyDto family);
  Mono<FamilyDto> update(FamilyDto family, String id);
  Mono<Void> delete(String id);
}

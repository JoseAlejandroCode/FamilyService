package com.microservice.family.service;

import com.microservice.family.model.document.Relationship;
import com.microservice.family.model.dto.FamilyDto;
import com.microservice.family.model.dto.RelationshipDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface FamilyService {
  Flux<FamilyDto> findAll();
  Mono<FamilyDto> findById(String id);
  Flux<FamilyDto> findByIdStudent(String idStudent);
  Mono<FamilyDto> create(FamilyDto family);
  Mono<FamilyDto> update(FamilyDto family, String id);
  Mono<Void> delete(String id);
  Mono<RelationshipDto> findRelationshipById(String idRelationship);
  Flux<RelationshipDto> findAllRelationship();
  Mono<RelationshipDto> createRelationship(RelationshipDto relationship);
}

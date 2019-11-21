package com.microservice.family.service.impl;

import com.microservice.family.component.FamilyConverter;
import com.microservice.family.component.RelationshipConverter;
import com.microservice.family.model.dto.FamilyDto;
import com.microservice.family.model.dto.RelationshipDto;
import com.microservice.family.respository.FamilyRepository;
import com.microservice.family.respository.RelationshipRepository;
import com.microservice.family.service.FamilyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class FamilyServiceImpl implements FamilyService {

  @Autowired
  private FamilyRepository familyRepository;

  @Autowired
  private RelationshipRepository relationshipRepository;

  @Autowired
  private FamilyConverter familyConverter;

  @Autowired
  private RelationshipConverter relationshipConverter;

  @Override
  public Flux<FamilyDto> findAll() {
    return familyRepository.findAll()
            .flatMap(family -> {
              FamilyDto familyDto = familyConverter.convertToDto(family);
              familyDto.setRelationship(findRelationshipById(family.getIdRelationship()).block());
              return  Mono.just(familyDto);
            });
  }

  @Override
  public Mono<FamilyDto> findById(String id) {
    return familyRepository.findById(id)
            .flatMap(family -> {
              FamilyDto familyDto = familyConverter.convertToDto(family);
              familyDto.setRelationship(findRelationshipById(family.getIdRelationship()).block());
              return  Mono.just(familyDto);
            });
  }

  @Override
  public Flux<FamilyDto> findByIdStudent(String idStudent) {
    return familyRepository.findByIdStudent(idStudent)
            .flatMap(family -> {
              FamilyDto familyDto = familyConverter.convertToDto(family);
              familyDto.setRelationship(findRelationshipById(family.getIdRelationship()).block());
              return  Mono.just(familyDto);
            });
  }

  @Override
  public Mono<FamilyDto> create(FamilyDto family) {
    return familyRepository.save(familyConverter.convertToDocument(family))
            .flatMap(f ->{
              FamilyDto familyDto = familyConverter.convertToDto(f);
              familyDto.setRelationship(findRelationshipById(f.getIdRelationship()).block());
              return  Mono.just(familyDto);
            });
  }

  @Override
  public Mono<FamilyDto> update(FamilyDto family, String id) {
    return findById(id).flatMap(f -> {
      f.setFullName(family.getFullName());
      f.setBirthdate(family.getBirthdate());
      f.setGender(family.getGender());
      f.setTypeDocument(family.getTypeDocument());
      f.setNumberDocument(family.getNumberDocument());
      return familyRepository.save(familyConverter.convertToDocument(f));
    }).flatMap(f1 -> Mono.just(familyConverter.convertToDto(f1)));
  }

  @Override
  public Mono<Void> delete(String id) {
    return findById(id).flatMap(f -> familyRepository.delete(familyConverter.convertToDocument(f)));
  }

  @Override
  public Mono<RelationshipDto> findRelationshipById(String idRelationship) {
    return relationshipRepository.findById(idRelationship)
            .flatMap(relationship -> Mono.just(relationshipConverter.convertToDto(relationship)));
  }

  @Override
  public Flux<RelationshipDto> findAllRelationship() {
    return relationshipRepository.findAll()
            .flatMap(relationship -> Mono.just(relationshipConverter.convertToDto(relationship)));
  }

  @Override
  public Mono<RelationshipDto> createRelationship(RelationshipDto relationship) {
    return relationshipRepository.save(relationshipConverter.convertToDocument(relationship))
            .flatMap(r -> Mono.just(relationshipConverter.convertToDto(r)));
  }
}

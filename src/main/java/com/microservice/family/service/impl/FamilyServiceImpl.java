package com.microservice.family.service.impl;

import com.microservice.family.component.FamilyConverter;
import com.microservice.family.model.dto.FamilyDto;
import com.microservice.family.respository.FamilyRepository;
import com.microservice.family.service.FamilyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class FamilyServiceImpl implements FamilyService {

  @Autowired
  private FamilyRepository familyRepository;

  @Autowired
  private FamilyConverter familyConverter;

  @Override
  public Flux<FamilyDto> findAll() {
    return familyRepository.findAll()
            .flatMap(family -> Mono.just(familyConverter.convertToDto(family)));
  }

  @Override
  public Mono<FamilyDto> findById(String id) {
    return familyRepository.findById(id)
            .flatMap(family -> Mono.just(familyConverter.convertToDto(family)));
  }

  @Override
  public Flux<FamilyDto> findByIdPartner(String idPartner) {
    return familyRepository.findByIdPartner(idPartner)
            .flatMap(family -> Mono.just(familyConverter.convertToDto(family)));
  }

  @Override
  public Mono<FamilyDto> create(FamilyDto family) {
    return familyRepository.save(familyConverter.convertToDocument(family))
            .flatMap(f -> Mono.just(familyConverter.convertToDto(f)));
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
    return findById(id)
            .flatMap(f -> familyRepository.delete(familyConverter.convertToDocument(f)));
  }

  @Override
  public Mono<Void> deleteByIdPartner(String idPartner) {
    return findByIdPartner(idPartner)
            .flatMap(f -> delete(f.getId()))
            .next();
  }
}

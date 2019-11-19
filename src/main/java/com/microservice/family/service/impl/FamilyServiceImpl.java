package com.microservice.family.service.impl;

import com.microservice.family.model.document.Family;
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

  @Override
  public Flux<Family> findAll() {
    return familyRepository.findAll();
  }

  @Override
  public Mono<Family> findById(String id) {
    return familyRepository.findById(id);
  }

  @Override
  public Mono<Family> create(Family family) {
    return familyRepository.save(family);
  }

  @Override
  public Mono<Family> update(Family family, String id) {
    return findById(id).flatMap(f -> {
      f.setFullName(family.getFullName());
      f.setBirthdate(family.getBirthdate());
      f.setGender(family.getGender());
      f.setTypeDocument(family.getTypeDocument());
      f.setNumberDocument(family.getNumberDocument());
      return familyRepository.save(f);
    });
  }

  @Override
  public Mono<Void> delete(String id) {
    return findById(id).flatMap(f -> familyRepository.delete(f));
  }
}

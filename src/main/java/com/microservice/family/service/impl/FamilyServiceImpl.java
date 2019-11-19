package com.microservice.family.service.impl;

import com.microservice.family.model.document.Family;
import com.microservice.family.service.FamilyService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class FamilyServiceImpl implements FamilyService {
  @Override
  public Flux<Family> findAll() {
    return null;
  }

  @Override
  public Mono<Family> findById(String id) {
    return null;
  }

  @Override
  public Mono<Family> create(Family family) {
    return null;
  }

  @Override
  public Mono<Family> update(Family family, String id) {
    return null;
  }

  @Override
  public Mono<Void> delete(String id) {
    return null;
  }
}

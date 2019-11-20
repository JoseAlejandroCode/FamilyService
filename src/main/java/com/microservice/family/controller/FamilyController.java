package com.microservice.family.controller;

import com.microservice.family.component.FamilyConverter;
import com.microservice.family.model.dto.FamilyDto;
import com.microservice.family.service.FamilyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.URI;

@RestController
@RequestMapping("/api/family")
public class FamilyController {

  @Autowired
  private FamilyService familyService;

  @GetMapping
  public Mono<ResponseEntity<Flux<FamilyDto>>> listar(){
    return Mono.just(ResponseEntity
            .ok().contentType(MediaType.APPLICATION_JSON).body(familyService.findAll()));
  }

  @GetMapping("/{id}")
  public Mono<ResponseEntity<FamilyDto>> ver(@PathVariable String id){
    return familyService.findById(id)
            .map(family -> ResponseEntity
                    .ok().contentType(MediaType.APPLICATION_JSON).body(family));
  }

  @PostMapping
  public  Mono<ResponseEntity<FamilyDto>> registrar(@RequestBody FamilyDto family){
    return familyService.create(family)
            .map(f -> ResponseEntity
                    .created(URI.create("/api/family")).contentType(MediaType.APPLICATION_JSON).body(f));
  }

  @PutMapping("/{id}")
  public Mono<ResponseEntity<FamilyDto>> actulizar(@RequestBody FamilyDto family, @PathVariable String id){
    return familyService.update(family, id)
            .map(f -> ResponseEntity
                    .created(URI.create("/api/family")).contentType(MediaType.APPLICATION_JSON).body(f));
  }

  @DeleteMapping("/{id}")
  public Mono<ResponseEntity<Void>> eliminar(@PathVariable String id){
    return familyService.delete(id)
            .flatMap(p -> Mono.just(new ResponseEntity<Void>(HttpStatus.NO_CONTENT)))
            .defaultIfEmpty(new ResponseEntity<Void>(HttpStatus.NOT_FOUND));
  }

}

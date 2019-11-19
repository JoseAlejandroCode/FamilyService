package com.microservice.family.controller;

import com.microservice.family.component.FamilyConverter;
import com.microservice.family.service.FamilyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FamilyController {

  @Autowired
  private FamilyService familyService;

  @Autowired
  private FamilyConverter familyConverter;

}

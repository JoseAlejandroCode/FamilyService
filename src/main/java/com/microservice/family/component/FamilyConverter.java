package com.microservice.family.component;

import com.microservice.family.model.document.Family;
import com.microservice.family.model.dto.FamilyDTO;
import org.springframework.stereotype.Component;

@Component
public class FamilyConverter {
  public FamilyDTO converToDto(Family family){
    FamilyDTO familyDTO = new FamilyDTO();

    return familyDTO;
  }

  public Family convertToDocument(FamilyDTO familyDTO){
    Family family = new Family();

    return family;
  }
}

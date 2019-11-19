package com.microservice.family.component;

import com.microservice.family.model.document.Family;
import com.microservice.family.model.dto.FamilyDto;
import org.springframework.stereotype.Component;

@Component
public class FamilyConverter {
  public FamilyDto converToDto(Family family){
    FamilyDto familyDTO = new FamilyDto();

    return familyDTO;
  }

  public Family convertToDocument(FamilyDto familyDTO){
    Family family = new Family();

    return family;
  }
}

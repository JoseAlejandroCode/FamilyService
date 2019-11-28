package com.microservice.family.component;

import com.microservice.family.model.document.Family;
import com.microservice.family.model.dto.FamilyDto;
import org.springframework.stereotype.Component;

@Component
public class FamilyConverter {
  public FamilyDto convertToDto(Family family){
    FamilyDto familyDto = new FamilyDto();
    familyDto.setId(family.getId());
    familyDto.setFullName(family.getFullName());
    familyDto.setTypeDocument(family.getTypeDocument());
    familyDto.setNumberDocument(family.getNumberDocument());
    familyDto.setGender(family.getGender());
    familyDto.setBirthdate(family.getBirthdate());
    familyDto.setRelationship(family.getRelationship());
    return familyDto;
  }

  public Family convertToDocument(FamilyDto familyDto){
    Family family = new Family();
    family.setId(familyDto.getId());
    family.setFullName(familyDto.getFullName());
    family.setTypeDocument(familyDto.getTypeDocument());
    family.setNumberDocument(familyDto.getNumberDocument());
    family.setGender(familyDto.getGender());
    family.setBirthdate(familyDto.getBirthdate());
    family.setRelationship(familyDto.getRelationship());
    family.setIdInstitute(familyDto.getInstitute().getId());
    familyDto.getPartnerList().forEach(f -> family.addPartner(f.getId()));
    return family;
  }
}

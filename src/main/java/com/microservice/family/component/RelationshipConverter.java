package com.microservice.family.component;

import com.microservice.family.model.document.Relationship;
import com.microservice.family.model.dto.RelationshipDto;
import org.springframework.stereotype.Component;

@Component
public class RelationshipConverter {
  public RelationshipDto convertToDto(Relationship relationship){
    RelationshipDto relationshipDto = new RelationshipDto();
    relationshipDto.setId(relationship.getId());
    relationshipDto.setName(relationship.getName());
    return relationshipDto;
  }

  public Relationship convertToDocument(RelationshipDto relationshipDto){
    Relationship relationship = new Relationship();
    relationship.setId(relationshipDto.getId());
    relationship.setName(relationshipDto.getName());
    return relationship;
  }
}

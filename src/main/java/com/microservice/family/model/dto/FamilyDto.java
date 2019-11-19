package com.microservice.family.model.dto;

public class FamilyDto extends PersonDto {

  private String relationship;

  public String getRelationship() {
    return relationship;
  }

  public void setRelationship(String relationship) {
    this.relationship = relationship;
  }
}

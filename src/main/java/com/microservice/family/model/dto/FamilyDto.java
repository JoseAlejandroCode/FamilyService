package com.microservice.family.model.dto;

public class FamilyDto extends PersonDto {

  private String idStudent;
  private RelationshipDto relationship;

  public String getIdStudent() {
    return idStudent;
  }

  public void setIdStudent(String idStudent) {
    this.idStudent = idStudent;
  }

  public RelationshipDto getRelationship() {
    return relationship;
  }

  public void setRelationship(RelationshipDto relationship) {
    this.relationship = relationship;
  }
}

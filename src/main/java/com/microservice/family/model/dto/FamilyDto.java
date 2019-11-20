package com.microservice.family.model.dto;

public class FamilyDto extends PersonDto {

  private String idStudent;
  private String relationship;

  public String getIdStudent() {
    return idStudent;
  }

  public void setIdStudent(String idStudent) {
    this.idStudent = idStudent;
  }

  public String getRelationship() {
    return relationship;
  }

  public void setRelationship(String relationship) {
    this.relationship = relationship;
  }
}

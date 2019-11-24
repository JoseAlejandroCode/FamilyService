package com.microservice.family.model.dto;

import javax.validation.constraints.NotEmpty;

public class FamilyDto extends PersonDto {

  private String idPartner;
  @NotEmpty
  private String relationship;

  public String getIdPartner() {
    return idPartner;
  }

  public void setIdPartner(String idPartner) {
    this.idPartner = idPartner;
  }

  public String getRelationship() {
    return relationship;
  }

  public void setRelationship(String relationship) {
    this.relationship = relationship;
  }
}

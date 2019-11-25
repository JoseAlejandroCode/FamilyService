package com.microservice.family.model.dto;

import javax.validation.constraints.NotEmpty;
import java.util.List;

public class FamilyDto extends PersonDto {

  private List<PartnerDto> partnerList;
  @NotEmpty
  private String relationship;

  public String getRelationship() {
    return relationship;
  }

  public void setRelationship(String relationship) {
    this.relationship = relationship;
  }

  public List<PartnerDto> getPartnerList() {
    return partnerList;
  }

  public void setPartnerList(List<PartnerDto> partnerList) {
    this.partnerList = partnerList;
  }

  public void addPartner(PartnerDto partner) {
    this.partnerList.add(partner);
  }
}

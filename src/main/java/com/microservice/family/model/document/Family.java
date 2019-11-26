package com.microservice.family.model.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Document(collection = "family")
public class Family {

  @Id
  private String id;
  @NotEmpty
  private String fullName;
  @NotEmpty
  private String typeDocument;
  @NotEmpty
  private String numberDocument;
  @NotNull
  private Boolean gender;
  @NotNull
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date birthdate;
  @NotEmpty
  private String relationship;

  private List<String> partnerList;

  public Family() {
    partnerList = new ArrayList<>();
  }

  public Family(String fullName, String typeDocument, String numberDocument, Boolean gender, Date birthdate, String relationship) {
    this.fullName = fullName;
    this.typeDocument = typeDocument;
    this.numberDocument = numberDocument;
    this.gender = gender;
    this.birthdate = birthdate;
    this.relationship = relationship;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public String getTypeDocument() {
    return typeDocument;
  }

  public void setTypeDocument(String typeDocument) {
    this.typeDocument = typeDocument;
  }

  public String getNumberDocument() {
    return numberDocument;
  }

  public void setNumberDocument(String numberDocument) {
    this.numberDocument = numberDocument;
  }

  public Boolean getGender() {
    return gender;
  }

  public void setGender(Boolean gender) {
    this.gender = gender;
  }

  public Date getBirthdate() {
    return birthdate;
  }

  public void setBirthdate(Date birthdate) {
    this.birthdate = birthdate;
  }

  public String getRelationship() {
    return relationship;
  }

  public void setRelationship(String relationship) {
    this.relationship = relationship;
  }

  public List<String> getPartnerList() {
    return partnerList;
  }

  public void setPartnerList(List<String> partnerList) {
    this.partnerList = partnerList;
  }

  public void addPartner(String partner) {
    this.partnerList.add(partner);
  }
}

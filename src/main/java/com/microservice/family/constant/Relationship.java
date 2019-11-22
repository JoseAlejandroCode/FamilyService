package com.microservice.family.constant;

public enum Relationship {
  FATHER("father"),
  MATHER("mother"),
  SISTER("sister"),
  BROTHER("brother"),
  WIFE("wife"),
  HUSBAND("husband");

  private String relationship;

  Relationship(String relationship) {
    this.relationship = relationship;
  }
}

package com.microservice.family.model.dto;

import java.util.ArrayList;
import java.util.List;

public class PartnerDto extends PersonDto {

  private List<FamilyDto> familyList;
  private List<CourseDto> courseList;

  public PartnerDto() {
    super();
    familyList = new ArrayList<>();
    courseList = new ArrayList<>();
  }


  public void setFamilyList(List<FamilyDto> familyList) {
    this.familyList = familyList;
  }

  public List<FamilyDto> getFamilyList() {
    return familyList;
  }

  public void addFamily(FamilyDto family) {
    this.familyList.add(family);
  }

  public List<CourseDto> getCourseList() {
    return courseList;
  }

  public void setCourseList(List<CourseDto> courseList) {
    this.courseList = courseList;
  }

  public void addCourse(CourseDto course) {
    this.courseList.add(course);
  }
}

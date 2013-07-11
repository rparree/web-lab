package com.futurepeople.training.faces;

import com.futurepeople.training.domain.Course;
import com.futurepeople.training.service.CourseManagement;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

/**
 * todo
 */
@Named
@RequestScoped
public class SearchController {

  @Inject
  CourseManagement management;

  private String searchString;
  private List<Course> results;


  public List<Course> getResults() {
    return management.findCourse(searchString);
  }

  public String getSearchString() {
    return searchString;
  }

  public void setSearchString(String searchString) {
    this.searchString = searchString;
  }
}

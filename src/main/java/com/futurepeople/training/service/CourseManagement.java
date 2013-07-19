package com.futurepeople.training.service;

import com.futurepeople.training.domain.Course;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;

/**
 * todo
 */

@Singleton
public class CourseManagement {

  @Inject
  CourseRepositoryJDBC repository;

  public List<Course> findCourse(String searchString) {
   return repository.findCourse(searchString);
  }
}

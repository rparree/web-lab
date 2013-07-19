package com.futurepeople.training.service;

import com.futurepeople.training.domain.Event;
import com.futurepeople.training.domain.Student;

/**
 * todo
 */
public interface MainRepository {
  boolean isRegistered(String email);

  void insert(Student student);

  Student getStudent(long studentId);

  Event getEvent(long eventId);
}

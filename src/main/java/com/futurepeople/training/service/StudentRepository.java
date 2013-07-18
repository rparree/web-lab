package com.futurepeople.training.service;

import com.futurepeople.training.domain.Student;

/**
 * todo
 */
public interface StudentRepository {
  boolean isRegistered(String email);

  void insert(Student student);
}

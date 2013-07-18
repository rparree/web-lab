package com.futurepeople.training.service;

import com.futurepeople.training.domain.Student;

import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * todo
 */
@Singleton
public class StudentRepositoryJPAImpl implements StudentRepository {

  @PersistenceContext (unitName = "TrainingPU")
  EntityManager em;

  @Override
  public boolean isRegistered(String email) {
    return false;
  }

  @Override
  public void insert(Student student) {
    em.persist(student);
  }
}

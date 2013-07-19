package com.futurepeople.training.service;

import com.futurepeople.training.domain.Event;
import com.futurepeople.training.domain.Student;

import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * todo
 */
@Singleton
public class StudentRepositoryJPAImpl implements MainRepository {

  @PersistenceContext (unitName = "TrainingPU")
  EntityManager em;

  @Override
  public boolean isRegistered(String email) {
    String q = "select s from Student s where s.email=:e";
    TypedQuery<Student> query = em.createQuery(q, Student.class);
    query.setParameter("e",email);
    List<Student> resultList = query.getResultList();


    return !resultList.isEmpty();
  }

  @Override
  public void insert(Student student) {
    em.persist(student);
  }

  @Override
  public Student getStudent(long studentId) {
    return em.find(Student.class,studentId);
  }

  @Override
  public Event getEvent(long eventId) {
    return em.find(Event.class,eventId);
  }
}

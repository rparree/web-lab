package com.futurepeople.training.service;

import com.futurepeople.training.domain.Student;

import javax.inject.Inject;
import javax.ejb.Singleton;

/**
 * todo
 */

@Singleton
public class StudentManagement {

  @Inject
  StudentRepository repository;

  public void registerNewStudent(String email, String fullname, String password) throws RegistrationException {


    // todo check if email already registered
    if (repository.isRegistered(email))
      throw new RegistrationException("email address already in use.");

    // todo create a new student
    Student student;
    student = new Student(email);
    student.changePassword(password);
    student.setFullname(fullname);


    // todo insert student into database (fake for now)
    repository.insert(student);

    // todo send email
    System.out.append("Mock sending email to ").println(email);
  }
}

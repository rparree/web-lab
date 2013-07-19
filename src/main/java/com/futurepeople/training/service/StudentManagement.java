package com.futurepeople.training.service;

import com.futurepeople.training.domain.Event;
import com.futurepeople.training.domain.InactiveMembershipException;
import com.futurepeople.training.domain.InsufficientTokensException;
import com.futurepeople.training.domain.Student;

import javax.ejb.Singleton;
import javax.inject.Inject;

/**
 * todo
 */

@Singleton
public class StudentManagement {

  @Inject
  MainRepository mainRepository;


  public void registerNewStudent(String email, String fullname, String password) throws RegistrationException {


    // todo check if email already registered
    if (mainRepository.isRegistered(email))
      throw new RegistrationException("email address already in use.");

    // todo create a new student
    Student student;
    student = new Student(email);
    student.changePassword(password);
    student.setFullname(fullname);


    // todo insert student into database (fake for now)
    mainRepository.insert(student);

    // todo send email
    System.out.append("Mock sending email to ").println(email);
  }


  public void registerStudentOnEvent(long studentId, long eventId) throws InactiveMembershipException, InsufficientTokensException {
    Student student = mainRepository.getStudent(studentId);

    Event event = mainRepository.getEvent(eventId);

    student.register(event);

  }
}

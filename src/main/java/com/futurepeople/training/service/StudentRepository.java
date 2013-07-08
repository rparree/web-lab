package com.futurepeople.training.service;

import com.futurepeople.training.domain.Student;

import javax.annotation.Resource;
import javax.inject.Singleton;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * todo
 */
@Singleton
public class StudentRepository {

  @Resource(lookup = "java:/TrainingDS")
  DataSource dataSource;

  public boolean isRegistered(String email) {
    String sql = "select email from Student where email=?";

    try (Connection connection = dataSource.getConnection()) {
      System.out.println("Got connection");
      return false;
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }

  }

  public void insert(Student student) {

  }
}

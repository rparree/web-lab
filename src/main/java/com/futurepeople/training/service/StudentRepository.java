package com.futurepeople.training.service;

import com.futurepeople.training.domain.Student;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * todo
 */

public class StudentRepository {

  @Resource(lookup = "java:/TrainingDS")
  DataSource dataSource;

  public boolean isRegistered(String email) {
    String sql = "select id from Student where email=?";

    try (Connection connection = dataSource.getConnection();
         PreparedStatement stm = connection.prepareStatement(sql)

    ) {
      stm.setString(1, email);
      try (ResultSet rs = stm.executeQuery()) {
        return rs.next();
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);

    }


  }

  public void insert(Student student) {

  }
}

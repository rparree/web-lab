package com.futurepeople.training.service;

import com.futurepeople.training.domain.Student;

import javax.annotation.Resource;
import javax.enterprise.inject.Alternative;
import javax.inject.Singleton;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * todo
 */

@Alternative
@Singleton
public class StudentRepositoryJDBCImpl implements StudentRepository {

  @Resource(lookup = "java:/TrainingDS")
  DataSource dataSource;

  @Override
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

  @Override
  public void insert(Student student) {
     String sql = "INSERT INTO Student " +
           "(name,email,password) VALUES (?,?,?)";
    try (Connection connection = dataSource.getConnection();
         PreparedStatement stm = connection.prepareStatement(sql)

    ) {
      stm.setString(1, student.getName());
      stm.setString(2, student.getEmail());
      stm.setString(3, student.getPassword());
      stm.executeUpdate();
    } catch (SQLException e) {
      throw new RuntimeException(e);

    }


  }
}

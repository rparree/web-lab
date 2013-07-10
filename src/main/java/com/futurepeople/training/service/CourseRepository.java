package com.futurepeople.training.service;

import com.futurepeople.training.domain.Course;

import javax.annotation.Resource;
import javax.inject.Singleton;
import javax.sql.DataSource;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;

/**
 * todo
 */

@Singleton
public class CourseRepository {

  @Resource(lookup = "java:/TrainingDS")
  DataSource dataSource;

  public List<Course> findCourse(String searchString) {
    String sql ="select * from Event where type='C' and title like ?";

    try (Connection connection = dataSource.getConnection();
         PreparedStatement stm = connection.prepareStatement(sql)

    ) {
      stm.setString(1,  "%"+searchString+"%");

      List<Course> courses = new LinkedList<>();
      try (ResultSet rs = stm.executeQuery()) {
        while(rs.next()){
          Date startDate  = rs.getDate("startDate");
          int duration= rs.getInt("course_duration");
          String title= rs.getString("title");
          Course c = new Course(startDate,duration,title);
          courses.add(c);
        }
        return courses;
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);

    }


  }


}

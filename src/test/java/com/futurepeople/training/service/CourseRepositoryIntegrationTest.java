package com.futurepeople.training.service;

import com.futurepeople.training.domain.Course;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.OverProtocol;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsEmptyCollection.empty;
import static org.hamcrest.core.Is.is;

/**
 * todo
 */
@RunWith(Arquillian.class)
public class CourseRepositoryIntegrationTest {


  @Inject
  CourseRepositoryJDBC repository;

  @Resource(lookup = "java:/TrainingDS")
  DataSource dataSource;


  @Deployment
  @OverProtocol("Servlet 3.0")
  public static JavaArchive createDeployment() {
    JavaArchive archive = ShrinkWrap.create(JavaArchive.class, "test.jar")
          .addPackage("com.futurepeople.training.domain")
          .addClass(CourseRepositoryJDBC.class)
          .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    return archive;
  }

  @Before
  public void seedData() {
    String[] sql = new String[4];
    sql[0] = "delete from Event_Delegate;";
    sql[1] = "delete from Event;";
    sql[2] = "insert into Event (title,type,startDate, course_duration) VALUES (\"Java for the Brave\",\"C\",\"2013-01-12\",4 ),(\"Python for Java Developers\",\"C\",\"2013-02-17\",3 ),(\"Scala for JavaScript programmers\",\"C\",\"2013-07-26\",5 );";
    sql[3] = "insert into Event (title,type,startDate, seminar_price) VALUES (\"Java Performance\",\"S\",\"2013-06-12\",3 ),(\"Web Application Development with Scala\",\"S\",\"2013-10-20\",8 ),(\"Introduction to Jython\",\"S\",\"2013-04-11\",1 );";

    try (Connection con = dataSource.getConnection();
         Statement stm = con.createStatement()
    ) {
      for (String s : sql) {
        stm.execute(s);
      }

    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  @Test
  public void testFindManyCourse() throws Exception {
    List<Course> result = repository.findCourse("j");
    assertThat(result.size(), is(3));
  }

  @Test
  public void testFindOneCourse() throws Exception {
    List<Course> result = repository.findCourse("Java for the Brave");
    assertThat(result.size(), is(1));
  }

  @Test
  public void testFindNoCourse() throws Exception {
    List<Course> result = repository.findCourse("%$%$%$^$%$%");
    assertThat(result, empty());

  }

}

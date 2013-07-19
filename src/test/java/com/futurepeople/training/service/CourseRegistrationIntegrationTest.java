package com.futurepeople.training.service;

import com.futurepeople.training.domain.InactiveMembershipException;
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

/**
 * todo
 */
@RunWith(Arquillian.class)
public class CourseRegistrationIntegrationTest {


  @Inject
  StudentManagement management;

  @Resource(lookup = "java:/TrainingDS")
  DataSource dataSource;


  @Deployment
  @OverProtocol("Servlet 3.0")
  public static JavaArchive createDeployment() {
    JavaArchive archive = ShrinkWrap.create(JavaArchive.class, "test.jar")
          .addPackage("com.futurepeople.training.domain")
          .addPackage("com.futurepeople.training.service")
          .addAsResource("META-INF/persistence.xml")

          .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    return archive;
  }

  @Before
  public void seedData() {
    String[] sql = new String[7];
    sql[0] = "delete from Student_Event;";
    sql[1] = "delete from Student;";

    sql[2] = "delete from Event;";
    sql[3] = "insert into Event (id,title,event_type,startDate, duration) " +
          "VALUES (100,\"Java for the Brave\",\"C\",\"2013-01-12\",4 )," +
          "(101,\"Python for Java Developers\",\"C\",\"2013-02-17\",3 )," +
          "(102,\"Scala for JavaScript programmers\",\"C\",\"2013-07-26\",5 );";
    sql[4] = "insert into Event (id,title,event_type,startDate, priceInTokens) " +
          "VALUES (201,\"Java Performance\",\"S\",\"2013-06-12\",3 )," +
          "(202,\"Web Application Development with Scala\",\"S\",\"2013-10-20\",8 )," +
          "(203,\"Introduction to Jython\",\"S\",\"2013-04-11\",1 );";
    sql[5] = "insert into Student (id, active,email,fullname,tokens) " +
          "values (200,1,'jenny@work.com','Jennifer Wirth',20)";
    sql[6] = "insert into Student (id, active,email,fullname,tokens) " +
          "values (201,0,'narendra@work.com','Narendra Wirth',20)";


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
  public void testRegisterForCourse() throws Exception {
    management.registerStudentOnEvent(200l,100l);

  }

  @Test(expected = InactiveMembershipException.class)
  public void testRegisterWillFailForInactiveAccountForCourse() throws Exception {
    management.registerStudentOnEvent(201l,100l);

  }


}

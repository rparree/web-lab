package com.futurepeople.training.service;

import com.futurepeople.training.domain.Course;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.OverProtocol;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import java.util.List;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsEmptyCollection.empty;

/**
 * todo
 */
@RunWith(Arquillian.class)
public class CourseRepositoryIntegrationTest {


  @Inject
  CourseRepository repository;

  @Deployment @OverProtocol("Servlet 3.0")
  public static JavaArchive createDeployment() {
    JavaArchive archive = ShrinkWrap.create(JavaArchive.class, "test.jar")
          .addPackage("com.futurepeople.training.domain")
          .addClass(CourseRepository.class)
          .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    return archive;
  }

  @Test
  public void testFindCourse() throws Exception {
    List<Course> result = repository.findCourse("j");
    assertThat(result,not(empty()));

  }

  @Test
  public void testFindNoCourse() throws Exception {
    List<Course> result = repository.findCourse("%$%$%$^$%$%");
    assertThat(result,empty());

  }

}

package demo;

import com.futurepeople.training.service.RegistrationException;
import com.futurepeople.training.service.StudentManagement;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * todo
 */
@WebServlet(urlPatterns = "/register.do")
public class RegistrationServlet extends HttpServlet {

  @Inject
  StudentManagement management;

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

    String email = request.getParameter("emailValue");
    String fullname = request.getParameter("fullnameValue");
    String password = request.getParameter("passwordValue");


    try {
      management.registerNewStudent(email, fullname, password);
      // preparing data for JSP
      request.setAttribute("emailOfUser", email);
      request.setAttribute("fullnameOfUser", fullname);

      List<String> courses = new ArrayList<>();
      request.setAttribute("courses", courses);

      courses.add("Java for Dummies");
      courses.add("Scala for the brave");
      courses.add("Python for java people");

      // forward to JSP
      RequestDispatcher rd = request.getRequestDispatcher("thanks.jsp");
      rd.forward(request, response);
    } catch (RegistrationException e) {
      throw new ServletException(e);
    }



  }


}

package demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * todo
 */
@WebServlet(urlPatterns = "/time")
public class HelloWorldServlet extends HttpServlet {


  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    PrintWriter out = res.getWriter();
    out.print("<!DOCTYPE html>");
    out.print("<html>");
    out.print("<head>");
    out.print("<link rel='stylesheet' type='text/css' href='styles/main.css'>");
    out.print("</head>");

    out.print("<body>");
    out.append("<p>").
          append(new Date().toString()).
          println("</p>");

    for (int y=1;y<=10;y++) {
      out.print("<table>");
      out.append("<thead><tr><td>x</td><td>");
      out.print(y);
      out.append("x</td></tr></thead>");

      out.print("<tbody>");

      for (int i = 1; i <= 10; i++) {
        out.append("<tr>");
        out.append("<td>").append(Integer.toString(i)).append("</td>");
        out.append("<td>").append(Integer.toString(i * y)).append("</td>");
        out.append("</tr>");
      }


      out.print("</tbody>");
      out.print("</table>");
    }

    out.println("</body>");
    out.println("</html>");
  }
}

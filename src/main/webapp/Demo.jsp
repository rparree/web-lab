<%--
  Created by rparree on 6/27/13.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title></title>
</head>
<body>
    <p>thanks: <%= new java.util.Date() %></p>
  <table>
    <% for (int i=0;i<=10;i++){%>
    <tr>
      <td>
         <%=i%>
      </td>
      <td>
        <%=i*4%>

      </td>
      <% } %>
    </tr>
  </table>



</body>
</html>
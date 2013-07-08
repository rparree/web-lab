<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by rparree on 6/27/13.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title></title>
</head>
<body>
  <p>Thanks ${fullnameOfUser}, we have sent an email to ${emailOfUser}</p>
  <ul>

    <c:forEach items="${courses}" var="course">
      <li>${course}</li>
    </c:forEach>

  </ul>
</body>
</html>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: 123
  Date: 12.10.2016
  Time: 18:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
    <c:forEach var="item" items="${list}" step="1">
        <c:out value="${item}"/><p>
    </c:forEach>
</body>
</html>

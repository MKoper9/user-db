<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: RAV
  Date: 2020-02-08
  Time: 13:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>token-web</title>
</head>
<body>
Hello <c:out value="${user.login}"/>
<br/>
Your token is <c:out value="${token}"/>
</body>
</html>

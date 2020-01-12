<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Users</title>
</head>
<body>
<ol>
    <c:forEach var="user" items="${users}">
        <li>
            <c:out value="${user.login}"/>
        </li>
    </c:forEach>
</ol>
</body>
</html>
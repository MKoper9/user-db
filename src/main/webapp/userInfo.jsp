<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
</head>
<body>
Info from cookies:
<p>
<c:forEach var="coo" items="${cookies}">
<p>
    <c:out value="${coo.name}"/>
    <br/>
    <c:out value="${coo.value}"/>
</p>
</c:forEach>
</p>
</body>
</html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<h1>Register User</h1>

<form action="register" method="POST">
    Login <input type="text" name="login"/><br>
    Password <input type="password" name="password"/><br>
    ConfirmPassword <input type="password" name="confirmPassword"/><br>
    <c:if test="${param.hasErrors == 'true'}">
        <c:out value="Password are not the same"/>
    <br/>
    </c:if>
    Name <input type="text" name="name"/><br>
    LastName <input type="text" name="lastName"/><br>
    PhoneNumber <input type="text" name="phoneNumber"/><br>
    <input type="submit" value="Register  ">
</form>

</body>
</html>



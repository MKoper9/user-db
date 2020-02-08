<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<h1>Login User</h1>

<form action="login" method="POST">
    Login <input type="text" name="login"/><br>
    Password <input type="password" name="password"/><br>
    <input type="submit" value="Login">
    <c:if test="${param.error == 'true'}">
        <br/>
        Login failed
   </c:if>
</form>

</body>
</html>

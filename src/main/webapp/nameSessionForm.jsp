<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<h1>Name Session form</h1>

<form action="session" method="POST">
    Say my name <input type="text" name="name" value="Heisenberg" /><br>
    <input type="submit" value="Send">
</form>

My name is <c:out value="${nameFromSession}" />

</body>
</html>

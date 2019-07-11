<%--
  Created by IntelliJ IDEA.
  User: rXing
  Date: 7/7/2019
  Time: 5:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/bootstrap.min.css"/>">
</head>
<body>
<div class="container">
    <h1>My Custom - Login Form</h1>

    <c:if test="${not empty errorMessge}">
        <div style="color:red; font-weight: bold; margin: 30px 0px;">${errorMessge}</div>
    </c:if>

    <form name='login' action="login" method='POST'>
        <table>
            <tr>
                <td>UserName:</td>
                <td><input type='text' name='username' value='admin'></td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><input type='password' name='password' value="admin"/></td>
            </tr>
            <tr>
                <td colspan='2'><input name="submit" type="submit" value="Login"/></td>
            </tr>
        </table>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </form>


</div>
</body>
</html>

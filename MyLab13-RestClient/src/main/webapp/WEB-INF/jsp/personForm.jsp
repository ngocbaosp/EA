<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Add a Person</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/bootstrap.min.css"/>">
</head>
<body>
<div class="container">
    <form:form modelAttribute="person">
        <table>
            <tr>
                <td>FirstName:</td>
                <td><form:input path="firstName"/></td>
                <td><form:errors path="firstName" cssClass="alert-danger" /> </td>
            </tr>
            <tr>
                <td>LastName:</td>
                <td><form:input path="lastName"/></td>
                <td><form:errors path="lastName" cssClass="alert-danger" /> </td>
            </tr>
            <tr>
                <td>Age:</td>
                <td><form:input path="age"/></td>
                <td><form:errors path="age" cssClass="alert-danger" /> </td>
            </tr>
        </table>
        <input type="submit" value="Submit"/>
    </form:form>
    <c:if test="${msg == 'Update'}">
        <form action="delete/${person.id}" method="post">
            <button type="submit">Delete</button>
        </form>
    </c:if>
</div>
</body>
</html>
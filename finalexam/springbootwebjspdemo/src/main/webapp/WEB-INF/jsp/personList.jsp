<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Person currently in the system</title>
</head>

<body>
<h1>Persons currently in the Application</h1>

<table>
    <c:forEach var="person" items="${persons}">
        <tr>
            <td>${person.id}</td>
            <td>${person.firstName}</td>
            <td>${person.lastName}</td>
            <td>${person.age}</td>
            <td><a href="/person/${person.id}">Edit</a></td>
        </tr>
    </c:forEach>
</table>
<a href="person/add"> Add a Person</a>
</body>

</html>
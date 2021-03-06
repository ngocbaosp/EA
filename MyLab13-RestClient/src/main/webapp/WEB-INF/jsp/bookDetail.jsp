<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>${msg} a Car</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/bootstrap.min.css"/>">
</head>

<body>


<form:form modelAttribute="book" action="../books/${book.id}" method="post">
    <table>
        <tr>
            <td>Title:</td>
            <td><form:input path="title"></form:input></td>
            <td><form:errors path="title" cssClass="alert-danger"></form:errors></td>

        </tr>
        <tr>
            <td>ISBN (9780596520687):</td>
            <td><form:input path="ISBN"></form:input></td>
            <td><form:errors path="ISBN" cssClass="alert-danger"></form:errors></td>

        </tr>
        <tr>
            <td>Author:</td>
            <td><form:input path="author"></form:input></td>
            <td><form:errors path="author" cssClass="alert-danger"></form:errors></td>

        </tr>
        <tr>
            <td>Price:</td>
            <td><form:input path="price"></form:input></td>
            <td><form:errors path="price" cssClass="alert-danger"></form:errors></td>
        </tr>
    </table>
    <input type="submit"/>
</form:form>

<c:if test="${msg == 'Update'}">
    <form action="delete?bookId=${book.id}" method="post">
        <button type="submit">Delete</button>
    </form>
</c:if>
</body>

</html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>${msg} a Car</title>
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/bootstrap.min.css"/>">
</head>

<body>
<div class="row">
	<sec:authorize access="isAuthenticated()">
		<p>Welcome Back, <sec:authentication property="name"/></p>
		<p><a href="logout">Logout</a></p>
	</sec:authorize>
</div>


<form:form modelAttribute="book" action="../books/add" method="post">
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
	<input type="submit" />
</form:form>

</body>

</html>
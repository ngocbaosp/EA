<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>${msg} a Car</title>
</head>

<body>
<div class="row">
	<sec:authorize access="isAuthenticated()">
		<p>Welcome Back, <sec:authentication property="name"/></p>
		<p><a href="logout">Logout</a></p>
	</sec:authorize>
</div>


<form:form modelAttribute="book" action="../books" method="post">
	<table>
		<tr>
			<td>Title:</td>
			<td><form:input path="title"></form:input></td>
		</tr>
		<tr>
			<td>ISBN:</td>
			<td><form:input path="ISBN"></form:input></td>

		</tr>
		<tr>
			<td>Author:</td>
			<td><form:input path="author"></form:input></td>

		</tr>
		<tr>
			<td>Price:</td>
			<td><form:input path="price"></form:input></td>
		</tr>
	</table>
	<input type="submit" />
</form:form>

</body>

</html>
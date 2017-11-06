<!DOCTYPE HTML>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" media="screen" href="/webjars/bootstrap/3.3.7/css/bootstrap.min.css">
<html>
<head>
    <title>Order Item Editing</title>
    <style>
    .error {
		color: #ff0000;
	}
	.errorblock{
		color: #000;
		background-color: #ffEEEE;
		border: 3px solid #ff0000;
		padding:8px;
		margin:16px;
	}
	</style>
</head>
<body>
<div>
<h1>My basic marketplace</h1>
</div>
<div>
<a href="/product/" class="btn btn-default">Products</a>
<a href="/deal/" class="btn btn-default">Deals</a>
</div>
<div>
<form:form method="POST" commandName="indexFormDto" action="/setDate">
   <table>
    <tr>
        <td colspan="2"><form:label path="date">Start Date</form:label></td>
        <td><form:input path="date" /></td>
        <td><form:errors path="date"  cssClass="error" /></td>
    </tr>
    <tr>
        <td colspan="2">
            <input type="submit" name="action" value="Set" class="btn btn-default"/>
        </td>
    </tr>
</table>  
</form:form>
</div>
</body>
</html>

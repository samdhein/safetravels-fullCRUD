<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
   <h1>Edit Expense</h1>
 	<form:form action="/expenses/edit/${expense.id }" method="POST" modelAttribute="expense">
 		<input type="hidden" name="_method" value="put" />
    	<div>
    		<form:label path="name">Expense name:</form:label>
    		<form:input type="text" path="name" />
    		<form:errors path="name" />
    	</div>
    	<div>
    		<form:label path="vendor">Vendor</form:label>
    		<form:textarea path="vendor"></form:textarea>
    		<form:errors path="vendor" />
    	</div>
    	<div>
 			<form:label path="price">Price</form:label>
    		<form:input type="number" step="0.01" path="price" />
    		<form:errors path="price" />
    	</div>
    	<button>Submit</button>
    </form:form>
</body>
</html>


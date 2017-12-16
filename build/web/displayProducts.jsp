<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Product Maintenance</title>
	<link rel="stylesheet" href="styles/main.css">
</head>
<body>
	<h1>Products</h1>

	<table>
		<tr>
			<th style="width:75px">Code</th>
			<th style="width:500px">Description</th>
			<th style="width:75px;text-align:right">Price</th>
            <th></th>
            <th></th>
		</tr>

		<c:forEach var="product" items="${products}">
			<tr>
				<td>${product.code}</td>
				<td>${product.description}</td>
				<td style="text-align:right">${product.price}</td>
				<td><a href="productMaint?action=editProduct&productCode=${product.code}">Edit</a></td>
				<td><a href="productMaint?action=deleteProduct&productCode=${product.code}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>

	<form action="productMaint" method="get">
		<input type="hidden" name="action" value="addProduct" />
		<input type="submit" value="Add Product" />
	</form>
</body>
</html>
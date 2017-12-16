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
	<h1>Are you sure you want to delete this product?</h1>

	<table>
		<tr><td><b>Code:</b></td><td>${product.code}</td></tr>
		<tr><td><b>Description:</b></td><td>${product.description}</td></tr>
	    <tr><td><b>Price:</b></td><td>${product.price}</td></tr>
	</table>

    <form action="productMaint" method="post">
        <input type="hidden" name="action" value="confirmDelete" />
        <input type="hidden" name="productCode" value="${product.code}" />
        <input type="submit" value="Yes" />
    </form>
    <form action="productMaint" method="get">
        <input type="hidden" name="action" value="displayProducts" />
        <input type="submit" value="No" />
    </form>
</body>
</html>
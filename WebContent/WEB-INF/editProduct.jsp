<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Product Maintenance</title>
    <link rel="stylesheet" href="styles/main.css">
</head>
<body>
<h1>Product</h1>

<div class="error">${error}</div>
    
<form action="productMaint" method="post">
    <input type="hidden" name="action" value="updateProduct" />
    <input type="hidden" name="isNew" value="${isNew}" />
    <c:if test="${!isNew}">
      <input type="hidden" name="code" value="${product.code}" />
    </c:if>
    <label for="code">Code:</label><input type="text" name="code" size="10" value="${product.code}" ${isNew ? '' : 'disabled'}/> <br />
    <label for="description">Description:</label><input type="text" name="description" size="50" value="${product.description}"/> <br />
    <label for="price">Price:</label><input type="text" name="price" size="10" value="${product.price}"/> <br />
    <input type="submit" value="Update Product" />
</form>

<form action="productMaint" method="get">
    <input type="hidden" name="action" value="displayProducts" />
    <input type="submit" value="View Products" />
</form>

</body>
</html>
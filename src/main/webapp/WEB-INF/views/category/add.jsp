<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>category-add</title>
  <link href="<c:url value="/css/style.css"/>" rel="stylesheet"/>
</head>
<body>
<form:form method="post" modelAttribute="category">
  <form:label path="name"/>Nazwa kategorii<br>
  <form:input path="name" type="text"/><br>

  <form:label path="description"/>Opis kategorii<br>
  <form:input path="description" type="text"/><br>

  <input value="Zapisz" type="submit"><br>
</form:form>
</body>
</html>

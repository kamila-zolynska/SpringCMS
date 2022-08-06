<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>article-list</title>
    <link href="<c:url value="/css/style.css"/>" rel="stylesheet"/>
</head>
<body>
<table>
    <tr>
        <th>Nazwa kategorii</th>
        <th>Opis</th>
        <th>Akcje do wykonania</th>
    </tr>
    <c:forEach items="${categories}" var="category">
        <tr>
            <td>${category.name}</td>
            <td>${category.description}</td>
            <td>
                <a href="/category/edit?id=${category.id}">Edytuj</a><br>
                <a href="/category/delete?id=${category.id}">Usun</a>
            </td>
        </tr>
    </c:forEach>
</table><br><br>
<a href="/category/add">Dodaj kategorie</a><br>
</body>
</html>

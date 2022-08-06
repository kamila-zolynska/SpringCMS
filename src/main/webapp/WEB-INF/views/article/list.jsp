<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="<c:url value="/css/style.css"/>" rel="stylesheet"/>
</head>
<body>
<table>
    <tr>
        <th>title</th>
        <th>author</th>
        <th>categories</th>
        <th>content</th>
    </tr>
    <c:forEach items="${articleList}" var="article">
        <tr>
            <td>${article.title}</td>
            <td>${article.author.fullName}</td>
            <td>
                <c:forEach items="${article.categories}" var="category">
                    ${category.name}<br>
                </c:forEach>
            </td>
            <td>${article.content}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>

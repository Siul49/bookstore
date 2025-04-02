<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head><title>도서 목록</title></head>
<body>
<h2>도서 목록</h2>
<table border="1">
    <tr>
        <th>도서번호</th>
        <th>도서이름</th>
        <th>출판사</th>
        <th>가격</th>
    </tr>
    <c:forEach var="book" items="${books}">
        <tr>
            <td>${book.id}</td>
            <td>${book.title}</td>
            <td>${book.publisher}</td>
            <td>${book.price}</td>
        </tr>
    </c:forEach>
</table>
<br>
<a href="register.jsp">[신규 도서 등록]</a>
</body>
</html>

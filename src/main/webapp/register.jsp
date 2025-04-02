<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head><title>신규 도서 등록</title></head>
<body>
<h2>신규 도서 등록</h2>
<form action="register" method="post">
    도서번호: <input type="number" name="id" required><br>
    도서이름: <input type="text" name="title" required><br>
    출판사: <input type="text" name="publisher" required><br>
    가격: <input type="number" name="price" required><br><br>
    <input type="submit" value="제출">
</form>
</body>
</html>

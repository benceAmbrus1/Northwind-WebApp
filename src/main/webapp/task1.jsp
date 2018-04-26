<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!doctype html>
<html lang="en">

<body>
    <h1>Northwind WebApp</h1>
    <form action="Task1Servlet" method="POST">
        <input type="submit" class="submit" value="OrderByCompany">
    </form>
    <table>
        <tr>
            <td><strong>Company</strong></td>
            <td><strong>Product</strong></td>
        </tr>
        <c:forEach items="${tasks}" var="task">
        <tr>
            <td>${task.getCompany()}</td>
            <td>${task.getProduct()}</td>
        </tr>
        </c:forEach>
    </table>

</body>

</html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <title><c:out value="${pageTitle}"/></title>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content = "IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://kit.fontawesome.com/0fcdece88e.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="/assets/css/style.css">
    <link rel="stylesheet" href="/assets/css/cart_delivery.css">
    <a href="https://www.flaticon.com/free-icons/done" title="done icons"></a>
</head>
<body>
<%-- Header --%>
<%@ include file="../shared/_header.jsp" %>

<%-- Body --%>
<main>
    ${param.yield}
</main>

<%-- Footer --%>
<%@ include file="../shared/_footer.jsp" %>
</body>
<script src="/assets/js/script.js"></script>
</html>

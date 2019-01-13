<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--
  Created by IntelliJ IDEA.
  User: mirella
  Date: 2019.01.12.
  Time: 21:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Title</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
              integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
              crossorigin="anonymous">
        <link href="https://fonts.googleapis.com/css?family=Didact+Gothic|Raleway|Yantramanav" rel="stylesheet">
        <link rel="stylesheet" href="<c:url value="/resources/css/main.css" />"/>
        <link href="https://fonts.googleapis.com/css?family=Didact+Gothic|Raleway|Yantramanav" rel="stylesheet">
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" defer
                integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
                crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" defer
                integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
                crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" defer
                integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
                crossorigin="anonymous"></script>
    </head>
    <body>
        <nav class="navbar navbar-dark bg-dark d-flex justify-content-end font">
            <form class="form-inline align-self-center my-2">
                <a href="${pageContext.request.contextPath}/shoppingcart" class="btn btn-outline-light font">
                    Display Shopping Cart
                </a>
            </form>
        </nav>
        <div class="container mt-4 font">
            <h1 class="display-2 text-dark text-center font">Web Shop</h1>
        </div>
        <div class="container font">
            <table class="table font">
                <thead class="thead-dark">
                <tr>
                    <th>ID</th>
                    <th>Product Name</th>
                    <th>Price</th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                    <c:forEach items="${availableItems}" var="item">
                        <tr>
                            <td>${item.getId()}</td>
                            <td>${item.getName()}</td>
                            <td class="text-right">${item.getPrice()}</td>
                            <td class="d-flex justify-content-center">
                                <form method="post" action="${pageContext.request.contextPath}/webshop">
                                    <input type="hidden" name="id" value="${item.getId()}">
                                    <input type="hidden" name="action" value="add">
                                    <input type="submit" class="btn btn-success mr-2" value="Add">
                                </form>
                                <form method="post" action="${pageContext.request.contextPath}/webshop">
                                    <input type="hidden" name="id" value="${item.getId()}">
                                    <input type="hidden" name="action" value="remove">
                                    <input type="submit" class="btn btn-outline-dark ml-2" value="Remove">
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>

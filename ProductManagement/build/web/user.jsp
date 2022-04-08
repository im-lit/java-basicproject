<%-- 
    Document   : user
    Created on : Oct 18, 2021, 9:24:38 PM
    Author     : DELL
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Page</title>
    </head>
    <body>
        <c:if test="${sessionScope.LOGIN_USER == null or sessionScope.LOGIN_USER.roleID ne 'US'}">
            <c:remove var="LOGIN_USER"/>
            <c:redirect url="login.jsp"></c:redirect>
        </c:if>
        <h1>Hello USER: ${sessionScope.LOGIN_USER.fullName}</h1>
        
        <h2>${requestScope.CHECK_OUT}</h2>
        <c:url var="logoutLink" value="MainController">
            <c:param name="action" value="Logout"></c:param>
        </c:url>
        <a href="${logoutLink}">Logout</a>
        <c:url var="cartLink" value="cart.jsp">                                                           
        </c:url>
        <a href="${cartLink}">Cart</a>
        <c:if test="${requestScope.LIST_VEGETABLE != null}">
            <c:if test="${not empty requestScope.LIST_VEGETABLE}">
                <table border="1">

                    <thead>
                        <tr>
                            <th>No</th>
                            <th>Vegetable Name</th>
                            <th>Price</th>
                            <th>Image</th>
                            <th>Category </th>
                            <th></th>
                        </tr> 
                    </thead>
                    <tbody>
                        <c:forEach var="veg" varStatus="counter" items="${requestScope.LIST_VEGETABLE}">
                        <form action="MainController" method="POST">                      
                            <tr>
                                <td>${counter.count}</td>

                                <td>          
                                    ${veg.vegetableName}
                                </td>
                                <td>   
                                    ${veg.price}
                                </td>
                                <td> 
                                    <img src="img/${veg.image}" width="90" height="50">
                                </td>
                                <td>     
                                    ${veg.categoryID}
                                </td>
                                <td>
                                    <c:url var="addToCartLink" value="MainController">
                                        <c:param name="action" value="AddToCart"></c:param>
                                        <c:param name="vegetableID" value="${veg.vegetableID}"></c:param>                                       
                                    </c:url>
                                    <a href="${addToCartLink}">Buy</a>
                                </td>

                            </tr>
                        </form>
                    </c:forEach> 
                </tbody>     
            </table>

        </c:if>
    </c:if>
</body>
</html>

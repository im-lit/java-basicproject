<%-- 
    Document   : create
    Created on : Oct 21, 2021, 10:32:07 PM
    Author     : DELL
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CREATE VEGETABLE Page</title>
    </head>
    <body>
        <c:if test="${sessionScope.LOGIN_USER == null or sessionScope.LOGIN_USER.roleID ne 'AD'}">
            <c:remove var="LOGIN_USER"/>
            <c:redirect url="login.jsp"></c:redirect>
        </c:if>
        <h1>Create new  Vegetable!</h1>
        
        <form action="MainController">
            Vegetable ID(*): <input type="text" name="vegID" value="${param.vegID}" required="">
            ${requestScope.VEGETABLE_ERROR.vegetableIDError}</br>
            Vegetable Name(*): <input type="text" name="vegName" value="${param.vegName}" required="">
            ${requestScope.VEGETABLE_ERROR.vegetableNameError}</br>
            Price(*): <input type="number" name="vegPrice" value="${param.vegPrice}" required="">
            ${requestScope.VEGETABLE_ERROR.priceError}</br>
            Quantity(*): <input type="number" name="vegQuantity" value="${param.vegQuantity}" required="">
            ${requestScope.VEGETABLE_ERROR.quantityError}</br>
            Image(*): <input type="file" name="image" class="form-control">
            ${requestScope.VEGETABLE_ERROR.imageError}</br>
            Category(*):<input type="text" name="vegCategory" value="${param.vegCategory}" required="">
            ${requestScope.VEGETABLE_ERROR.categoryIDError}</br>
            <input type="submit" name="action" value="Create"> 
        </form>
            <a href="admin.jsp">Back to Admin Page</a>
    </body>
</html>

<%-- 
    Document   : login
    Created on : Oct 18, 2021, 9:18:29 PM
    Author     : DELL
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>LOGIN PAGE</title>
    </head>
    <body>
         <c:if test="${sessionScope.LOGIN_USER != null }">
             <c:remove var="LOGIN_USER"/>
        </c:if>
        <h1 style="font-size:60px; background-color: aqua; text-align: center ">LOGIN</h1>
        <form action="MainController" method="POST">
            UserID: <input type="text" name="userID" /></br>
            Password: <input type="password" name="password"/></br>
            <input type="submit" name="action" value="Login">
            <input type="reset" value="Reset">
        </form>
        ${requestScope.ERROR_MESSAGE}
    </body>
</html>

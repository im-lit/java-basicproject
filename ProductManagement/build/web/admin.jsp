<%-- 
    Document   : admin
    Created on : Oct 18, 2021, 9:24:23 PM
    Author     : DELL
--%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Page</title>
    </head>
    <body>
        <c:if test="${sessionScope.LOGIN_USER == null or sessionScope.LOGIN_USER.roleID ne 'AD'}">
            <c:remove var="LOGIN_USER"/>
            <c:redirect url="login.jsp"></c:redirect>
        </c:if>
        <h1>Hello Admin: ${sessionScope.LOGIN_USER.fullName}</h1> 
        <c:url var="logoutLink" value="MainController">
            <c:param name="action" value="Logout"></c:param>
        </c:url>
        <a href="${logoutLink}">Logout</a></br>
        <a href="create.jsp">Add new Vegetable</a>
        <form action="MainController">
            Search <input type="text" name="search" value="${param.search}"/>
            <input type="submit" name="action" value="Search"/>
        </form>
            ${requestScope.NOT_FOUND} </br>   
        Category: 
        <c:forEach items="${requestScope.LIST_CATEGORY}" var="category"> 
            <a href="SearchCategoryController?categoryID=${category.categoryID}">${category.categoryName}</a>
        </c:forEach> 
        <c:set var="err" value="${requestScope.VEGETABLE_ERROR}"/>
       


        <c:if test="${requestScope.LIST_VEGETABLE != null}">
            <c:if test="${not empty requestScope.LIST_VEGETABLE}">
                <table border="1">

                    <thead>
                        <tr>
                            <th>No</th>
                            <th>Vegetable ID</th>
                            <th>Vegetable Name</th>
                            <th>Price</th>
                            <th>Quantity</th>
                            <th>Status</th>
                            <th>Image</th>
                            <th>Category </th>
                            <th>Delete</th>
                            <th>Update</th>
                        </tr> 
                        <tr>
                            <th></th>
                            <th></th>
                            <th><font color="red">${err.vegetableNameError} </font></th>
                            <th><font color="red">${err.priceError} </font>  </th>
                            <th><font color="red">${err.quantityError} </font></th>
                            <th><font color="red">${err.statusError} </font></th>
                            <th><font color="red">${err.imageError} </font></th>
                            <th><font color="red">${err.categoryIDError} </font> </th>
                            <th></th>
                            <th></th>
                        </tr> 
                    </thead>

                    <tbody>
                        <c:forEach var="veg" varStatus="counter" items="${requestScope.LIST_VEGETABLE}">
                        <form action="MainController" method="POST">                      
                            <tr>
                                <td>${counter.count}</td>
                                <td> 
                                    <input type="text" name="vegID" value="${veg.vegetableID}" readonly=""/>
                                </td>
                                <td>          
                                    <input type="text" name="vegName" value="${veg.vegetableName}" required=""/>

                                </td>
                                <td>   
                                    <input type="text" name="vegPrice" value="${veg.price}" required=""/>


                                </td>
                                <td>  
                                    <input type="text" name="vegQuantity" value="${veg.quantity}" required=""/>

                                </td>
                                <td>
                                    <input type="text" name="vegStatus" value="${veg.status}" required=""/>

                                </td>
                                <td> 
                                    <img src="img/${veg.image}" width="90" height="50">
                                    <input type="text" name="vegImage" value="${veg.image}"/>

                                </td>
                                <td>     
                                    <input type="text" name="vegCategory" value="${veg.categoryID}" required=""/>   

                                </td>
                                <td>
                                    <c:url var="deleteLink" value="MainController">
                                        <c:param name="action" value="Delete"></c:param>
                                        <c:param name="vegetableID" value="${veg.vegetableID}"></c:param>                                       
                                        <c:param name="search" value="${param.search}"></c:param>
                                    </c:url>
                                    <a href="${deleteLink}">Delete</a>
                                </td>
                                <td>
                                    <input type="submit" name="action" value="Update"/>
                                    <input type="hidden" name="search" value="${param.search}"/>
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

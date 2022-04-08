<%-- 
    Document   : cart
    Created on : Oct 27, 2021, 8:13:01 PM
    Author     : DELL
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cart Page</title>
    </head>
    <body>
        <c:if test="${sessionScope.LOGIN_USER == null or sessionScope.LOGIN_USER.roleID ne 'US'}">
            <c:remove var="LOGIN_USER"/>
            <c:redirect url="login.jsp"></c:redirect>
        </c:if>
        <h2> ${requestScope.ERR}</h2>
        <c:url var="userLink" value="UserController">

        </c:url>
        <a href="${userLink}">Back to home</a>
        <table border="1">

            <thead>
                <tr>
                    <th>No</th>
                    <th>Image</th>
                    <th>Price</th>
                    <th>Quantity </th>
                    <th>Amount</th>
                    <th></th>
                    <th></th>
                </tr> 
            </thead>
            <tbody>
                <c:forEach items="${sessionScope.CART}" varStatus="counter" var="c">
                <form action="UpdateCartController" method="POST">                      
                    <tr>
                        <td>${counter.count}</td>

                        <td>   

                            <img src="img/${c.veg.image}" alt="" width="150"  height="100">
                            <h5>${c.veg.vegetableName}</h5>

                        </td>
                        <td> 
                            ${c.price}$
                        </td>
                        <td>     
                            <input type="text" name="quantity" value="${c.quantity}"/>
                        </td>
                        <td>
                            ${c.quantity*c.price}$
                            <c:set var="amount" value="${c.quantity*c.price}"/>
                        </td>
                        <td>

                            <input type="submit" value="Update"/>
                            <input type="hidden" name="vegetableID" value="${c.veg.vegetableID}"/> 
                        </td>
                        <td>
                            <c:url var="deleteToCartLink" value="MainController">
                                <c:param name="action" value="deleteToCart"></c:param>
                                <c:param name="vegetableID" value="${c.veg.vegetableID}"></c:param>                                       
                            </c:url>
                            <a href="${deleteToCartLink}">Delete</a>
                        </td>
                    </tr>
                    <c:set var="total" value="${total+amount}"/>
                </form>
            </c:forEach>
        </tbody>     
    </table>
    <div class="col-lg-6">
        <div class="shoping__checkout">
            <h5>Cart Total</h5>
            <ul>
                <li>Total <span>${total}$</span></li>
            </ul>
            <a href="checkout.jsp" class="primary-btn">PROCEED TO CHECKOUT</a>
        </div>
    </div>
</body>
</html>

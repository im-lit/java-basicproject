<%-- 
    Document   : newjsp
    Created on : Oct 27, 2021, 8:53:09 PM
    Author     : DELL
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:if test="${sessionScope.LOGIN_USER == null or sessionScope.LOGIN_USER.roleID ne 'US'}">
            <c:remove var="LOGIN_USER"/>
            <c:redirect url="login.jsp"></c:redirect>
        </c:if>
        <c:url var="cartLink" value="cart.jsp">

        </c:url>
        <a href="${cartLink}">Back to cart</a>
        <section class="checkout spad">
            <div class="container">
                <c:set value="${sessionScope.LOGIN_USER}" var="u"/>
                <c:set value="${requestScope.ERROR_CREATE}" var="err"/>
                <div class="checkout__form">
                    <h4>Billing Details</h4>
                    <form action="CheckOutController">
                        <div class="row">
                            <div class="col-lg-8 col-md-6">
                                <div class="row">
                                    <div class="col-lg-6">
                                        <div class="checkout__input">
                                            <p>Full Name<span>*</span></p>
                                            <input type="text" value="${u.fullName}" name="name">
                                            ${requestScope.ERROR_CREATE.fullNameError}
                                        </div>
                                    </div>

                                </div>

                                <div class="checkout__input">
                                    <p>Phone<span>*</span></p>
                                    <input type="text" name="phone" value="">
                                    ${requestScope.ERROR_CREATE.phoneError}
                                </div>



                                <div class="row">
                                    <div class="col-lg-6">
                                        <div class="checkout__input">
                                            <p>Adress: <span>*</span></p>
                                            <input type="text" name="address" value="">
                                            ${requestScope.ERROR_CREATE.addressError}
                                        </div>
                                    </div>

                                </div>



                            </div>
                            <div class="col-lg-4 col-md-6">
                                <div class="checkout__order">
                                    <h4>Your Order</h4>
                                    <div class="checkout__order__products">Products <span>Total</span></div>
                                    <ul>
                                        <c:forEach items="${sessionScope.CART}" var="c">
                                            <li>${c.veg.vegetableName} <span> ${c.quantity*c.price}$
                                                    <c:set var="amount" value="${c.quantity*c.price}"/></span></li>
                                                    <c:set var="total" value="${total+amount}"/>
                                                </c:forEach>
                                    </ul>                                 
                                    <div class="checkout__order__total">Total <span>${total}$</span></div>
                                    <input type="hidden" name="total" value="${total}"/>
                                    <input type="hidden" name="userID" value="${u.userID}"/>
                                    <button type="submit" class="site-btn">PLACE ORDER</button>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </section>
    </body>
</html>

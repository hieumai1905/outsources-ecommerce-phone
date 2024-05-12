<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="pageTitle" value="Giỏ hàng" scope="request"/>

<c:import url="/WEB-INF/views/layouts/application_layout.jsp">
    <c:param name="yield">
        <section class="cart" style="margin-top: 70px;">
            <div class="container">
                <div class="cart-header">
                    <div class="go-back">
                        <a href="index.html">
                            <i class="fa-solid fa-arrow-left"></i>
                        </a>
                        <p>
                            Giỏ hàng của bạn
                        </p>
                    </div>
                </div>
                <c:if test="${not empty message}">
                    <div style="margin-top: 20px;">
                        <div class="go-back">
                            <p>
                                <i style="color: red;">${message}</i>
                            </p>
                        </div>
                    </div>
                </c:if>

                <div class="cart-top-wrap">
                    <div class="cart-top">
                        <div class="cart-top-cart cart-top-item">
                            <i class="fa-solid fa-cart-shopping" style="color: #0db7ea;"></i>
                        </div>

                        <div class="cart-top-address cart-top-item">
                            <i class="fa-solid fa-location-dot"></i>
                        </div>

                        <div class="cart-top-payment cart-top-item">
                            <i class="fa-solid fa-money-check-dollar"></i>
                        </div>
                    </div>
                </div>
            </div>

            <div class="container">
                <div class="cart-content row">
                    <div class="cart-content-left">
                        <table>
                            <tr>
                                <th>Sản phẩm</th>
                                <th>Tên sản phẩm</th>
                                <th>SL</th>
                                <th>Thành tiền</th>
                                <th></th>
                            </tr>
                            <c:forEach items="${cartItems}" var="item">
                                <tr>
                                    <td><img
                                            src="/assets/image/${item.productVersion.photo}"
                                            alt=""></td>
                                    <td><p>${item.productVersion.name}</p></td>
                                    <td>${item.quantity}</td>
                                    <td><fmt:formatNumber value="${item.productVersion.price}" type="currency"
                                                          currencySymbol="đ"/></td>
                                    <td><a href="/carts?action=remove&&id=${item.productVersion.id}" style="color: black;"><i class="fa-regular fa-trash-can"></i></a></td>
                                </tr>
                            </c:forEach>
                        </table>
                    </div>

                    <div class="cart-content-right">
                        <table>
                            <tr>
                                <th colspan="2">TỔNG TIỀN GIỎ HÀNG</th>
                            </tr>
                            <tr>
                                <td>TỔNG SẢN PHẨM</td>
                                <td>${cartItems.size()}</td>
                            </tr>
                            <tr>
                                <td>TỔNG TIỀN HÀNG</td>
                                <td><fmt:formatNumber value="${total}" type="currency" currencySymbol="đ"/></td>
                            </tr>
                            <tr>
                                <td>TẠM TÍNH</td>
                                <td><fmt:formatNumber value="${total}" type="currency" currencySymbol="đ"/></td>
                            </tr>
                        </table>

                        <div class="cart-content-right-button">
                            <button><a href="/home" style="color: black;">TIẾP TỤC MUA SẮM</a></button>
                            <button><a href="/checkout?action=checkout">THANH TOÁN</a></button>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </c:param>
</c:import>

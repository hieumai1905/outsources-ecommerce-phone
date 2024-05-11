<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:set var="pageTitle" value="Home Page" scope="request"/>

<c:import url="/WEB-INF/views/layouts/application_layout.jsp">
    <c:param name="yield">
        <%@ include file="_menu.jsp" %>
        <%@ include file="_slider.jsp" %>
        <%@ include file="_banner_one.jsp" %>
        <section class="product-gallery-one">
            <div class="container">
                <div class="product-gallery-one-content">
                    <div class="product-gallery-one-content-title">
                        <h2>DANH SÁCH ĐIỆN THOẠI</h2>
                    </div>
                    <div class="product-gallery-one-content-product">
                        <div class="product-gallery-one-content-product-item">
                            <img src="/assets/image/iphone-15-pro-max-blue-titanium-pure-back-iphone-15-pro-max-blue-titanium-pure-front-2up-screen-usen.webp"
                                 alt="">
                            <div class="product-gallery-one-content-product-item-text">
                                <li>
                                    <i class="fa-brands fa-themeco" style="color: #d7bd3c;"></i>
                                    <p>Trợ giá</p>
                                </li>
                                <li>
                                    <a href="">
                                        iPhone 15 Pro Max 256G
                                    </a>
                                </li>
                                <li class="product_badge">
                                    <p class="product_more-info_item">6.7 inches</p>
                                    <p class="product_more-info_item">8GB</p>
                                    <p class="product_more-info_item">256GB</p>
                                </li>
                                <li>
                                    <p>
                                        29.590.000
                                        <sup>đ</sup>
                                    </p>
                                </li>
                                <li>
                                    <a href="#">
                                        <button class="button-8">
                                            <i class="fa-solid fa-cart-shopping" aria-hidden="true"></i>
                                            Thêm vào giỏ hàng
                                        </button>
                                    </a>
                                </li>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </c:param>
</c:import>

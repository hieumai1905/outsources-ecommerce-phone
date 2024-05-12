<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:forEach var="productVersion" items="${productVersions}">
    <div class="product-gallery-one-content-product-item">
        <img
                src="/assets/image/${productVersion.photo}"
                alt="">
        <div class="product-gallery-one-content-product-item-text">
            <li>
                <i class="fa-brands fa-themeco" style="color: #d7bd3c;"></i>
                <p>Trợ giá</p>
            </li>
            <li>
                <a href="">
                        ${productVersion.name}
                </a>
            </li>
            <li class="product_badge">
                <p class="product_more-info_item">${productVersion.sizeScreen} inches</p>
                <p class="product_more-info_item">${productVersion.ram}GB</p>
                <p class="product_more-info_item">${productVersion.rom}GB</p>
            </li>
            <li>
                <p>
                    <fmt:formatNumber value="${productVersion.price}" type="currency" currencySymbol="đ"/>
                </p>
            </li>
            <li>
                <a href="/carts?action=add&&id=${productVersion.id}">
                    <button class="button-8">
                        <i class="fa-solid fa-cart-shopping" aria-hidden="true"></i>
                        Thêm vào giỏ hàng
                    </button>
                </a>
            </li>
        </div>
    </div>
</c:forEach>

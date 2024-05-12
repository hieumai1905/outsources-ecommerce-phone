<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:set var="pageTitle" value="Trang chủ" scope="request"/>

<c:import url="/WEB-INF/views/layouts/application_layout.jsp">
    <c:param name="yield">
        <%@ include file="_menu.jsp" %>
        <%@ include file="_slider.jsp" %>
        <%@ include file="_banner_one.jsp" %>
        <section class="productVersion-gallery-one">
            <div class="container">
                <div class="productVersion-gallery-one-content">
                    <div class="product-gallery-one-content-title">
                        <h2>DANH SÁCH ĐIỆN THOẠI</h2>
                    </div>
                    <div class="product-gallery-one-content-product">
                        <jsp:include page="../product_versions/_product.jsp">
                            <jsp:param name="productVersions" value="${productVersions}" />
                        </jsp:include>
                    </div>
                </div>
            </div>
        </section>
    </c:param>
</c:import>

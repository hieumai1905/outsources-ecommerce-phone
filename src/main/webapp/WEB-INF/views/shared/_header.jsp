<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<nav>
    <div class="container">

        <ul>
            <li>
                <a href="index.html">
                    <img src="/assets/image/logo.webp" style="width: 200px;" alt="">
                </a>
            </li>
            <li>
                <a href="">
                </a>
                <button>
                    <i class="fa-solid fa-list"></i>
                    Danh mục
                </button>
            </li>
            <li id="address-form">
                <a href="#">
                    <i class="fa-solid fa-location-dot"></i>
                    Đà Nẵng
                    <i class="fa-solid fa-sort-down"></i>
                </a>
            </li>
            <li>
                <input type="Bạn cần tìm gì?" placeholder="Bạn cần tìm gì?">
                <i class="fa-solid fa-magnifying-glass"></i>
            </li>
            <li>
                <a href="">
                    <i class="fa-solid fa-phone"></i>
                    Gọi mua hàng<br>
                    1800.2097
                </a>
            </li>
            <li>
                <a href="https://cellphones.com.vn/dia-chi-cua-hang" target="_blank">
                    <i class="fa-solid fa-location-dot"></i>
                    Cửa hàng<br>
                    gần bạn
                </a>
            </li>
            <li>
                <a href="order.html" target="_blank">
                    <i class="fa-solid fa-truck-fast"></i>
                    Tra cứu<br>
                    đơn hàng
                </a>
            </li>
            <li>
                <a href="cart.html">
                    <button>
                        <i class="fa-solid fa-cart-shopping"></i>
                        Giỏ hàng
                    </button>
                </a>
            </li>
            <li>
                <a href="">
                </a>
                <button>
                    <i class="fa-solid fa-user"></i>
                    Đăng nhập
                </button>
            </li>
            <div class="address-form">
                <div class="address-form-content">
                    <h2>Chọn địa chỉ nhận hàng <span id="address-close"><i class="fa-solid fa-circle-xmark"></i>Đóng</span></h2>
                    <form action="">
                        <p>Chọn đầy đủ địa chỉ nhận hàng để biết chính xác thời gian giao</p>
                        <select name="">
                            <option value="#">--Chọn địa điểm</option>
                            <option value="#">Đà Nẵng</option>
                        </select>
                        <select name="">
                            <option value="#">--Chọn Quận/Huyện</option>
                            <option value="#">Đà Nẵng</option>
                        </select>
                        <select name="">
                            <option value="#">--Chọn Phường/Xã</option>
                            <option value="#">Đà Nẵng</option>
                        </select>
                        <input type="text" placeholder="Số nhà, tên đường (không bắt buộc)">
                        <button>XÁC NHẬN</button>
                    </form>
                </div>
            </div>
        </ul>
    </div>
</nav>

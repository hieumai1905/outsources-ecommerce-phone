package com.example.ecommercesmartphone.controllers;

import com.example.ecommercesmartphone.DAOs.ProductVersionDAO;
import com.example.ecommercesmartphone.models.Cart;
import com.example.ecommercesmartphone.models.CartItem;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CheckoutController", urlPatterns = "/checkout")
public class CheckoutController extends HttpServlet {

    private ProductVersionDAO productVersionDAO;

    @Override
    public void init() {
        productVersionDAO = ProductVersionDAO.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "checkout":
                checkout(req, resp);
                break;
            default:
                resp.sendRedirect("/home");
        }
    }

    private void checkout(HttpServletRequest req, HttpServletResponse resp) {
        List<CartItem> cartItems = Cart.getCartItems(req);

        if (cartItems.size() == 0) {
            req.setAttribute("message", "Không thể thanh toán khi giỏ hàng trống!");
            try {
                req.getRequestDispatcher("/WEB-INF/views/carts/index.jsp").forward(req, resp);
                return;
            } catch (ServletException | IOException e) {
                e.printStackTrace();
            }
        }

        for (CartItem cartItem : cartItems) {
            productVersionDAO.updateQuantity(cartItem.getProductVersion().getId(), cartItem.getProductVersion().getQuantity() - cartItem.getQuantity());
        }
        Cart.clearCart(req);
        req.setAttribute("message", "Thanh toán thành công!");
        try {
            req.getRequestDispatcher("/WEB-INF/views/carts/index.jsp").forward(req, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
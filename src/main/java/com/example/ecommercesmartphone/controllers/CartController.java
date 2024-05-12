package com.example.ecommercesmartphone.controllers;

import com.example.ecommercesmartphone.DAOs.ProductVersionDAO;
import com.example.ecommercesmartphone.models.Cart;
import com.example.ecommercesmartphone.models.CartItem;
import com.example.ecommercesmartphone.models.ProductVersion;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CartController", urlPatterns = "/carts")
public class CartController extends HttpServlet {

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
            case "add":
                create(req, resp);
                break;
            case "remove":
                delete(req, resp);
                break;
            default:
                index(req, resp);
                break;
        }
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        ProductVersion productVersion = productVersionDAO.getById(id);
        Cart.removeProductVersion(req, productVersion);
        resp.sendRedirect("/carts");
    }

    private void create(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        ProductVersion productVersion = productVersionDAO.getById(id);
        Cart.addProductVersion(req, productVersion);
        resp.sendRedirect("/home");
    }

    private void index(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<CartItem> cartItems = Cart.getCartItems(req);
        req.setAttribute("cartItems", cartItems);
        double total = 0;
        for (CartItem cartItem : cartItems) {
            total += cartItem.getProductVersion().getPrice() * cartItem.getQuantity();
        }
        req.setAttribute("total", total);
        req.getRequestDispatcher("/WEB-INF/views/carts/index.jsp").forward(req, resp);
    }
}

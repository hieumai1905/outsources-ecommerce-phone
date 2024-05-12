package com.example.ecommercesmartphone.models;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class Cart {
    public static void addProductVersion(HttpServletRequest request, ProductVersion productVersion) {
        HttpSession session = request.getSession();
        List<CartItem> cartItems = (List<CartItem>) session.getAttribute("cartItems");

        if (cartItems == null) {
            cartItems = new ArrayList<>();
        }

        boolean isExisted = false;
        for (CartItem cartItem : cartItems) {
            if (cartItem.getProductVersion().getId() == productVersion.getId()) {
                isExisted = true;
                cartItem.setQuantity(cartItem.getQuantity() + 1);
                break;
            }
        }

        if (!isExisted) {
            CartItem newCartItem = new CartItem(productVersion);
            cartItems.add(newCartItem);
        }

        session.setAttribute("cartItems", cartItems);
    }

    public static void removeProductVersion(HttpServletRequest request, ProductVersion productVersion) {
        HttpSession session = request.getSession();
        List<CartItem> cartItems = (List<CartItem>) session.getAttribute("cartItems");

        if (cartItems != null) {
            for (CartItem cartItem : cartItems) {
                if (cartItem.getProductVersion().getId() == productVersion.getId()) {
                    cartItems.remove(cartItem);
                    break;
                }
            }
            session.setAttribute("cartItems", cartItems);
        }
    }

    public static void clearCart(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.removeAttribute("cartItems");
    }

    public static List<CartItem> getCartItems(HttpServletRequest request) {
        HttpSession session = request.getSession();
        List<CartItem> cartItems = (List<CartItem>) session.getAttribute("cartItems");

        if (cartItems == null) {
            cartItems = new ArrayList<>();
            session.setAttribute("cartItems", cartItems);
        }

        return cartItems;
    }
}

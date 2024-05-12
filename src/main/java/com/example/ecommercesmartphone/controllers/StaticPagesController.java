package com.example.ecommercesmartphone.controllers;


import com.example.ecommercesmartphone.DAOs.ProductVersionDAO;
import com.example.ecommercesmartphone.models.ProductVersion;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "StaticPages", urlPatterns = "/home")
public class StaticPagesController extends HttpServlet {
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
            default:
                index(req, resp);
                break;
        }
    }

    private void index(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<ProductVersion> productVersions = productVersionDAO.getAllProducts();
        req.setAttribute("productVersions", productVersions);
        req.getRequestDispatcher("/WEB-INF/views/static_pages/index.jsp").forward(req, resp);
    }
}

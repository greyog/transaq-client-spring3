package com.greyog.transaqclientspring3.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/image", name = "DynamicContentServlet")
public class DynamicContentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("image/svg+xml");
        String name = req.getParameter("name");
        if (name == null) {
            name = "";
        }
        String svg = "<?xml version='1.0' encoding='UTF-8' standalone='no'?>"
                + "<svg xmlns='http://www.w3.org/2000/svg' "
                + "xmlns:xlink='http://www.w3.org/1999/xlink'>"
                + "<rect x='10' y='10' height='100' width='100' "
                + "style=' fill: #90C3D4'/><text x='30' y='30' fill='red'>"
                + name + "</text>" + "</svg>";
        resp.getWriter().write(svg);
    }
}
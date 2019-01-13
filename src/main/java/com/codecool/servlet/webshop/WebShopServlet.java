package com.codecool.servlet.webshop;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "webshop", urlPatterns = {"/", "/webshop"}, loadOnStartup = 1)
public class WebShopServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        int idOfItem = Integer.valueOf(request.getParameter("id"));
        ItemStore.add(WebShopItems.getInstance().getItemById(idOfItem));
        doGet(request, response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        List<Item> availableItems = WebShopItems.getInstance().getAvailableItems();
        request.setAttribute("availableItems", availableItems);
        request.getRequestDispatcher("/WEB-INF/webshop.jsp").forward(request, response);
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int idOfItem = Integer.valueOf(request.getParameter("id"));
        ItemStore.remove(WebShopItems.getInstance().getItemById(idOfItem));
        doGet(request, response);

    }

}

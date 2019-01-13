package com.codecool.servlet.webshop;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "shoppingcart", urlPatterns = {"/shoppingcart"}, loadOnStartup = 2)
public class ShoppingCartServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        List<Item> shoppingCartContent = ItemStore.getItemList();
        request.setAttribute("shoppingCartContent", shoppingCartContent);
        Double totalPrice = shoppingCartContent.stream()
                .mapToDouble(Item::getPrice)
                .sum();
        request.setAttribute("totalPrice", totalPrice);
        request.getRequestDispatcher("/WEB-INF/shoppingcart.jsp").forward(request, response);
    }
}

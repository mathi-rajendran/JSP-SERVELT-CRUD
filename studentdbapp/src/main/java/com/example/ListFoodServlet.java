package com.example;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/food")
public class ListFoodServlet extends HttpServlet {
    private final FoodDAO dao = new FoodDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        List<Food> foods = dao.listFood();
        req.setAttribute("foods", foods);
        req.getRequestDispatcher("/listFood.jsp").forward(req, resp);
    }
}
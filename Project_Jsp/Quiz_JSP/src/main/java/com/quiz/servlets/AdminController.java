package com.quiz.servlets;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/AdminController")
public class AdminController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int choice = Integer.parseInt(request.getParameter("choice"));

        switch (choice) {
            case 1:
                request.getRequestDispatcher("newQuiz.jsp").forward(request, response);
                break;

            case 2:
                request.getRequestDispatcher("updateQuiz.jsp").forward(request, response);
                break;

            case 3:
                request.getRequestDispatcher("deleteQuiz.jsp").forward(request, response);
                break;

            case 4:
                request.getRequestDispatcher("listQuiz.jsp").forward(request, response);
                break;

            case 5:
                request.getRequestDispatcher("viewScores.jsp").forward(request, response);
                break;

            case 6:
                request.getSession().invalidate();
                response.sendRedirect("mainMenu.jsp");
                break;
        }
    }
}

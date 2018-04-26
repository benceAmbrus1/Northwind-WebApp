package com.codecool.web.servlet;

import com.codecool.web.dao.TaskDB;
import com.codecool.web.service.Task2Service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/Task2Servlet")
public class Task2Servlet extends AbstractServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try (Connection connection = getConnection(req.getServletContext())) {
            TaskDB db = new TaskDB(connection);
            Task2Service service = new Task2Service(db);

            req.setAttribute("tasks", service.getUnorderedTask2());
            req.getRequestDispatcher("task2.jsp").forward(req, resp);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection connection = getConnection(req.getServletContext())) {
            TaskDB db = new TaskDB(connection);
            Task2Service service = new Task2Service(db);

            req.setAttribute("tasks", service.getOrderedTask2());
            req.getRequestDispatcher("task2.jsp").forward(req, resp);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

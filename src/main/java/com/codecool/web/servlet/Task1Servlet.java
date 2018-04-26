package com.codecool.web.servlet;

import com.codecool.web.dao.TaskDB;
import com.codecool.web.model.Task1;
import com.codecool.web.service.Task1Service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/Task1Servlet")
public class Task1Servlet extends AbstractServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try (Connection connection = getConnection(req.getServletContext())) {
            TaskDB db = new TaskDB(connection);
            Task1Service service = new Task1Service(db);

            req.setAttribute("tasks", service.getUnorderedTask1());
            req.getRequestDispatcher("task1.jsp").forward(req, resp);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try (Connection connection = getConnection(req.getServletContext())) {
            TaskDB db = new TaskDB(connection);
            Task1Service service = new Task1Service(db);

            req.setAttribute("tasks", service.getOrderedTask1());
            req.getRequestDispatcher("task1.jsp").forward(req, resp);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

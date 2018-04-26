package com.codecool.web.servlet;

import com.codecool.web.dao.TaskDB;
import com.codecool.web.service.Task5Service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/Task5Servlet")
public class Task5Servlet extends AbstractServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try (Connection connection = getConnection(req.getServletContext())) {
            TaskDB db = new TaskDB(connection);
            Task5Service service = new Task5Service(db);

            req.setAttribute("tasks", service.getUnorderedTask5());
            req.getRequestDispatcher("task5.jsp").forward(req, resp);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try (Connection connection = getConnection(req.getServletContext())) {
            TaskDB db = new TaskDB(connection);
            Task5Service service = new Task5Service(db);

            req.setAttribute("tasks", service.getOrderedTask5());
            req.getRequestDispatcher("task5.jsp").forward(req, resp);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

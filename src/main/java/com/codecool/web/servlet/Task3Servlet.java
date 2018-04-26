package com.codecool.web.servlet;

import com.codecool.web.dao.TaskDB;
import com.codecool.web.service.Task3Service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/Task3Servlet")
public class Task3Servlet extends AbstractServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try (Connection connection = getConnection(req.getServletContext())) {
            TaskDB db = new TaskDB(connection);
            Task3Service service = new Task3Service(db);

            req.setAttribute("tasks", service.getUnorderedTask3());
            req.getRequestDispatcher("task3.jsp").forward(req, resp);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection connection = getConnection(req.getServletContext())) {
            TaskDB db = new TaskDB(connection);
            Task3Service service = new Task3Service(db);

            req.setAttribute("tasks", service.getOrderedTask3());
            req.getRequestDispatcher("task3.jsp").forward(req, resp);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

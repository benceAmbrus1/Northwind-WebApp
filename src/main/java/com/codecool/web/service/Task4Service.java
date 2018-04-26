package com.codecool.web.service;

import com.codecool.web.dao.TaskDB;
import com.codecool.web.model.Task4;

import java.sql.SQLException;
import java.util.List;

public class Task4Service extends AbstractService{

    public Task4Service(TaskDB db) {
        super(db);
    }

    public List<Task4> getUnorderedTask4() throws SQLException {
        String sql = "SELECT companyname, ARRAY_AGG(orderid) AS orders FROM customers\n" +
            "JOIN orders\n" +
            "ON customers.customerid = orders.customerid\n" +
            "GROUP BY companyname";

        List<Task4> tasks = db.getTask4s(sql);
        return tasks;
    }

    public List<Task4> getOrderedTask4() throws SQLException{
        String sql = "SELECT companyname, ARRAY_AGG(orderid) AS orders FROM customers\n" +
            "JOIN orders\n" +
            "ON customers.customerid = orders.customerid\n" +
            "GROUP BY companyname\n" +
            "ORDER BY companyname ASC;";

        List<Task4> tasks = db.getTask4s(sql);
        return tasks;
    }
}

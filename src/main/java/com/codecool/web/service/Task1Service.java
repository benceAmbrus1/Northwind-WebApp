package com.codecool.web.service;

import com.codecool.web.dao.TaskDB;
import com.codecool.web.model.Task1;

import java.sql.SQLException;
import java.util.List;

public class Task1Service extends AbstractService {

    public Task1Service(TaskDB db) {
        super(db);
    }

    public List<Task1> getUnorderedTask1() throws SQLException{
        String sql = "SELECT productname as Product, companyname as Company FROM products\n" +
            "INNER JOIN suppliers\n" +
            "ON products.productid = suppliers.supplierid\n" +
            "ORDER BY productname ASC";

        List<Task1> tasks = db.getTasks(sql);
        return tasks;
    }

    public List<Task1> getOrderedTask1() throws SQLException{
        String sql = "SELECT productname as Product, companyname as Company FROM products\n" +
            "INNER JOIN suppliers\n" +
            "ON products.productid = suppliers.supplierid\n" +
            "ORDER BY companyname ASC,\n" +
            " productname ASC;";

        List<Task1> tasks = db.getTasks(sql);
        return tasks;
    }
}

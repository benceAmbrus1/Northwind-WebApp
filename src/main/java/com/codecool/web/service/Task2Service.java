package com.codecool.web.service;

import com.codecool.web.dao.TaskDB;
import com.codecool.web.model.Task2;

import java.sql.SQLException;
import java.util.List;

public class Task2Service extends AbstractService {

    public Task2Service(TaskDB db) {
        super(db);
    }

    public List<Task2> getUnorderedTask2() throws SQLException {
        String sql = "SELECT companyname as Company, COUNT(suppliers.supplierid) as number_of_product FROM suppliers\n" +
            "INNER JOIN products\n" +
            "ON suppliers.supplierid = products.supplierid\n" +
            "GROUP BY Company\n" +
            "ORDER BY number_of_product DESC";

        List<Task2> tasks = db.getTask2s(sql);
        return tasks;
    }

    public List<Task2> getOrderedTask2() throws SQLException{
        String sql = "SELECT companyname as Company, COUNT(suppliers.supplierid) as number_of_product FROM suppliers\n" +
            "INNER JOIN products\n" +
            "ON suppliers.supplierid = products.supplierid\n" +
            "GROUP BY Company\n" +
            "ORDER BY Company ASC ,number_of_product DESC";

        List<Task2> tasks = db.getTask2s(sql);
        return tasks;
    }
}

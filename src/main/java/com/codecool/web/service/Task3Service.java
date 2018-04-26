package com.codecool.web.service;

import com.codecool.web.dao.TaskDB;
import com.codecool.web.model.Task3;

import java.sql.SQLException;
import java.util.List;

public class Task3Service extends AbstractService {

    public Task3Service(TaskDB db) {
        super(db);
    }

    public List<Task3> getUnorderedTask3() throws SQLException {
        String sql = "SELECT companyname as Company FROM suppliers\n" +
            "INNER JOIN products\n" +
            "ON suppliers.supplierid = products.supplierid\n" +
            "GROUP BY Company\n" +
            "HAVING COUNT(suppliers.companyname) > 4";

        List<Task3> tasks = db.getTask3s(sql);
        return tasks;
    }

    public List<Task3> getOrderedTask3() throws SQLException{
        String sql = "SELECT companyname as Company FROM suppliers\n" +
            "INNER JOIN products\n" +
            "ON suppliers.supplierid = products.supplierid\n" +
            "GROUP BY Company\n" +
            "HAVING COUNT(suppliers.companyname) > 4\n" +
            "ORDER BY Company ASC;";

        List<Task3> tasks = db.getTask3s(sql);
        return tasks;
    }
}

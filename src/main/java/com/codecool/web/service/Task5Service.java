package com.codecool.web.service;

import com.codecool.web.dao.TaskDB;
import com.codecool.web.model.Task5;

import java.sql.SQLException;
import java.util.List;

public class Task5Service extends AbstractService{

    public Task5Service(TaskDB db) {
        super(db);
    }

    public List<Task5> getUnorderedTask5() throws SQLException {
        String sql = "SELECT q.companyname, t.productname, t.unitprice\n" +
            "FROM products t\n" +
            "RIGHT OUTER JOIN (SELECT companyname, suppliers.supplierid, MAX(unitprice) as Price FROM suppliers\n" +
            "\t JOIN products\n" +
            "\t ON suppliers.supplierid = products.supplierid\n" +
            "\t GROUP BY companyname, suppliers.supplierid) q\n" +
            "ON t.supplierid = q.supplierid AND t.unitprice >= q.Price\n" +
            "GROUP BY q.companyname , t.productname, t.unitprice\n";

        List<Task5> tasks = db.getTask5s(sql);
        return tasks;
    }

    public List<Task5> getOrderedTask5() throws SQLException{
        String sql = "SELECT q.companyname, t.productname, t.unitprice\n" +
            "FROM products t\n" +
            "RIGHT OUTER JOIN (SELECT companyname, suppliers.supplierid, MAX(unitprice) as Price FROM suppliers\n" +
            "\t JOIN products\n" +
            "\t ON suppliers.supplierid = products.supplierid\n" +
            "\t GROUP BY companyname, suppliers.supplierid) q\n" +
            "ON t.supplierid = q.supplierid AND t.unitprice >= q.Price\n" +
            "GROUP BY q.companyname , t.productname, t.unitprice\n" +
            "ORDER BY q.companyname ASC";

        List<Task5> tasks = db.getTask5s(sql);
        return tasks;
    }
}

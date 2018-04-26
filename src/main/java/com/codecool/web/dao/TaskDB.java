package com.codecool.web.dao;


import com.codecool.web.model.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TaskDB {

    private Connection connection;

    public TaskDB(Connection connection) {
        this.connection = connection;
    }


    //Task1
    public List<Task1> getTasks(String sql) throws SQLException {

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            List<Task1> tempTasks = new ArrayList<>();
            while (resultSet.next()) {
                tempTasks.add(creatTask1(resultSet));
            }
            return tempTasks;
        }
    }
    private Task1 creatTask1(ResultSet resultSet) throws SQLException {
        String company = resultSet.getString("Company");
        String product = resultSet.getString("Product");

        return new Task1(company, product);
    }
    //Task1

    //Task2
    public List<Task2> getTask2s(String sql) throws SQLException {

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            List<Task2> tempTasks = new ArrayList<>();
            while (resultSet.next()) {
                tempTasks.add(creatTask2(resultSet));
            }
            return tempTasks;
        }
    }
    private Task2 creatTask2(ResultSet resultSet) throws SQLException {
        String company = resultSet.getString("Company");
        int product = resultSet.getInt("number_of_product");

        return new Task2(company, product);
    }
    //Task2

    //Task3
    public List<Task3> getTask3s(String sql) throws SQLException {

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            List<Task3> tempTasks = new ArrayList<>();
            while (resultSet.next()) {
                tempTasks.add(creatTask3(resultSet));
            }
            return tempTasks;
        }
    }
    private Task3 creatTask3(ResultSet resultSet) throws SQLException {
        String company = resultSet.getString("Company");

        return new Task3(company);
    }
    //Task3

    //Task4
    public List<Task4> getTask4s(String sql) throws SQLException {

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            List<Task4> tempTasks = new ArrayList<>();
            while (resultSet.next()) {
                tempTasks.add(creatTask4(resultSet));
            }
            return tempTasks;
        }
    }
    private Task4 creatTask4(ResultSet resultSet) throws SQLException {
        String company = resultSet.getString("companyname");
        Array or = resultSet.getArray("orders");
        Short[] orders = (Short[]) or.getArray();

        return new Task4(company, orders);
    }
    //Task4

    //Task5
    public List<Task5> getTask5s(String sql) throws SQLException {

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            List<Task5> tempTasks = new ArrayList<>();
            while (resultSet.next()) {
                tempTasks.add(creatTask5(resultSet));
            }
            return tempTasks;
        }
    }
    private Task5 creatTask5(ResultSet resultSet) throws SQLException {
        String company = resultSet.getString("companyname");
        String productname = resultSet.getString("productname");
        int unitprice = resultSet.getInt("unitprice");

        return new Task5(company, productname, unitprice);
    }
    //Task5
}

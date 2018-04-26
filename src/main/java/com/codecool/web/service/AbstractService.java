package com.codecool.web.service;

import com.codecool.web.dao.TaskDB;

public class AbstractService {

    protected TaskDB db;

    public AbstractService(TaskDB db) {
        this.db = db;
    }
}

package com.yao.xredis.command;

import com.yao.xredis.bio.Connection;

import java.io.IOException;

/**
 * Created by yao on 15/8/27.
 */
public abstract class Command {

    private String name;

    private ComandEnum type;

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    private Connection connection;

    public abstract Result send(String ... args) throws IOException;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ComandEnum getType() {
        return type;
    }

    public void setType(ComandEnum type) {
        this.type = type;
    }
}

package com.epam.hud.dao.db;

import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionPool {
    private String driver = "com.mysql.jdbc.Driver";
    private String jdbcurl = "jdbc:mysql://localhost:3306/anime?useSSL=false&characterEncoding=utf-8";
    private String jdbclogin = "root";
    private String jdbcpassword = "root";

    private ConnectionPool() {
    }

    private static volatile ConnectionPool instance;

    public static ConnectionPool getInstance() {
        ConnectionPool connectionPool = instance;
        if (connectionPool == null) {
            synchronized (ConnectionPool.class) {
                connectionPool = instance;
                if (connectionPool == null) {
                    instance = connectionPool = new ConnectionPool();
                }
            }
        }
        return connectionPool;
    }

    public Connection getConnection() {
        Connection connection = null;
        try {
            MysqlDataSource dataSource = new MysqlDataSource();
            dataSource.setURL(jdbcurl);
            dataSource.setUser(jdbclogin);
            dataSource.setPassword(jdbcpassword);
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return connection;
    }
}
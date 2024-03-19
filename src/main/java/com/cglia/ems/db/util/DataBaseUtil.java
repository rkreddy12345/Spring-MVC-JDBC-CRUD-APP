package com.cglia.ems.db.util;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;

public class DataBaseUtil {
    private static BasicDataSource dataSource;

    static {
        dataSource = new BasicDataSource();
        dataSource.setDriverClassName("net.sourceforge.jtds.jdbc.Driver");
        dataSource.setUrl("jdbc:jtds:sqlserver:/192.168.1.98:1433;DatabaseName=EP2_MSSQL_INTG_DEV_102;SelectMethod=cursor");
        dataSource.setUsername("acinikalgn");
        dataSource.setPassword("acinikapwd");
    }

    public static Connection getConnection() throws SQLException {
        Connection connection = dataSource.getConnection();
        return connection;
    }
}

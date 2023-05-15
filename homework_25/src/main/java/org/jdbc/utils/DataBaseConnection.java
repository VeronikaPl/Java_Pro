package org.jdbc.utils;

import org.jdbc.exceptions.JdbcOperationException;
import org.postgresql.ds.PGSimpleDataSource;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class DataBaseConnection {
    private static final String DB_PROPS = "db.properties";
    private static final String DB_URL = "db.url";
    private static final String DB_USERNAME = "db.username";
    private static final String DB_PASSWORD = "db.password";


    private static Properties loadProperties() {
        try (InputStream is = DataBaseConnection.class.getClassLoader().getResourceAsStream(DB_PROPS)) {
            Properties dbProperties = new Properties();
            dbProperties.load(is);
            return dbProperties;
        } catch (IOException e) {
            throw new JdbcOperationException("DataBase properties can`t be loaded");
        }
    }

    public static DataSource initDataSource() {
        Properties props = loadProperties();
        PGSimpleDataSource dataSource = new PGSimpleDataSource();
        dataSource.setURL(props.getProperty(DB_URL));
        dataSource.setUser(props.getProperty(DB_USERNAME));
        dataSource.setPassword(props.getProperty(DB_PASSWORD));
        return dataSource;
    }
}

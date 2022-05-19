package com.mytests.spring.jpa.springjpaqueries.services;

import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.jdbc.support.SQLExceptionSubclassTranslator;
import org.springframework.jdbc.support.SQLExceptionTranslator;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;

/**
 * *
 * <p>Created by irina on 5/18/2022.</p>
 * <p>Project: spring-jpa-queries</p>
 * *
 */
@Service
public class SQLExceptionTranslatorTest {


    private final SQLExceptionTranslator sqlExceptionTranslator = new SQLExceptionSubclassTranslator();

    public void demo(DataSource dataSource){
        Connection connection = DataSourceUtils.getConnection(dataSource);
        try {
            Statement statement = connection.createStatement();
            statement.execute("select * from sample where id > 100");
        } catch (final SQLException e) {
            throw Objects.requireNonNull(sqlExceptionTranslator.translate("Correct your query, it is invalid!!!",
                                                                               "select * from sample where id > 100", e));
        }
    }
}

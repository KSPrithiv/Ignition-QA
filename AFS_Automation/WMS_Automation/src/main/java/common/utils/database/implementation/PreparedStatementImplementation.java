package common.utils.database.implementation;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.sql.*;

@Slf4j
public class PreparedStatementImplementation {

    private PreparedStatement prepareStatement;

    public PreparedStatement getPreparedStatement() {
        return prepareStatement;
    }

    public PreparedStatementImplementation(PreparedStatement preparedStatement) {
        this.prepareStatement = preparedStatement;
    }

    @SneakyThrows
    public void prepareStatement(Connection connection, String sql) {
        log.info("Preparing statement " + sql);
        connection.prepareStatement(sql);
    }

    @SneakyThrows
    public ResultSet executeQuery() {
        log.info("Executing PreparedStatement query");
        ResultSet resultSet = prepareStatement.executeQuery();
        if(resultSet.next()) {
           return resultSet;
        } else {
            throw new SQLDataException("No data in DB is found");
        }
    }

 }

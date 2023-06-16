package common.utils.database.implementation;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import java.sql.*;

@Slf4j
public class CallableStatementImplementation {

    private CallableStatement callableStatement = null;

    public CallableStatement getCallableStatement() {
        return callableStatement;
    }

    public CallableStatementImplementation() {

    }

    public CallableStatementImplementation(CallableStatement callableStatement) {
        this.callableStatement = callableStatement;
    }

    @SneakyThrows
    public ResultSet executeQuery() {
        log.info("Executing callable statement");
        ResultSet resultSet = callableStatement.executeQuery();
        if(resultSet.next()) {
            return resultSet;
        } else {
            throw new SQLDataException("No data in DB is found, Store Procedure is " + callableStatement);
        }
    }

}

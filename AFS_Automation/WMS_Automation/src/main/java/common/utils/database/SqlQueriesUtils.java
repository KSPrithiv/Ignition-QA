package common.utils.database;

import common.utils.database.implementation.PreparedStatementImplementation;
import lombok.SneakyThrows;
import java.sql.Connection;
import java.sql.ResultSet;

public class SqlQueriesUtils {

    PreparedStatementImplementation preparedStatementImplementation;

    @SneakyThrows
    public ResultSet getCurrentValidUser(Connection connection, String programName) {
        String sql = "select * from [WMS_Ital].[dbo].[currentusers] where PROGRAM_NAME= ? order by CURRENTUSER_ID desc";
        preparedStatementImplementation = new PreparedStatementImplementation(connection.prepareStatement(sql));
        preparedStatementImplementation.prepareStatement(connection, sql);
        preparedStatementImplementation.getPreparedStatement().setString(1, programName);
        return preparedStatementImplementation.executeQuery();
    }
}

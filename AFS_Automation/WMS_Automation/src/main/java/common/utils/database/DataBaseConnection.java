package common.utils.database;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import objects.userdata.DataBaseData;

import java.sql.*;

@Slf4j
public class DataBaseConnection {
    private static Connection connection;
    /**
     *
     * @param dataBaseData
     * @return
     */

    @SneakyThrows
    public static Connection getDataBaseConnection(DataBaseData dataBaseData) {
        /**
         * Get single connection to DB
         */
        if (connection == null) {
            log.info("Connecting to DB " + dataBaseData.getHost());
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            // Constant for Database URL
            String dbURL = "jdbc:sqlserver://" + dataBaseData.getHost() + ";database=" + dataBaseData.getSchema() +
                    ";instance=SQLSERVER;encrypt=true;TrustServerCertificate=true;";
            connection = DriverManager.getConnection(dbURL, dataBaseData.getUsername(), dataBaseData.getPassword());
        }
        return connection;
    }

    /**
     * Close connection to DB
     */

    @SneakyThrows
    public static void closeDataBaseConnection() {
        log.info("Closing Connection to DB");
        connection.close();
    }
}

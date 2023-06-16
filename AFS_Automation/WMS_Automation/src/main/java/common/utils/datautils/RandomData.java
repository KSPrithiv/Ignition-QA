package common.utils.datautils;

import lombok.SneakyThrows;

import java.sql.ResultSet;
import java.util.Random;

public class RandomData {

    @SneakyThrows
    public static ResultSet getRandomResultSetRow(ResultSet resultSet, int num) {
        do {
            resultSet.next();
            num--;
        } while(num > 0);

        return resultSet;
    }

    public static int getRandomNumber(int min, int max) {
        return new Random().ints(min, max)
                .findFirst()
                .getAsInt();
    }
}

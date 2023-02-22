package util;

import org.apache.commons.lang3.RandomStringUtils;

import java.security.SecureRandom;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @Project Krupa@2000
 * @Author Divya.Ramadas@afsi.com
 */
public class RandomValues
{
    /* Created by Divya.Ramadas@afsi.com */
    static char[] SYMBOLS = "$*.!@#%_".toCharArray();
    static char[] LOWERCASE = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    static char[] UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    static char[] NUMBERS = "0123456789".toCharArray();
    static char[] ALL_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789^$*.[]{}()?-\"!@#%&/\\,><':;|_~`".toCharArray();
    static Random rand = new SecureRandom();

    //Generate some random value which includes only alphabets
    public static String generateRandomString(int length)
    {
        return RandomStringUtils.randomAlphabetic(length);
    }

    //Generate some random value which includes only random numbers
    public static String generateRandomNumber(int length)
    {
        return RandomStringUtils.randomNumeric(length);
    }

    //Generate some random value which includes alphabets and numbers
    public static String generateRandomAlphaNumeric(int length)
    {
        return RandomStringUtils.randomAlphanumeric(length);
    }

    //To generate password randomly
    public static String generateStringWithAllobedSplChars(int length)
    {
        assert length >= 5;
        char[] password = new char[length];

        //get the requirements out of the way
        password[0] = LOWERCASE[rand.nextInt(LOWERCASE.length)];
        password[1] = UPPERCASE[rand.nextInt(UPPERCASE.length)];
        password[2] = NUMBERS[rand.nextInt(NUMBERS.length)];
        password[3] = SYMBOLS[rand.nextInt(SYMBOLS.length)];

        //populate rest of the password with random chars
        for (int i = 4; i < length; i++)
        {
            password[i] = ALL_CHARS[rand.nextInt(ALL_CHARS.length)];
        }
        //shuffle it up
        for (int i = 0; i < password.length; i++)
        {
            int randomPosition = rand.nextInt(password.length);
            char temp = password[i];
            password[i] = password[randomPosition];
            password[randomPosition] = temp;
        }
        return new String(password);
    }

    //To generate the mail id randomly
    public static String generateEmail(int length)
    {
        String allowedChars="abcdefghijklmnopqrstuvwxyz" + "1234567890";

        String email="";
        String temp= RandomStringUtils.random(length,allowedChars);
        email=temp.substring(0,temp.length()-9)+"@gmail.com";
        return email;
    }

    //Get week day value randomly
    public static <T> T getRandomElement(T[] arr)
    {
        return arr[ThreadLocalRandom.current().nextInt(arr.length)];
    }

    public static String getWeekday()
    {
        //Example Usage:
        String[] strs = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
        String randStr = getRandomElement(strs);
        return randStr;
    }

    //Random month and year
    public static LocalDateTime RandomMonthYear(int MinLimit, int MaxLimit)
    {
       LocalDateTime randomDate = null;
       randomDate = createRandomMonthYear(MinLimit, MaxLimit);
      return randomDate;
    }

        public static int createRandomIntBetween(int start, int end)
        {
            return start + (int) Math.round(Math.random() * (end - start));
        }

        public static LocalDateTime createRandomMonthYear(int startYear, int endYear)
        {
            String monthYear;
            LocalDate monthYear1;
            int month = createRandomIntBetween(1, 12);
            int year = createRandomIntBetween(startYear, endYear);
            /*monthYear1= LocalDate.of(year, month,1);
            monthYear= monthYear1.format(DateTimeFormatter.ofPattern("mm/yy"));
            return monthYear;*/
            //default time pattern
            String time = year+"-"+month+"-"+1;
            LocalDateTime localTimeObj = LocalDateTime.parse(time);

            //specific date time pattern
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("mm/yy");
            LocalDateTime localTimeObj1 = LocalDateTime.parse(time, formatter);
            return localTimeObj1;
        }

}

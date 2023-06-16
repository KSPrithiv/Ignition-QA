package common.setup;

import common.constants.FilePaths;
import org.testng.annotations.BeforeMethod;

import java.io.*;
import java.util.Optional;
import java.util.Properties;

public class EnvironmentSetup {

    private static String browser;
    private static String runtype;
    private static String username;
    private static String password;
    private static String url;
    private static Properties properties = new Properties();
    InputStream stream = null;

    private void getSetupParameters() {
       File configFile = new File(FilePaths.CONFIG_DATA);
         try {
           stream = new FileInputStream(configFile);
           properties.load(stream);
         } catch (IOException e) {
           e.printStackTrace();
         }
       browser = Optional.ofNullable(properties.getProperty("browser")).orElseThrow(() ->
               new IllegalArgumentException("Cant find property browser" ));
       username = Optional.ofNullable(properties.getProperty("username")).orElseThrow(() ->
                new IllegalArgumentException("Cant find property username" ));
       password = Optional.ofNullable(properties.getProperty("password")).orElseThrow(() ->
                new IllegalArgumentException("Cant find property password" ));
       password = Optional.ofNullable(properties.getProperty("password")).orElseThrow(() ->
                new IllegalArgumentException("Cant find property password" ));
       url = Optional.ofNullable(properties.getProperty("url")).orElseThrow(() ->
                new IllegalArgumentException("Cant find property url" ));
        getSystemParameters();
    }

    private void getSystemParameters() {
       browser = System.getProperty("browser") != null ? System.getProperty("browser") : properties.getProperty("browser");
       username = System.getProperty("username") != null ? System.getProperty("username") : properties.getProperty("username");
       password = System.getProperty("password") != null ? System.getProperty("password") : properties.getProperty("password");
       url = System.getProperty("url") != null ? System.getProperty("url") : properties.getProperty("url");
    }

    public void setUpEnvironmentData() {
        getSetupParameters();
        getSystemParameters();
    }

    public static String getBrowser() { return browser; }

    public static String getRuntype() {
        return runtype;
    }

    public static String getUsername() {
        return username;
    }

    public static String getPassword() {
        return password;
    }

    public static String getUrl() {
        return url;
    }
}

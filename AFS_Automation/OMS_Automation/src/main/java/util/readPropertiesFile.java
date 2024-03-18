package util;

import org.aeonbits.owner.ConfigFactory;

/**
 * @Project Divya.Ramadas@telusagcg.com
 * @Author Divya.Ramadas
 */
public class readPropertiesFile
{
    /* Created by Divya.Ramadas */
    public static Environment testEnvironment;
    // public static MenuValues testMenuValues;

    public static Environment InitializeProp(String envi/*,String menu*/) throws InterruptedException
    {
        try
        {
                    ConfigFactory.setProperty("env", envi);
                    // ConfigFactory.setProperty("menu",menu);
                    testEnvironment = ConfigFactory.create(Environment.class);
                    // testMenuValues = ConfigFactory.create(MenuValues.class);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return testEnvironment;
    }
    private readPropertiesFile(){}
}

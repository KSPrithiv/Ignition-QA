package util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Project DSD_OMS
 * @Author Divya.Ramadas@afsi.com
 */
public class DataBaseConnection
{
    /* Created by Divya.Ramadas@afsi.com */
    public static String DataBaseConn(String sql) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException
    {
        // Constant for Database URL
        String DB_URL = "jdbc:sqlserver://"+TestBase.testEnvironment.getIP_Add()+";database="+TestBase.testEnvironment.getDBname()+";instance=SQLSERVER;encrypt=true;TrustServerCertificate=true;";

        Connection conn=null;
        List allRows=null;
        ResultSet rs=null;
        String[] currentRow=null;
        String valu=null;
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            conn = DriverManager.getConnection(DB_URL,TestBase.testEnvironment.getDBUser(),TestBase.testEnvironment.getDBPassword());

            Statement st = conn.createStatement();
            rs= st.executeQuery(sql);
            while(rs.next())
            {
                allRows = new ArrayList();
                    currentRow = new String[rs.getMetaData().getColumnCount()];
                    for(int i = 1;i<=rs.getMetaData().getColumnCount();i++)
                    {
                       currentRow[i-1]=rs.getString(i);
                    }
                    allRows.add(currentRow);
                  valu=rs.getString(TestBase.testEnvironment.get_DBColumn());
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (conn != null)
            {
                conn.close();
            }
        }
       return valu;
    }

    //returns list of values from database
    public static List<String> DataConn1(String sql) throws SQLException
    {
        // Constant for Database URL
        String DB_URL = "jdbc:sqlserver://"+TestBase.testEnvironment.getIP_Add()+";database="+TestBase.testEnvironment.getDBname()+";instance=SQLSERVER;encrypt=true;TrustServerCertificate=true;";

        Connection conn=null;
        List allRows = new ArrayList<>();
        ResultSet rs=null;
        String[] currentRow=null;
        ArrayList<String> Pro_No=new ArrayList<>();

        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            conn = DriverManager.getConnection(DB_URL,TestBase.testEnvironment.getDBUser(),TestBase.testEnvironment.getDBPassword());

            Statement st = conn.createStatement();
            rs= st.executeQuery(sql);
            while(rs.next())
            {
                currentRow = new String[rs.getMetaData().getColumnCount()];
                for(int i = 1;i<=rs.getMetaData().getColumnCount();i++)
                {
                    currentRow[i-1]=rs.getString(i);
                }

                Pro_No.add(rs.getString(TestBase.testEnvironment.get_DBColumn()));
                allRows.add(currentRow);
            }
           // rs.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (conn != null)
            {
                conn.close();
            }
        }
        //return allRows;
        return Pro_No;
    }
}

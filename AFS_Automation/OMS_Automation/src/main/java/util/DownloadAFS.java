package util;

import org.aeonbits.owner.ConfigFactory;
import org.apache.commons.io.filefilter.WildcardFileFilter;
import util.TestBase;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import java.io.*;
import java.util.Properties;
import util.TestBase.*;
import util.Environment;
import util.*;
import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;
import util.TestBase;




@Sources({"classpath:${env}.properties"})

//====sendMail
//C:\Users\karthikeyan.Armugam\Documents\Git_Repositories\ignition-qa\IgnitionQAAutomation\src\main\resources\config_DSD_OMS\shared_config_DSD.properties

public class DownloadAFS {


    public static void main(String args[]) throws MessagingException {
        download_file();
        sendMail();
    }
        private static void download_file() {
            File dir = new File("C:\\Users\\karthikeyan.Armugam\\Documents\\Backup\\Apr-13  Backup\\ignition-qa - without git\\IgnitionQAAutomation\\Reports\\spark");
            FileFilter fileFilter = new WildcardFileFilter("*.html");
            File[] files = dir.listFiles(fileFilter);
            String file2 = null;


            for (File Exportfile : files) {
                String file1 = Exportfile.getName();
                System.out.println("File downloaded for loop");
                if (file1.contains("Index")) {
                    String ExportOG = file1;
                    System.out.println(ExportOG);
                    break;
                }
            }
        }

        //FileReader reader = new FileReader("C:\\Users\\karthikeyan.Armugam\\Documents\\Git_Repositories\\ignition-qa\\IgnitionQAAutomation\\src\\main\\resources\\config_DSD_OMS\\shared_config_DSD.properties");



    public static void sendMail() throws MessagingException
    {
        try
        {
            Properties properties = new Properties();
            properties.put("mail.smtp.auth", "true");
            properties.put("mail.smtp.starttls.enable", "true");
            properties.put("mail.smtp.host", "smtp.gmail.com");
            properties.put("mail.smtp.port", "587");

            Session session = Session.getInstance(properties, new Authenticator()
            {
                @Override
                protected PasswordAuthentication getPasswordAuthentication()
                {
                    return new PasswordAuthentication(TestBase.testEnvironment.From_mail(),TestBase.testEnvironment.From_pMail());
                }
            });
            Message message=prepareMessage(session,TestBase.testEnvironment.From_mail(),TestBase.testEnvironment.To_mail());
            Transport.send(message);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }

    private static Message prepareMessage(Session session, String myAccountEmail, String recepient)
    {
        try
        {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject("Ignition test report ");

            //String filename="corp.afsi.com\\C:\\Users\\karthikeyan.Armugam\\Documents\\Git_Repositories\\ignition-qa\\IgnitionQAAutomation\\Reports\\extent\\Index.html";
            String filename="C:\\Users\\karthikeyan.Armugam\\Documents\\Git_Repositories\\ignition-qa\\IgnitionQAAutomation\\Reports\\extent\\Index.html";

            //Composing mail
            BodyPart objMessageBodyPart = new MimeBodyPart();
            objMessageBodyPart.setContent("Hi,"+"<br><h1>Hi Santhosh, Good Morning..This is a test mail </h1></br>"+"\n"+TestBase.testEnvironment.get_url(), "text/html");
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(objMessageBodyPart);
            objMessageBodyPart = new MimeBodyPart();
            DataSource source = new FileDataSource(filename);
            objMessageBodyPart.setDataHandler(new DataHandler(source));
            //attaching extent report to mail
            objMessageBodyPart.setFileName(filename);
            multipart.addBodyPart(objMessageBodyPart);
            message.setContent(multipart);
            return message;
        }
        catch (AddressException ex)
        {
            System.out.println(ex);
        }
        catch (MessagingException e)
        {
            e.printStackTrace();
        }
        return null;
    }
}




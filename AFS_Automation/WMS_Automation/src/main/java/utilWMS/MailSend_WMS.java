package utilWMS;

/**
 * @Project DSD_ERP
 * @Author Divya.Ramadas
 */

import util.TestBase;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

/**
 * @Project AFS-DSD and OMSi
 * @Author Divya.Ramadas@afsi.com
 */
public class MailSend_WMS
{

    /* Created By Divya.Ramadas@afsi.com*/
    public static void sendMail() throws MessagingException
    {
        final String password = "rkev leoi veno keod";
        final String from = "automationqaafs@gmail.com";
        final String to = "santhosh.skaria@telusagcg.com";

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
                    return new PasswordAuthentication("automationqaafs@gmail.com", "rkev leoi veno keod");
                }
            });
            Message message=prepareMessage(session, "automationqaafs@gmail.com", "santhosh.skaria@telusagcg.com");
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
            message.setSubject("Automated Email Notification -Ignition AUtomation report from CI server");

            //String filename="corp.afsi.com\\C:\\Users\\karthikeyan.Armugam\\Documents\\Git_Repositories\\ignition-qa\\IgnitionQAAutomation\\Reports\\extent\\Index.html";
            //String filename="C:\\Users\\karthikeyan.Armugam\\Documents\\Git_Repositories\\ignition-qa\\IgnitionQAAutomation\\Reports\\extent\\Index.html";
            //String filename="C:\\Users\\karthikeyan.Armugam\\Documents\\AFS_Automation\\AFS_Automation\\WMS_Automation\\target\\cucumber-reports\\cucumber.html";
            String filename="E:\\GithubBuilds\\IgnitionQA\\_work\\ignition-qa\\ignition-qa\\AFS_Automation\\WMS_Automation\\target\\surefire-reports\\emailable-report.html";
            //Composing mail
            BodyPart objMessageBodyPart = new MimeBodyPart();
            objMessageBodyPart.setContent("Hi,"+"Santhosh, Good Afternoon..Please find attached the Ignition WMS Automation Report"+"\n", "text/html");
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


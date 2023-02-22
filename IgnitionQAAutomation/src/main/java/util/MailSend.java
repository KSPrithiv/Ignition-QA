package util;

/**
 * @Project DSD_ERP
 * @Author Divya.Ramadas
 */
import io.cucumber.java.eo.Se;
import org.aeonbits.owner.ConfigFactory;

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
public class MailSend
{

    /* Created By Divya.Ramadas@afsi.com*/
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
                    return new PasswordAuthentication(TestBase.testEnvironment.From_mail(),TestBase.testEnvironment.From_Pass());
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
            message.setSubject("Automation framework test report");
            //String filename = "C:\\Users\\Divya.Ramadas\\Downloads\\IgnitionTestAutomation\\Reports\\spark\\index.html";
            String filename="D:\\Divya.Ramadas\\IgnitionTestAutomation\\Reports\\extent\\Index.html";

            //Composing mail
            BodyPart objMessageBodyPart = new MimeBodyPart();
            objMessageBodyPart.setContent("Hi,"+"<br><h1>Mail from Automation framework!</h1></br>"+"\n"+TestBase.testEnvironment.get_url(), "text/html");
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


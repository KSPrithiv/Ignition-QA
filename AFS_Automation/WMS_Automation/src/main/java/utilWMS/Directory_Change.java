package utilWMS;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Directory_Change {
    public static void main(String[] args) throws IOException {
    }

        public static void uniqueReport() throws IOException {
            //Time
            Date now = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("hh mm ss");
            String time = dateFormat.format(now);
            File f = new File("C:\\Users\\karthikeyan.Armugam\\Documents\\Git_Repositories\\ignition-qa\\AFS_Automation\\WMS_Automation\\Reports\\surefire-reports_WMS" + "_" + time);
            //notused//  Path targetDirectory = Paths.get("C:\\Users\\karthikeyan.Armugam\\Documents\\Git_Repositories\\ignition-qa\\AFS_Automation\\WMS_Automation\\Reports\\surefire-reports_WMS\\emailable-report.html" + "_" + time+".html");
            f.mkdirs();
            boolean wasSuccessful = f.mkdirs();
            if (!wasSuccessful) {
                System.out.println("was not successful.");
            }

            //Time
            DateTime now1 = DateTime.now( DateTimeZone.getDefault() );
            DateTimeFormatter formatter = ISODateTimeFormat.dateHourMinuteSecond();  // Or dateHourMinute();
            String output = formatter.print( now1 ).replace( ":" , "-" );

            //folder
            Path sourceDirectory = Paths.get("C:\\Users\\karthikeyan.Armugam\\Documents\\Git_Repositories\\ignition-qa\\AFS_Automation\\WMS_Automation\\target\\surefire-reports\\emailable-report.html");
            //Path targetDirectory = Paths.get("C:\\Users\\karthikeyan.Armugam\\Documents\\Git_Repositories\\ignition-qa\\AFS_Automation\\WMS_Automation\\Reports\\surefire-reports_WMS\\emailable-report.html" + "_" + time+".html");
            Path targetDirectory1 = Paths.get("C:\\Users\\karthikeyan.Armugam\\Documents\\Git_Repositories\\ignition-qa\\AFS_Automation\\WMS_Automation\\Reports\\surefire-reports_WMS\\emailable-report" + "_" + output +".html");

            //copy source to target using Files Class
            Files.copy(sourceDirectory, targetDirectory1);
        }
    }


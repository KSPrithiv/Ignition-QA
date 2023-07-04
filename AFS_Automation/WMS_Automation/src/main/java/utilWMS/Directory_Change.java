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


    public static void uniqueReport() throws IOException {
        //Time
//            Date now = new Date();
//            SimpleDateFormat dateFormat = new SimpleDateFormat("hh mm ss");
//            String time = dateFormat.format(now);
//            File f = new File("C:\\Users\\karthikeyan.Armugam\\Documents\\Git_Repositories\\ignition-qa\\AFS_Automation\\WMS_Automation\\Reports\\surefire-reports_WMS" + "_" + time);
//            //notused//  Path targetDirectory = Paths.get("C:\\Users\\karthikeyan.Armugam\\Documents\\Git_Repositories\\ignition-qa\\AFS_Automation\\WMS_Automation\\Reports\\surefire-reports_WMS\\emailable-report.html" + "_" + time+".html");
//            f.mkdirs();
//            boolean wasSuccessful = f.mkdirs();
//            if (!wasSuccessful) {
//                System.out.println("was not successful.");
//            }

        //Time
        DateTime now_cucu = DateTime.now( DateTimeZone.getDefault() );
        DateTimeFormatter formatter = ISODateTimeFormat.dateHourMinuteSecond();  // Or dateHourMinute();
        String output = formatter.print( now_cucu ).replace( ":" , "-" );


        //folder date &  Time -Cucumber report
        Path sourceDirectory_cucu = Paths.get("E:\\GithubBuilds\\IgnitionQA\\_work\\ignition-qa\\ignition-qa\\AFS_Automation\\WMS_Automation\\target\\cucumber-reports\\cucumber.html");

        Path targetDirectory1_cucu = Paths.get("E:\\GithubBuilds\\IgnitionQA\\_work\\ignition-qa\\ignition-qa\\AFS_Automation\\WMS_Automation\\Reports\\Cucumber-Reports\\cucumber"+ "_" + output +".html");

        //copy source to target using Files Class
        Files.copy(sourceDirectory_cucu, targetDirectory1_cucu);

        //Time
        DateTime now1 = DateTime.now( DateTimeZone.getDefault() );
        DateTimeFormatter formatter2 = ISODateTimeFormat.dateHourMinuteSecond();  // Or dateHourMinute();
        String output2 = formatter2.print( now1 ).replace( ":" , "-" );

        //folder -surefire report
        Path sourceDirectory = Paths.get("E:\\GithubBuilds\\IgnitionQA\\_work\\ignition-qa\\ignition-qa\\AFS_Automation\\WMS_Automation\\target\\surefire-reports\\emailable-report.html");
        //Path targetDirectory = Paths.get("C:\\Users\\karthikeyan.Armugam\\Documents\\Git_Repositories\\ignition-qa\\AFS_Automation\\WMS_Automation\\Reports\\surefire-reports_WMS\\emailable-report.html" + "_" + time+".html");
        Path targetDirectory1 = Paths.get("E:\\GithubBuilds\\IgnitionQA\\_work\\ignition-qa\\ignition-qa\\AFS_Automation\\WMS_Automation\\Reports\\surefire-reports_WMS\\emailable-report" + "_" + output2 +".html");

        //copy source to target using Files Class
        Files.copy(sourceDirectory, targetDirectory1);

//=========================================================================

    }
}
package runners;

import common.constants.FilePaths;
import common.setup.DriverManager;
import common.setup.Environment;
import common.utils.Waiters;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.io.IOException;

import static common.setup.DriverManager.*;

//@CucumberOptions(features = {"C:\\Ignition-Automation\\ignition-qa-main\\AFS_Automation\\WMS_Automation\\src\\test\\resources\\features\\setup\\jobType\\JobType.feature","C:\\Ignition-Automation\\ignition-qa-main\\AFS_Automation\\WMS_Automation\\src\\test\\resources\\features\\setup\\laborCodes\\SetupLabor.feature"},
//        @CucumberOptions(features = {"C:\\Ignition-Automation-New\\ignition-qa-main\\AFS_Automation\\WMS_Automation\\src\\test\\resources\\features\\setup\\jobType\\JobType.feature"},
//          @CucumberOptions(features = {"C:\\Ignition-Automation\\ignition-qa-main\\AFS_Automation\\WMS_Automation\\src\\test\\resources\\features\\setup\\laborCodes\\SetupLabor.feature"},
//@CucumberOptions(features = {"C:\\Users\\Sneha.Pallikunnath\\ignition-qa\\AFS_Automation\\WMS_Automation\\src\\test\\resources\\features\\setupConfiguration"},


//@CucumberOptions(features={"WMSAutomation/src/test/resources/features/counting"},
//@CucumberOptions(features = {"src/test/resources/features/setupSystem"},
@CucumberOptions(features = {"src/test/resources/features/setupLabor/congestion/Congestion.feature",
                              "src/test/resources/features/setupLabor/exitReason/ExitReason.feature",
                              "src/test/resources/features/setupLabor/fatigue/Fatigue.feature",
//                              "src/test/resources/features/setupLabor/jobType/JobType.feature",
                              "src/test/resources/features/setupLabor/laborCodes/SetupLabor.feature",
                              "src/test/resources/features/setupLabor/shift/Shift.feature",
                              "src/test/resources/features/setupConfiguration/account/Account.feature",
                              "src/test/resources/features/setupConfiguration/allocationBatch/AllocationBatch.feature",
                              "src/test/resources/features/setupConfiguration/assignmentType/AssignmentType.feature",
                              "src/test/resources/features/setupConfiguration/company/Company.feature",
                              "src/test/resources/features/setupConfiguration/countType/CountType.feature",
                              "src/test/resources/features/setupConfiguration/orderType/OrderType.feature",
                              "src/test/resources/features/setupConfiguration/palletType/PalletType.feature",
                              "src/test/resources/features/setupConfiguration/routeType/RouteType.feature",
                              "src/test/resources/features/setupConfiguration/taskGroup/TaskGroup.feature",
                              "src/test/resources/features/setupConfiguration/trailer/Trailer.feature",
                              "src/test/resources/features/setupConfiguration/trailerType/TrailerType.feature",
                              "src/test/resources/features/setupSystem/labelFile/LabelFile.feature",
                              "src/test/resources/features/setupSystem/labelFormat/LabelFile.feature",
                              "src/test/resources/features/setupSystem/labelRule/LabelRule.feature",
                              "src/test/resources/features/setupSystem/permission/Permission.feature",
                              "src/test/resources/features/setupSystem/purge/Purge.feature",
                              "src/test/resources/features/setupSystem/registry/Registry.feature",
                              "src/test/resources/features/setupSystem/userGroup/UserGroup.feature",
                              "src/test/resources/features/setupWarehouse/aisle/aisle.feature",
                              "src/test/resources/features/setupWarehouse/aisleType/aisleType.feature",
                              "src/test/resources/features/setupWarehouse/dockDoor/Dockdoor.feature",
                              "src/test/resources/features/setupWarehouse/dockDoorGroup/DockDoorGroup.feature",
                              "src/test/resources/features/setupWarehouse/equipment/Equipment.feature",
                              "src/test/resources/features/setupWarehouse/equipmentChecklist/EquipmentChecklist.feature",
                              "src/test/resources/features/setupWarehouse/equipmentType/EquipmentType.feature",
                              "src/test/resources/features/setupWarehouse/location/Location.feature",
                              "src/test/resources/features/setupWarehouse/locationType/LocationType.feature",
                              "src/test/resources/features/setupWarehouse/rackType/RackType.feature",
                              "src/test/resources/features/setupWarehouse/warehouse/Warehouse.feature",
                              "src/test/resources/features/setupWarehouse/yard/Yard.feature",
                              "src/test/resources/features/setupWarehouse/zone/Zone.feature"},



        glue = {"steps"},
        plugin = {"pretty",
                "json:target/cucumber.json",
                "html:Reports/Index.html",
                "json:target/cucumber-reports/cucumber.json",
                "rerun:target/failedrerun.txt"
        }, monochrome = true, tags = "@Regression")
@Slf4j
public class Phase3Runnerpar extends AbstractTestNGCucumberTests {
    public static Environment environment;

    @Parameters({"environment","browser"})
    @BeforeMethod
    public void startBrowserInstance(@Optional String env, @Optional String browser) {
        ConfigFactory.setProperty("path", FilePaths.PROPERTIES_PATH);
        environment = ConfigFactory.create(Environment.class);
        log.info("Starting app url " + environment.getUrl() + " on browser " +  environment.getBrowser());
        buildWebDriver(environment.getBrowser());
        DriverManager.openPage(environment.getUrl());
        new Waiters();
    }

//    @SneakyThrows
//    @AfterMethod
//    public void closeBrowserInstance(ITestResult iTestResult){
//        if (driverEnabled(getDriver())) {
//            try{
//                driverThreadLocal.get().close();
//                driverThreadLocal.get().quit();
//            } catch(Exception e) {
//                //   FileUtils.forceDelete(new File("C:/Users/Irina.Holovan/Desktop/chrome/" + DriverManager.COUNTER));
//                System.out.println("Error closing and quitting the web driver: " + e.getMessage());
//                if(getDriver() instanceof ChromeDriver){
//                    try {
//                        //  FileUtils.forceDelete(new File("C:/Users/Irina.Holovan/Desktop/chrome/" + DriverManager.COUNTER));
//                        Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe");
//                    } catch (IOException ex) {
//                        System.out.println("Error force quitting the ChromeDriver process: " + ex.getMessage());
//                    }
//                }
//            }
//        }
//    }
@SneakyThrows
@AfterMethod
public void closeBrowserInstance(ITestResult iTestResult) {
    if (driverEnabled(getDriver())) {
        try{
            driverThreadLocal.get().close();
            driverThreadLocal.get().quit();
        } catch(Exception e) {
            //   FileUtils.forceDelete(new File("C:/Users/Irina.Holovan/Desktop/chrome/" + DriverManager.COUNTER));
            System.out.println("Error closing and quitting the web driver: " + e.getMessage());
            if(getDriver() instanceof ChromeDriver){
                try {
                    //  FileUtils.forceDelete(new File("C:/Users/Irina.Holovan/Desktop/chrome/" + DriverManager.COUNTER));
                    Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe");
                } catch (IOException ex) {
                    System.out.println("Error force quitting the ChromeDriver process: " + ex.getMessage());
                }
            }
        }
    }
}
}

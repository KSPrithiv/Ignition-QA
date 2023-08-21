package listeners;

import io.qameta.allure.Allure;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.*;

import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.Map;

import static common.setup.DriverManager.getDriver;

public class TestListener extends TestListenerAdapter implements ITestListener, IClassListener, IInvokedMethodListener {
    @Getter
    @Setter
    private static Map<String, Integer> failedTestsResultRunMap = new HashMap<>();
    private static Map<String, Integer> skippedTestsResultRunMap = new HashMap<>();

    @Override
    public void onTestStart(ITestResult testResult) {
        super.onTestStart(testResult);
        System.out.println(String.format("Skipped tests are %s and skipped tests amount %s",
                skippedTestsResultRunMap.toString(), skippedTestsResultRunMap.size()));
        System.out.println(String.format("Failed tests are %s and failed tests amount %s",
                failedTestsResultRunMap.toString(), failedTestsResultRunMap.size()));
    }

    @Override
    public void onTestFailure(ITestResult testResult) {
        failedTestsResultRunMap.put(testResult.getTestName(), testResult.getStatus());
        Allure.addAttachment(testResult.getName(),
               new ByteArrayInputStream(((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES)));
    }


    @Override
    public void onTestSkipped(ITestResult testResult) {
       skippedTestsResultRunMap.put(testResult.getTestName(), testResult.getStatus());
       Allure.addAttachment(testResult.getName(),
                new ByteArrayInputStream(((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES)));
       System.out.println(String.format("Skipped tests are %s and skipped tests amount %s",
                skippedTestsResultRunMap.toString(), skippedTestsResultRunMap.size()));
    }


    @Override
    public void onFinish(ITestContext context) {
        failedTestsResultRunMap.put(context.getFailedTests().getAllMethods().toString(), context.getFailedTests().size());
        Allure.addAttachment(context.getFailedTests().toString(),
                new ByteArrayInputStream(((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES)));
        System.out.println(String.format("Failed tests are %s and failed tests amount %s",
                failedTestsResultRunMap.toString(), failedTestsResultRunMap.size()));
    }

    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {

    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        if(!testResult.isSuccess()) {
            failedTestsResultRunMap.put(method.getTestMethod().getMethodName(), testResult.getStatus());
            Allure.addAttachment(testResult.getTestName(), new ByteArrayInputStream(((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES)));
        }
    }
}

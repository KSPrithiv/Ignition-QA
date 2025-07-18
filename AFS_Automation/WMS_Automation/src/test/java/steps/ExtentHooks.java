package steps;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import groovy.util.logging.Slf4j;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;

@Slf4j
public class ExtentHooks {
    @AfterStep
    public void afterStep(Scenario scenario) {
        String status = scenario.isFailed() ? "Failed Step" : "Passed Step";
        ExtentCucumberAdapter.addTestStepLog(status + ": " + scenario.getName());
    }

}

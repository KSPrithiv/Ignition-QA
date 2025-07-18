package TestListeners;

import common.utils.ExtentReportManager;
import io.cucumber.plugin.ConcurrentEventListener;
import io.cucumber.plugin.event.EventPublisher;
import io.cucumber.plugin.event.TestRunFinished;

public class ExtentReportListener implements ConcurrentEventListener {
    @Override
    public void setEventPublisher(EventPublisher publisher) {
        publisher.registerHandlerFor(TestRunFinished.class, event -> {
            ExtentReportManager.getReportInstance().flush();
        });
    }
}

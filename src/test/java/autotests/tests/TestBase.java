package autotests.tests;


import autotests.appmanager.ApplicationManager;
import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;

@Listeners(MyTestListener.class)
public class TestBase {

    Logger logger = LoggerFactory.getLogger(TestBase.class);

    protected final ApplicationManager app =
            new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));

    @BeforeMethod
    public void setUp(ITestContext context) throws Exception {
        app.init();
        context.setAttribute("app", app);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        app.stop();
    }

    @BeforeMethod
    public void logTestStart(Method method, Object[] params) {
        logger.info("Start test " + method.getName() + " with parameters " + Arrays.asList(params));
    }

    @AfterMethod(alwaysRun = true)
    public void logTestStop(Method method) {
        logger.info("Stop test " + method.getName());
    }

}

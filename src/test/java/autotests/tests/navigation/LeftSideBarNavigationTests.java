package autotests.tests.navigation;


import autotests.tests.DataProviders;
import autotests.tests.TestBase;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class LeftSideBarNavigationTests  extends TestBase{

    @Test(dataProvider = "leftSideLinks", dataProviderClass = DataProviders.class)
    public void leftSideBarNavigationTests(String link, String url) {
        app.goToLeftSideLink(link);

        assertTrue(app.isOnThePage(url));

    }
}

package autotests.tests.navigation;


import autotests.tests.DataProviders;
import autotests.tests.TestBase;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class FooterNavigationTests extends TestBase {

    @Test(dataProvider = "footerLinks", dataProviderClass = DataProviders.class)
    public void testFooterNavigation(String link, String url) {
        app.goToFooterLink(link);

        assertTrue(app.isOnThePage(url));

    }
}

package autotests.tests.navigation;


import autotests.tests.DataProviders;
import autotests.tests.TestBase;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class CategoryNavigationTests extends TestBase {

    @Test(dataProvider = "categoryLinks", dataProviderClass = DataProviders.class)
    public void categoryNavigationTests(String category, String url) {
        app.chooseCategoryByName(category);

        assertTrue(app.isOnThePage(url));

    }
}

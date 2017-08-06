package autotests.tests.view;


import autotests.tests.DataProviders;
import autotests.tests.TestBase;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ViewAllItemsInCategoryTests extends TestBase {

    @Test(dataProvider = "category", dataProviderClass = DataProviders.class)
    public void testViewAllItemsInCategory(String category) {
        app.chooseCategoryByName(category);
        int itemsCountFromViewAllLinkText = app.allItemsInCategory();
        app.clickViewAll();
        int allItemsCountOnTheCategoryPage = app.itemsCountOnCategoryPage();

        assertEquals(allItemsCountOnTheCategoryPage, itemsCountFromViewAllLinkText);




    }
}

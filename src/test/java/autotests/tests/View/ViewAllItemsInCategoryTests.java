package autotests.tests.View;


import autotests.tests.TestBase;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ViewAllItemsInCategoryTests extends TestBase {

    @Test
    public void viewAllItemsInCategoryTests() {
        app.chooseCategoryByName("Christmas");
        int itemsCountFromViewAllLinkText = app.allItemsInCategory();
        app.clickViewAll();
        int allItemsCountOnTheCategoryPage = app.itemsCountOnCategoryPage();

        assertEquals(allItemsCountOnTheCategoryPage, itemsCountFromViewAllLinkText);




    }
}

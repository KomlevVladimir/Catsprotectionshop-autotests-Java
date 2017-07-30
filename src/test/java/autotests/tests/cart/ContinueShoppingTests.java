package autotests.tests.cart;


import autotests.model.ItemData;
import autotests.tests.DataProviders;
import autotests.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class ContinueShoppingTests extends TestBase {

    @BeforeMethod
    public void itemIsAddedToCart(Object[] testArgs) {
        ItemData item = (ItemData) testArgs[0];
        app.addItemToCart(item);
    }

    @Test(dataProvider = "item", dataProviderClass = DataProviders.class)
    public void continueShoppingTests(ItemData item) {
        app.continueShopping();

        assertTrue(app.isOnTheViewItemPage());
    }

}

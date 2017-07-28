package autotests.tests.cart;


import autotests.model.ItemData;
import autotests.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class ContinueShoppingTests extends TestBase {

    @BeforeMethod
    public void itemIsAddedToCart() {
        ItemData item = new ItemData().inCategory("Cat Gifts").withName("Morocco Cat Bed").withQuantity("1");
        app.chooseItem(item);
        app.addToCart();
    }

    @Test
    public void continueShoppingTests() {
        app.continueShopping();

        assertTrue(app.isOnTheViewItemPage());
    }

}

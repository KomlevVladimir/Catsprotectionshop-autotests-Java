package autotests.tests;


import autotests.model.ItemData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ContinueShoppingTests extends TestBase {

    @BeforeMethod
    public void itemIsAddedToCart() {
        ItemData item = new ItemData(
                "Cat Gifts", "Cracker for Your Cat", "1", null, null
        );
        app.chooseItem(item);
        app.addToCart();
    }

    @Test
    public void continueShoppingTests() {
        app.continueShopping();

        Assert.assertTrue(app.isOnTheViewItemPage());
    }

}

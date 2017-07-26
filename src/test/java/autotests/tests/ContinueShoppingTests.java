package autotests.tests;


import autotests.model.ItemData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ContinueShoppingTests extends TestBase {

    @BeforeMethod
    public void itemIsAddedToCart() {
        ItemData item = new ItemData().inCategory("Cat Gifts").withName("Cracker for Your Cat").withQuantity("1");
        app.chooseItem(item);
        app.addToCart();
    }

    @Test
    public void continueShoppingTests() {
        app.continueShopping();

        Assert.assertTrue(app.isOnTheViewItemPage());
    }

}

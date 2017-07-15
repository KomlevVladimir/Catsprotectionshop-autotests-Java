package autotests.tests;

import autotests.model.ItemData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddToCartTests extends TestBase {

    @Test
    public void addToCartTests() {
        ItemData item = new ItemData(
                "Gifts", "Kitten Mini Umbrella", "2", null, null
        );
        app.ChooseItem(item);
        ItemData itemOnViewPage = app.getItemFromViewPage();
        app.addToCartFromItemPage();

        ItemData itemOnCartPage = app.getItemFromCartPage();

        Assert.assertTrue(app.isInTheCartPage());
        Assert.assertEquals(itemOnViewPage, itemOnCartPage);
    }

}

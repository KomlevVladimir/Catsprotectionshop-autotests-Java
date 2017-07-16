package autotests.tests;

import autotests.model.ItemData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class AddItemToCartTests extends TestBase {

    @Test
    public void addToCartTests() {
        ItemData item = new ItemData(
                "Gifts", "Kitten Mini Umbrella", "2", null, null
        );
        List<ItemData> itemsFromViewPage = new ArrayList<>();
        app.ChooseItem(item);
        ItemData itemOnViewPage = app.getItemFromViewPage();
        itemsFromViewPage.add(itemOnViewPage);
        app.addToCart();
        List<ItemData> itemsFromCartPage = new ArrayList<>(app.getItemsFromCartPage());

        Assert.assertTrue(app.isInTheCartPage());
        Assert.assertEquals(itemsFromViewPage, itemsFromCartPage);
    }

}

package autotests.tests;


import autotests.model.ItemData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class AddFewItemsToCartTests extends TestBase {

    @Test
    public void addFewItemsToCartTests() {
        ItemData firstItem = new ItemData(
                "Christmas", "Ginger Cat Bauble", "1", null, null
        );
        ItemData secondItem = new ItemData(
                "Exclusives", "Cats Protection Sticky Notes Set", "3", null, null
        );
        List<ItemData> itemsFromViewPage = new ArrayList<ItemData>();

        app.ChooseItem(firstItem);
        ItemData firstItemFromViewPage = app.getItemFromViewPage();
        itemsFromViewPage.add(firstItemFromViewPage);
        app.addToCart();

        app.ChooseItem(secondItem);
        ItemData secondItemFromViewPage = app.getItemFromViewPage();
        itemsFromViewPage.add(secondItemFromViewPage);
        app.addToCart();

        List<ItemData>itemsFromCartPage = app.getItemsFromCartPage();

        Assert.assertTrue(app.isInTheCartPage());
        Assert.assertEquals(itemsFromViewPage, itemsFromCartPage);
    }
}

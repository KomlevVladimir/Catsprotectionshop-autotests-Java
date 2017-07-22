package autotests.tests;

import autotests.model.ItemData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class AddItemsToCartTests extends TestBase {

    @Test
    public void addItemToCartTests() {
        ItemData item = new ItemData(
                "Gifts", "Kitten Mini Umbrella", "2", null, null
        );
        List<ItemData> itemsFromViewPage = new ArrayList<>();
        app.chooseItem(item);
        ItemData itemOnViewPage = app.getItemFromViewPage();
        itemsFromViewPage.add(itemOnViewPage);
        app.addToCart();
        List<ItemData> itemsFromCartPage = new ArrayList<>(app.getItemsFromCartPage());

        Assert.assertTrue(app.isOnTheCartPage());
        Assert.assertEquals(itemsFromViewPage, itemsFromCartPage);
    }

    @Test
    public void addFewItemsToCartTests() {
        ItemData firstItem = new ItemData(
                "Christmas", "Ginger Cat Bauble", "1", null, null
        );
        ItemData secondItem = new ItemData(
                "Exclusives", "Cats Protection Sticky Notes Set", "3", null, null
        );
        List<ItemData> itemsFromViewPage = new ArrayList<ItemData>();
        app.chooseItem(firstItem);
        ItemData firstItemFromViewPage = app.getItemFromViewPage();
        itemsFromViewPage.add(firstItemFromViewPage);
        app.addToCart();
        app.chooseItem(secondItem);
        ItemData secondItemFromViewPage = app.getItemFromViewPage();
        itemsFromViewPage.add(secondItemFromViewPage);
        app.addToCart();
        List<ItemData>itemsFromCartPage = app.getItemsFromCartPage();

        Assert.assertTrue(app.isOnTheCartPage());
        Assert.assertEquals(itemsFromViewPage, itemsFromCartPage);
    }

}

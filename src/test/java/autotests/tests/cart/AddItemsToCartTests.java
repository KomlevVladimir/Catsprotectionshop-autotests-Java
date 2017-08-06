package autotests.tests.cart;

import autotests.model.ItemData;
import autotests.tests.DataProviders;
import autotests.tests.TestBase;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class AddItemsToCartTests extends TestBase {


    @Test(dataProvider = "item", dataProviderClass = DataProviders.class)
    public void testAddItemToCart(ItemData item) {
        List<ItemData> itemsFromViewPage = new ArrayList<>();
        app.chooseItem(item);
        ItemData itemOnViewPage = app.getItemFromViewPage();
        itemsFromViewPage.add(itemOnViewPage);
        app.addToCart();
        List<ItemData> itemsFromCartPage = new ArrayList<>(app.getItemsFromCartPage());

        assertTrue(app.isOnTheCartPage());
        assertEquals(itemsFromViewPage, itemsFromCartPage);
    }

    @Test(dataProvider = "items", dataProviderClass = DataProviders.class)
    public void testAddFewItemsToCart(ItemData firstItem, ItemData secondItem, ItemData thirdItem) {
        List<ItemData> itemsFromViewPage = new ArrayList<ItemData>();
        app.chooseItem(firstItem);
        ItemData firstItemFromViewPage = app.getItemFromViewPage();
        itemsFromViewPage.add(firstItemFromViewPage);
        app.addToCart();
        app.chooseItem(secondItem);
        ItemData secondItemFromViewPage = app.getItemFromViewPage();
        itemsFromViewPage.add(secondItemFromViewPage);
        app.addToCart();
        app.chooseItem(thirdItem);
        ItemData thirdItemFromViewPage = app.getItemFromViewPage();
        itemsFromViewPage.add(thirdItemFromViewPage);
        app.addToCart();
        List<ItemData>itemsFromCartPage = app.getItemsFromCartPage();

        assertTrue(app.isOnTheCartPage());
        assertEquals(itemsFromViewPage, itemsFromCartPage);
    }

}

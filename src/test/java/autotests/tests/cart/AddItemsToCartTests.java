package autotests.tests.cart;

import autotests.model.ItemData;
import autotests.tests.TestBase;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class AddItemsToCartTests extends TestBase {

    @Test
    public void addItemToCartTests() {
        ItemData item = new ItemData().inCategory("Gifts").withName("Kitten Mini Umbrella").withQuantity("2");
        List<ItemData> itemsFromViewPage = new ArrayList<>();
        app.chooseItem(item);
        ItemData itemOnViewPage = app.getItemFromViewPage();
        itemsFromViewPage.add(itemOnViewPage);
        app.addToCart();
        List<ItemData> itemsFromCartPage = new ArrayList<>(app.getItemsFromCartPage());

        assertTrue(app.isOnTheCartPage());
        assertEquals(itemsFromViewPage, itemsFromCartPage);
    }

    @Test
    public void addFewItemsToCartTests() {
        ItemData firstItem = new ItemData().inCategory("Christmas").withName("Ginger Cat Bauble").withQuantity("1");
        ItemData secondItem = new ItemData().inCategory("Exclusives")
                .withName("Cats Protection A5 Notebook").withQuantity("3");
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

        assertTrue(app.isOnTheCartPage());
        assertEquals(itemsFromViewPage, itemsFromCartPage);
    }

}

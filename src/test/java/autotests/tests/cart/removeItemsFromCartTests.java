package autotests.tests.cart;


import autotests.model.ItemData;
import autotests.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class removeItemsFromCartTests extends TestBase {

    @BeforeMethod
    public void itemIsAddedToCart() {
        ItemData item = new ItemData().inCategory("Cat Gifts").withName("Santa's Trouser Tunnel").withQuantity("1");
        app.chooseItem(item);
        app.addToCart();
    }

    @Test
    public void removeItemFromCartTests() {
        List<ItemData> itemsFromCartPageBefore = new ArrayList<>(app.getItemsFromCartPage());
        ItemData item = app.itemFromCartPageWithName("Santa's Trouser Tunnel");
        app.removeItem(item);
        List<ItemData> itemsFromCartPageAfter = new ArrayList<>(app.getItemsFromCartPage());

        assertEquals(itemsFromCartPageAfter.size(), itemsFromCartPageBefore.size() - 1);
        itemsFromCartPageBefore.remove(item);
        assertEquals(itemsFromCartPageAfter, itemsFromCartPageBefore);
    }
}



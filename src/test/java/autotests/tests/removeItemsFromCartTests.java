package autotests.tests;


import autotests.model.ItemData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class removeItemsFromCartTests extends TestBase {

    @BeforeMethod
    public void itemIsAddedToCart() {
        ItemData item = new ItemData(
                "Cat Gifts", "Santa's Trouser Tunnel", "1", null, null
        );
        app.chooseItem(item);
        app.addToCart();
    }

    @Test
    public void removeItemFromCartTests() {
        List<ItemData> itemsFromCartPageBefore = new ArrayList<>(app.getItemsFromCartPage());
        ItemData item = app.getItemFromCartPageByName("Santa's Trouser Tunnel");
        app.removeItem(item);
        List<ItemData> itemsFromCartPageAfter = new ArrayList<>(app.getItemsFromCartPage());

        Assert.assertEquals(itemsFromCartPageAfter.size(), itemsFromCartPageBefore.size() - 1);
        itemsFromCartPageBefore.remove(item);
        Assert.assertEquals(itemsFromCartPageAfter, itemsFromCartPageBefore);
    }
}



package autotests.tests.cart;


import autotests.model.ItemData;
import autotests.tests.DataProviders;
import autotests.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class removeItemsFromCartTests extends TestBase {

    @BeforeMethod
    public void itemIsAddedToCart(Object[] testArgs) {
        ItemData itemToRemove = (ItemData) testArgs[0];
        app.addItemToCart(itemToRemove);
    }

    @Test(dataProvider = "item", dataProviderClass = DataProviders.class)
    public void removeItemFromCartTests(ItemData itemToRemove) {
        app.addItemToCart(itemToRemove);

        List<ItemData> itemsFromCartPageBefore = new ArrayList<>(app.getItemsFromCartPage());
        ItemData item = app.itemFromCartPageWithName(itemToRemove.getItemName());
        app.removeItem(item);
        List<ItemData> itemsFromCartPageAfter = new ArrayList<>(app.getItemsFromCartPage());

        assertEquals(itemsFromCartPageAfter.size(), itemsFromCartPageBefore.size() - 1);
        itemsFromCartPageBefore.remove(item);
        assertEquals(itemsFromCartPageAfter, itemsFromCartPageBefore);
    }
}



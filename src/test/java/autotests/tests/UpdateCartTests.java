package autotests.tests;


import autotests.model.ItemData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class UpdateCartTests extends TestBase {

    @BeforeMethod
    public void itemIsAddedToCart() {
        ItemData item = new ItemData(
                "Home & Kitchen", "Cosy Cats Tea Cosy", "1", null, null
        );
        app.chooseItem(item);
        app.addToCart();
    }

    @Test
       public void updateCartTests() {
        ItemData item = app.getItemFromCartPageByName("Cosy Cats Tea Cosy");
        String quantityBefore = item.getQuantity();
        app.changeQuantityTo("3");
        app.updateCart();
        String quantityAfter = item.getQuantity();

        Assert.assertEquals(quantityAfter, "3");
        Assert.assertTrue(!quantityAfter.equals(quantityBefore));
    }




}

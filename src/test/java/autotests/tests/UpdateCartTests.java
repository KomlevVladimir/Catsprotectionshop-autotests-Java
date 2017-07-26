package autotests.tests;


import autotests.model.ItemData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static java.lang.Float.parseFloat;


public class UpdateCartTests extends TestBase {

    @BeforeMethod
    public void itemIsAddedToCart() {
        ItemData item = new ItemData().inCategory("Home & Kitchen").withName("Cosy Cats Tea Cosy").withQuantity("1");
        app.chooseItem(item);
        app.addToCart();
    }

    @Test
    public void updateCartTests() {
        String quantityBefore = app.itemFromCartPageWithName("Cosy Cats Tea Cosy").getQuantity();
        String newQuantity = "3";
        app.changeQuantityTo(newQuantity);
        float expectedCost = app.getCost(app.itemFromCartPageWithName("Cosy Cats Tea Cosy"))
                * parseFloat(newQuantity);
        app.updateCart();
        String quantityAfter = app.itemFromCartPageWithName("Cosy Cats Tea Cosy").getQuantity();
        float actualCost = app.getCost(app.itemFromCartPageWithName("Cosy Cats Tea Cosy"));

        Assert.assertEquals(quantityAfter, "3");
        Assert.assertTrue(!quantityAfter.equals(quantityBefore));
        Assert.assertEquals(actualCost, expectedCost);
    }





}

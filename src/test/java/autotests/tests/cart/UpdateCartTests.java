package autotests.tests.cart;


import autotests.model.ItemData;
import autotests.tests.DataProviders;
import autotests.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static java.lang.Float.parseFloat;
import static org.apache.commons.lang3.StringUtils.substring;
import static org.testng.Assert.*;


public class UpdateCartTests extends TestBase {

    @BeforeMethod
    public void itemIsAddedToCart(Object[] testArgs) {
        ItemData item = (ItemData) testArgs[0];
        app.addItemToCart(item);
        String newQuantity = (String) testArgs[1];
    }

    @Test(dataProvider = "update", dataProviderClass = DataProviders.class)
    public void testUpdateCart(ItemData item, String newQuantity) {
        String quantityBefore = app.itemFromCartPageWithName(item.getItemName()).getQuantity();
        app.changeQuantityTo(newQuantity);
        String price = substring(app.itemFromCartPageWithName(item.getItemName()).getPrice(), 1);
        float expectedCost = parseFloat(price) * parseFloat(newQuantity);
        app.updateCart();
        String quantityAfter = app.itemFromCartPageWithName(item.getItemName()).getQuantity();
        float costOnTheCartPage = app.costOfItemOnTheCartPage(app.itemFromCartPageWithName(item.getItemName()));

        assertEquals(quantityAfter, newQuantity);
        assertTrue(!quantityAfter.equals(quantityBefore));
        assertEquals(costOnTheCartPage, expectedCost);
    }
}

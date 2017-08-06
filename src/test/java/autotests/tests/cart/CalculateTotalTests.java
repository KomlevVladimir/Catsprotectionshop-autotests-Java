package autotests.tests.cart;


import autotests.model.ItemData;
import autotests.tests.DataProviders;
import autotests.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CalculateTotalTests extends TestBase {

    @BeforeMethod
    public void itemIsAddedToCart(Object[] testArgs) {
        ItemData firstItem = (ItemData) testArgs[0];
        ItemData secondItem = (ItemData) testArgs[1];
        ItemData thirdItem = (ItemData) testArgs[2];
        app.addItemToCart(firstItem);
        app.addItemToCart(secondItem);
        app.addItemToCart(thirdItem);
    }

    @Test(dataProvider = "items", dataProviderClass = DataProviders.class)
    public void testCalculateTotal(ItemData firstItem, ItemData secondItem, ItemData thirdItem){
        float costSum = app.costSumOfItems();
        float total = app.totalOnTheCartPage();

        assertEquals(total, costSum);
    }


}

package autotests.tests.cart;


import autotests.model.ItemData;
import autotests.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CalculateTotalTests extends TestBase {

    @BeforeMethod
    public void itemIsAddedToCart() {
        ItemData firstItem = new ItemData().inCategory("Sale").
                withName("Bah Humbug Tin with Mint Humbugs").withQuantity("1");
        app.chooseItem(firstItem);
        app.addToCart();
        ItemData secondItem = new ItemData().inCategory("Exclusives")
                .withName("Cats Protection A5 Notebook").withQuantity("1");
        app.chooseItem(secondItem);
        app.addToCart();
        ItemData thirdItem = new ItemData().inCategory("Cat Gifts")
                .withName("Catnip Sack").withQuantity("1");
        app.chooseItem(thirdItem);
        app.addToCart();
    }

    @Test
    public void calculateTotalTests(){
        float costSum = app.costSumOfItems();
        float total = app.totalOnTheCartPage();

        assertEquals(total, costSum);
    }


}

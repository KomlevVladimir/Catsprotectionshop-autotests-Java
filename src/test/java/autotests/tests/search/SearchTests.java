package autotests.tests.search;


import autotests.model.ItemData;
import autotests.tests.DataProviders;
import autotests.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static java.lang.Float.parseFloat;
import static jdk.nashorn.internal.objects.NativeString.substring;

public class SearchTests extends TestBase {

    @Test(dataProvider = "anyWord", dataProviderClass = DataProviders.class)
    public void testSearchByAnyWord(String word) {
        app.searchItemByAnyWords(word);
        List<ItemData> items = app.itemsFromSearchPage();

        for (ItemData item:items) {
            String itemName = item.getItemName().toLowerCase();
            Assert.assertTrue(itemName.contains(word.toLowerCase()));
            }
    }

    @Test(dataProvider = "allWords", dataProviderClass = DataProviders.class)
    public void testSearchByAllWords(String words) {
        app.searchItemByAllWords(words);
        List<ItemData> items = app.itemsFromSearchPage();

        for (ItemData item:items) {
            String itemName = item.getItemName();
            Assert.assertTrue(itemName.contains(words));
        }
    }

    @Test(dataProvider = "price", dataProviderClass = DataProviders.class)
    public void testSearchByPrice(String price, String words) {
        app.searchByPrice(price, words);
        List<ItemData> items = app.itemsFromSearchPage();
        float priceFrom = app.priceFrom(price);
        float priceUntil = app.priceUntil(price);

        for (ItemData item : items) {
            String itemPrice = substring(item.getPrice(), 1);

            Assert.assertTrue(parseFloat(itemPrice) >= priceFrom && parseFloat(itemPrice) <= priceUntil);
        }
    }

    @Test(dataProvider = "nonexistenItemName", dataProviderClass = DataProviders.class)
    public void testSearchNonexistenItem(String word) {
        app.searchItemByAnyWords(word);
        List<ItemData> items = app.itemsFromSearchPage();

        Assert.assertTrue(items.size() == 0);

    }


}

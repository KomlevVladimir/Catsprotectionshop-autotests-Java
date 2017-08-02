package autotests.tests.view;


import autotests.model.ItemData;
import autotests.tests.DataProviders;
import autotests.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PreviewItemTests extends TestBase {

    @Test(dataProvider = "item", dataProviderClass = DataProviders.class)
    public void viewItemTests(ItemData item) {
        app.goToViewPage(item);
        app.previewItem();

        Assert.assertTrue(app.zoomedImageIsDisplayed());
    }
}

package autotests.tests.View;


import autotests.model.ItemData;
import autotests.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class previewItemTests extends TestBase {

    @Test
    public void viewItemTests() {
        ItemData item = new ItemData().inCategory("Gifts").withName("Tipsy Selection");
        app.goToViewPage(item);
        app.previewItem();

        Assert.assertTrue(app.zoomedImageIsDisplayed());
    }
}

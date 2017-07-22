package autotests.pages;


import autotests.model.ItemData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import java.util.ArrayList;
import java.util.List;

public class CartPage extends BasePage {
    public CartPage(WebDriver wd) {
        super(wd);
        PageFactory.initElements(wd, this);
    }

    @FindBy(xpath = "//table[@class='checkout']/tbody/tr/th")
    public WebElement shoppingCartTitle;

    @FindBy(xpath = "//form/div[@class='cartButtons']/input")
    public WebElement buttonUpdate;

    @FindBy(xpath = "//tbody/tr[2]/td[@class='cart'][3]")
    public WebElement cost;

    @FindBy(xpath = "//form/div[@class='cartButtons']/input[2]")
    public WebElement buttonContinueShopping;



    public List<ItemData> getItems() {
        List<ItemData> items = new ArrayList<ItemData>();
        int rows = wd.findElements(By.xpath("//tbody/tr")).size();
        for (int i = 2; i < rows - 2; i++) {
            String itemName = wd.findElements(By.xpath("//tbody/tr[" + i + "]/td/span")).get(2).getText();
            String quantity = wd.findElement(By.xpath("//tbody/tr[" + i + "]/td/span/input"))
                    .getAttribute("value");
            String price = wd.findElement(By.xpath("//tbody/tr[" + i + "]/td[@class='cart'][2]")).getText();
            String ref = wd.findElements(By.xpath("//tbody/tr[" + i + "]/td/span")).get(1).getText();
            ItemData item = new ItemData(null, itemName, quantity, price, ref);
            items.add(item);
        }
        return  items;
    }

    public ItemData getItemByName(String name) {
        int rows = wd.findElements(By.xpath("//tbody/tr")).size();
        for (int i = 2; i < rows - 2; i++) {
            String itemName = wd.findElements(By.xpath("//tbody/tr[" + i + "]/td/span")).get(2).getText();
            if (itemName.equals(name)) {
                String quantity = wd.findElement(By.xpath("//tbody/tr[" + i + "]/td/span/input"))
                        .getAttribute("value");
                String price = wd.findElement(By.xpath("//tbody/tr[" + i + "]/td[@class='cart'][2]")).getText();
                String ref = wd.findElements(By.xpath("//tbody/tr[" + i + "]/td/span")).get(1).getText();
                return new ItemData(null, itemName, quantity, price, ref);
            }
        }
        return null;
    }

    public void activateCheckboxToRemoveItem(ItemData item) {
        List<ItemData>itemsOnCartPage = getItems();
        int index = itemsOnCartPage.indexOf(item) + 2;
        click(By.xpath("//tbody/tr[" + index + "]/td[4]/span/input"));
    }

    public void changeQuantity(String quantity) {
        fillForm(By.xpath("//tbody/tr[2]/td/span/input"), quantity);
    }



}

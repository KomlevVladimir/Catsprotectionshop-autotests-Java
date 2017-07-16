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

    @FindBy(css = "td.cart")
    public WebElement items;

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
}

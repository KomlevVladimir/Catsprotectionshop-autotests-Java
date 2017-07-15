package autotests.pages;


import autotests.model.ItemData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage extends BasePage {
    public CartPage(WebDriver wd) {
        super(wd);
        PageFactory.initElements(wd, this);
    }

    @FindBy(xpath = "//table[@class='checkout']/tbody/tr/th")
    public WebElement shoppingCartTitle;


    public ItemData getItem() {
        List<WebElement> elements = wd.findElements(By.xpath("//tbody/tr[2]/td/span"));
        String itemName = elements.get(2).getText();
        String quantity = wd.findElement(By.xpath("//tbody/tr[2]/td/span/input")).getAttribute("value");
        String price = wd.findElement(By.xpath("//tbody/tr[2]/td[@class='cart'][2]")).getText();
        String ref = elements.get(1).getText();
        return new ItemData(null, itemName, quantity, price, ref);
    }
}

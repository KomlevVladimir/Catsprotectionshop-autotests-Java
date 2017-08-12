package autotests.pages.frontpages;


import autotests.model.ItemData;
import autotests.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import java.util.ArrayList;
import java.util.List;

import static org.apache.commons.lang3.StringUtils.replace;
import static org.apache.commons.lang3.StringUtils.substring;

public class CartPage extends BasePage {

    public CartPage(WebDriver wd) {
        super(wd);
        PageFactory.initElements(wd, this);
    }

    @FindBy(xpath = "//table[@class='checkout']/tbody/tr/th")
    public WebElement shoppingCartTitle;

    @FindBy(xpath = "//form/div[@class='cartButtons']/input")
    public WebElement buttonUpdate;

    @FindBy(xpath = "//form/div[@class='cartButtons']/input[2]")
    public WebElement buttonContinueShopping;

    @FindBy(xpath = "//div[@class='checkoutButtonArea']/input")
    public WebElement buttonCheckoutNow;

    public List<ItemData> getItems() {
        List<ItemData> items = new ArrayList<ItemData>();
        int rows = wd.findElements(By.xpath("//tbody/tr")).size();
        for (int i = 2; i < rows - 2; i++) {
            String itemName = wd.findElements(By.xpath("//tbody/tr[" + i + "]/td/span")).get(2).getText();
            String quantity = wd.findElement(By.xpath("//tbody/tr[" + i + "]/td/span/input"))
                    .getAttribute("value");
            String price = replace(wd.findElement(By.xpath("//tbody/tr[" + i + "]/td[@class='cart'][2]"))
                    .getText(), "PRICE\n", "");
            String ref = wd.findElements(By.xpath("//tbody/tr[" + i + "]/td/span")).get(1).getText();
            ItemData item = new ItemData().withName(itemName).withQuantity(quantity).withPrice(price).withRef(ref);
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
                String price = replace(wd.findElement(By.xpath("//tbody/tr[" + i + "]/td[@class='cart'][2]"))
                        .getText(), "PRICE\n", "");
                String ref = wd.findElements(By.xpath("//tbody/tr[" + i + "]/td/span")).get(1).getText();
                return new ItemData().withName(itemName).withQuantity(quantity).withPrice(price).withRef(ref);
            }
        }
        return null;
    }

    public double getCostByItem(ItemData item) {
        List<ItemData>itemsOnCartPage = getItems();
        int index = itemsOnCartPage.indexOf(item) + 2;
        String cost = wd.findElement(By.xpath("//tbody/tr[" + index + "]/td[3]")).getText();
        cost = replace(cost, "COST\n£", "");
        cost = replace(cost, "£", "");
        return Math.ceil(Double.parseDouble(cost) * 100) / 100;
    }

    public void activateCheckboxToRemoveItem(ItemData item) {
        List<ItemData>itemsOnCartPage = getItems();
        int index = itemsOnCartPage.indexOf(item) + 2;
        click(By.xpath("//tbody/tr[" + index + "]/td[4]/span/input"));
    }

    public void changeQuantity(String quantity) {
        fillForm(By.xpath("//tbody/tr[2]/td/span/input"), quantity);
    }

    public double getCostSum() {
        int rows = wd.findElements(By.xpath("//tbody/tr")).size();
        List<String> costs = new ArrayList<>();
        for (int i = 2; i < rows - 2; i++) {
            String cost = replace(wd.findElement(By.xpath("//tbody/tr[" + i + "]/td[@class='cart'][3]"))
                    .getText(), "COST\n£", "");
            costs.add(cost);
            }
        double result = 0;
        for (String cost : costs) {
            result = result + Double.parseDouble(replace(cost, "£", ""));
            result = Math.ceil(result * 100) / 100;
        }
        return result;
    }

    public double getTotal() {
        String total = substring(wd.findElement(By.xpath("//td[@class='cartheading']")).getText(), 1);
        return Math.ceil(Double.parseDouble(total) * 100) / 100;
    }


}

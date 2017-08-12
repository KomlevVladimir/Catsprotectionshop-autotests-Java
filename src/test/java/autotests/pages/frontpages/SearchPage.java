package autotests.pages.frontpages;


import autotests.model.ItemData;
import autotests.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class SearchPage extends BasePage {

    public SearchPage(WebDriver wd) {
        super(wd);
        PageFactory.initElements(wd, this);
    }

    @FindBy(xpath = "//input[@id='TB-A']")
    public WebElement checkboxAllWords;

    @FindBy(xpath = "//fieldset/div[@class='searchCriteria']/select")
    public WebElement selectPriceRange;

    public List<ItemData> getItems() {
        List<ItemData> items = new ArrayList<ItemData>();
        int itemsOnThePage = wd.findElements(By.xpath("//div[@class='std-product-details']/div/a/h3")).size();
        for (int i = 1; i < itemsOnThePage; i++) {
            String name = wd.findElement(By.xpath("//div[" + i + "][@class='std-product-details']/div/a/h3"))
                    .getText();
            String price = wd.findElement(By.xpath("//div[1]/div/p[@class='product-price']")).getText();
            ItemData item = new ItemData().withName(name).withPrice(price);
            items.add(item);
        }
        return items;
    }

    public void search(String words) {
        fillForm(By.xpath("//fieldset/input[1]"), words);
        click(By.xpath("//fieldset/input[3]"));
    }

    public void searchByPrice(String priceRange, String words) {
        new Select(selectPriceRange).selectByValue(priceRange);
        fillForm(By.xpath("//fieldset/input[1]"), words);
        click(By.xpath("//fieldset/input[3]"));
    }

    public double priceFrom(String priceValue) {
        double priceFrom = 0;
        switch (priceValue) {
            case "1":
                priceFrom = 0;
                break;

            case "2":
                priceFrom = 10.00;
                break;

            case "3":
                priceFrom = 20.00;
                break;

            case "4":
                priceFrom = 40.00;
                break;

            case "5":
                priceFrom = 50.00;
        }
        return priceFrom;
    }

    public double priceUntil(String priceValue) {
        double priceUntil = 0;
        switch (priceValue) {
            case "1":
                priceUntil = 9.99;
                break;

            case "2":
                priceUntil = 19.99;
                break;

            case "3":
                priceUntil = 39.99;
                break;

            case "4":
                priceUntil = 49.99;
                break;

            case "5":
                priceUntil = 10000.00;
        }
         return priceUntil;
    }
}

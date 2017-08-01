package autotests.pages.frontpages;


import autotests.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CategoryPage extends BasePage {

    public CategoryPage(WebDriver wd) {
        super(wd);
        PageFactory.initElements(wd, this);
    }

    @FindBy(xpath = "//div[@id='ContentPage']/p/a[contains(text(), \"View All\")]")
    public WebElement linkViewAll;

    public void waitUntilItemListPageIsLoaded() {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("loading-gif")));
    }

    public void gotToViewItemPage(String itemName)
    {
        waitUntilItemListPageIsLoaded();
        if (isElementPresent(By.xpath("//div/p/a[contains(text(), \"View All\")]"))) {
            click(By.xpath("//div/p/a[contains(text(), \"View All\")]"));
            waitUntilItemListPageIsLoaded();
        }

        click(By.linkText(itemName));
    }

    public int allItemsCount() {
        return wd.findElements(By.xpath("//a[2]/h2")).size();
    }
}

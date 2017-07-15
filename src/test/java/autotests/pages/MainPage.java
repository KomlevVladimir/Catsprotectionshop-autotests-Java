package autotests.pages;

import autotests.model.ItemData;
import autotests.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends BasePage {


    public MainPage(WebDriver wd) {
        super(wd);
    }

    public MainPage open()
    {
        wd.get("https://www.catsprotectionshop.co.uk/index.html");
        return this;
    }

    public void chooseCategory(String category)
    {
        wd.findElement(By.linkText(category)).click();
    }



}

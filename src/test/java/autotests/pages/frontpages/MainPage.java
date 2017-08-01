package autotests.pages.frontpages;

import autotests.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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

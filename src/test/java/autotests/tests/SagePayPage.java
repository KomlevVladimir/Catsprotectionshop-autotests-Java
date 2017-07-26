package autotests.tests;


import autotests.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SagePayPage extends BasePage {

    public SagePayPage(WebDriver wd) {
        super(wd);
    }

    public String getCurrentUrl() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//em[@class='payment-info__value']")));
        return wd.getCurrentUrl();
    }


}

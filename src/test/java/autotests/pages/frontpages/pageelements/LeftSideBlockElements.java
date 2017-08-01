package autotests.pages.frontpages.pageelements;


import autotests.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LeftSideBlockElements extends BasePage {

    public LeftSideBlockElements(WebDriver wd) {
        super(wd);
    }

    public void goToLinkByName(String name) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
                "//p[@class='navigateOnClick']/a[contains(text(), '" + name + "')]")));
        wd.findElement(By.xpath("//p[@class='navigateOnClick']/a[contains(text(), '" + name + "')]")).click();
    }
}

package autotests.pages.frontpages.pageelements;


import autotests.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeaderBlockElements extends BasePage {

    public HeaderBlockElements(WebDriver wd) {
        super(wd);
        PageFactory.initElements(wd, this);
    }

    @FindBy(xpath = "//input[@class='button quick-search-button']")
    public WebElement buttonSearch;

    public void searchByWords(String words) {
        fillForm(By.xpath("//form/input[@class='quick-search-text']"), words);
        click(By.xpath("//input[@class='button quick-search-button']"));
    }
}

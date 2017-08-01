package autotests.pages.frontpages;


import autotests.model.ItemData;
import autotests.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ViewItemPage extends BasePage {

    public ViewItemPage(WebDriver wd) {
        super(wd);
        PageFactory.initElements(wd, this);
    }

    @FindBy(xpath = "//fieldset[@class='quantity-box']/input")
    public WebElement quantityInput;

    @FindBy(xpath = "//span[@class='product-price']/span")
    public WebElement priceText;

    @FindBy(xpath = "//input[@class='button cart-button']")
    public WebElement addToCartButton;

    @FindBy(xpath = "//form//p[3]")
    public WebElement refText;

    @FindBy(xpath = "//p[@class='product-image set-right']/a")
    public WebElement imageItem;

    public void setQuantity(String quantity) {
        fillForm(By.xpath("//fieldset[@class='quantity-box']/input"), quantity);
        wait.until(ExpectedConditions.visibilityOf(priceText));
    }

    public void addToCart() {
        click(By.xpath("//input[@class='button cart-button']"));
    }

    public ItemData getItem() {
        String itemName = wd.findElement(By.xpath("//span[@class='fn']/h1")).getText();
        String quantity = quantityInput.getAttribute("value");
        String price = priceText.getText();
        String ref = refText.getText().substring(5);
        return new ItemData().withName(itemName).withQuantity(quantity).withPrice(price).withRef(ref);
    }

    public boolean buttonAddToCartIsPresent() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@class='button cart-button']")));
        return isElementPresent(By.xpath("//input[@class='button cart-button']"));
    }

    public boolean imageIsZoomed() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//img[@id='sb-player']")));
        return isElementPresent(By.xpath("//img[@id='sb-player']"));
    }
}

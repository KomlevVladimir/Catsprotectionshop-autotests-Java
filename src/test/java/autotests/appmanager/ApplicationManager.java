package autotests.appmanager;


import autotests.model.ItemData;
import autotests.pages.CartPage;
import autotests.pages.CategoryPage;
import autotests.pages.MainPage;
import autotests.pages.ViewItemPage;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.ArrayList;
import java.util.List;

public class ApplicationManager {
    private WebDriver wd;

    private String browser;

    private MainPage mainPage;
    private CategoryPage categoryPage;
    private ViewItemPage viewItemPage;
    private CartPage cartPage;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }

    public void init() {
        switch (browser) {
            case BrowserType.FIREFOX:
                wd = new FirefoxDriver();
                break;

            case BrowserType.CHROME:
                wd = new ChromeDriver();
                break;

            case BrowserType.IE:
                wd = new InternetExplorerDriver();
                break;
        }

        mainPage = new MainPage(wd);
        categoryPage = new CategoryPage(wd);
        viewItemPage = new ViewItemPage(wd);
        cartPage = new CartPage(wd);
    }

    public void stop() {
        wd.quit();
    }

    public void ChooseItem(ItemData itemData)
    {
        mainPage.open().chooseCategory(itemData.getItemCategory());
        categoryPage.gotToViewItemPage(itemData.getItemName());
        viewItemPage.setQuantity(itemData.getQuantity());
    }

    public void addToCart()
    {
        viewItemPage.addToCart();
    }

    public ItemData getItemFromViewPage()
    {
        return viewItemPage.getItem();
    }

    public boolean isInTheCartPage()
    {
        return cartPage.shoppingCartTitle.getText().equals("Shopping Cart");
    }

    public List<ItemData> getItemsFromCartPage() {
        return cartPage.getItems();
    }

}




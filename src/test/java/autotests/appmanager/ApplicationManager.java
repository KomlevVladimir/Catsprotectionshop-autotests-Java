package autotests.appmanager;


import autotests.model.ClientData;
import autotests.model.ItemData;
import autotests.pages.*;
import autotests.pages.SagePayPage;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.List;

import static java.lang.Float.parseFloat;

public class ApplicationManager {
    private WebDriver wd;

    private String browser;

    private MainPage mainPage;
    private CategoryPage categoryPage;
    private ViewItemPage viewItemPage;
    private CartPage cartPage;
    private CheckoutPage checkoutPage;
    private SagePayPage sagePayPage;

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
        checkoutPage = new CheckoutPage(wd);
        sagePayPage = new SagePayPage(wd);
    }

    public void stop() {
        wd.quit();
    }

    public void chooseItem(ItemData itemData)
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

    public boolean isOnTheCartPage()
    {
        return cartPage.shoppingCartTitle.getText().equals("Shopping Cart");
    }

    public List<ItemData> getItemsFromCartPage() {
        return cartPage.getItems();
    }

    public void changeQuantityTo(String changedQuantity) {
        cartPage.changeQuantity(changedQuantity);
    }

    public void updateCart() {
        cartPage.buttonUpdate.click();
    }

    public float costOfItemOnTheCartPage(ItemData item) {
        return parseFloat(cartPage.getCostByItem(item));
    }

    public void removeItem(ItemData item) {
        cartPage.activateCheckboxToRemoveItem(item);
        cartPage.buttonUpdate.click();
    }

    public ItemData itemFromCartPageWithName(String name) {
        return cartPage.getItemByName(name);
    }

    public void continueShopping() {
        cartPage.buttonContinueShopping.click();
    }

    public boolean isOnTheViewItemPage() {
         return viewItemPage.buttonAddToCartIsPresent();
    }

    public void enterInvoiceAddress(ClientData clientData) {
        cartPage.buttonCheckoutNow.click();
        checkoutPage.enterInvoiceAddress(
                clientData.getSalutation(), clientData.getFirstName(), clientData.getLastName(),
                clientData.getAddress(), clientData.getCity(), clientData.getCountry(),
                clientData.getPostCode(), clientData.getPhoneNumber(),
                clientData.getEmailAddress(), clientData.getConfirmEmailAddress());
    }

    public void enterDeliveryAddress(ClientData clientData) {
        checkoutPage.checkboxDeliveryAddress.click();
        checkoutPage.enterDeliveryAddress(
                clientData.getFirstName(), clientData.getLastName(), clientData.getAddress(),
                clientData.getCity(), clientData.getCountry(), clientData.getPostCode(),
                clientData.getPhoneNumber(), clientData.getEmailAddress(),
                clientData.getConfirmEmailAddress());
    }

    public void acceptConditions() {
        checkoutPage.buttonNext.click();
        checkoutPage.checkboxAgreements.click();
        checkoutPage.buttonNext.click();
    }

    public ClientData invoiceAddress() {
        return checkoutPage.invoiceAddress();
    }

    public ClientData deliveryAddress() {
        return checkoutPage.deliveryAddress();
    }

    public void clientConfirmOrder() {
        checkoutPage.buttonConfirmOrder.click();
    }

    public boolean isOnTheSagePayPage() {
        return sagePayPage.getCurrentUrl().contains("https://checkout.sagepay.com/");
    }

    public void goToCheckoutSecondStep() {
        checkoutPage.buttonNext.click();
    }

    public boolean isInvalidAddress() {
        return  checkoutPage.textErrorMessageIsPresent();
    }

    public float costSumOfItems() {
        return cartPage.getCostSum();
    }

    public float totalOnTheCartPage() {
         return cartPage.getTotal();
    }

    public void chooseCategoryByName(String name) {
        mainPage.open().chooseCategory(name);
    }

    public int allItemsInCategory() {
        String textViewAll = categoryPage.linkViewAll.getText();
        return Integer.parseInt(textViewAll.substring(textViewAll.indexOf('(') + 1, textViewAll.indexOf(')')));
    }

    public void clickViewAll() {
        categoryPage.waitUntilItemListPageIsLoaded();
        categoryPage.linkViewAll.click();
    }

   public int itemsCountOnCategoryPage() {
        return categoryPage.allItemsCount();
   }

    public void goToViewPage(ItemData itemData)
    {
        mainPage.open().chooseCategory(itemData.getItemCategory());
        categoryPage.gotToViewItemPage(itemData.getItemName());
    }

    public void previewItem() {
        viewItemPage.imageItem.click();
    }

    public boolean zoomedImageIsDisplayed() {
        return viewItemPage.imageIsZoomed();
    }

    public void addItemToCart(ItemData itemData)
    {
        mainPage.open().chooseCategory(itemData.getItemCategory());
        categoryPage.gotToViewItemPage(itemData.getItemName());
        viewItemPage.setQuantity(itemData.getQuantity());
        viewItemPage.addToCart();
    }


}




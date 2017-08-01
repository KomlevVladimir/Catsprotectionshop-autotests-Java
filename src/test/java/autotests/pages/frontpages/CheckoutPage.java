package autotests.pages.frontpages;


import autotests.model.ClientData;
import autotests.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage extends BasePage {

    public CheckoutPage(WebDriver wd) {
        super(wd);
        PageFactory.initElements(wd, this);
    }

    @FindBy(name = "INVOICESALUTATION")
    public WebElement inputSalutation;

    @FindBy(name = "INVOICEFIRSTNAME")
    public WebElement inputInvoiceFirstName;

    @FindBy(name = "INVOICELASTNAME")
    public WebElement inputInvoiceLastName;

    @FindBy(name = "INVOICEADDRESS1")
    public WebElement inputInvoiceAddress;

    @FindBy(name = "INVOICEADDRESS3")
    public WebElement inputInvoiceCity;

    @FindBy(name = "LocationInvoiceCountry")
    public WebElement selectInvoiceCountry;

    @FindBy(name = "INVOICEPOSTALCODE")
    public WebElement inputInvoicePostCode;

    @FindBy(name = "INVOICEPHONE")
    public WebElement inputInvoicePhoneNumber;

    @FindBy(name = "INVOICEEMAIL")
    public WebElement inputInvoiceEmailAddress;

    @FindBy(name = "INVOICEEMAIL_CONFIRM")
    public WebElement inputInvoiceConfirmEmailAddress;

    @FindBy(xpath = "//input[@id='idBtnNext']")
    public WebElement buttonNext;

    @FindBy(xpath = "//div[@class='checkout'][2]/input[@id='idAGREETERMSCONDITIONS']")
    public WebElement checkboxAgreements;

    @FindBy(xpath = "//table[@class='checkout confirmCustomerAddress']/tbody/tr[3]/td[1]")
    public WebElement textInvoiceAddress;

    @FindBy(xpath = "//table[@class='checkout confirmCustomerAddress']/tbody/tr[3]/td[2]")
    public WebElement textDeliveryAddress;

    @FindBy(xpath = "//input[@id='idBtnConfirm']")
    public WebElement buttonConfirmOrder;

    @FindBy(xpath = "//input[@id='idSEPARATESHIP']")
    public WebElement checkboxDeliveryAddress;

    @FindBy(name = "DELIVERFIRSTNAME")
    public WebElement inputDeliveryFirstName;

    @FindBy(name = "DELIVERLASTNAME")
    public WebElement inputDeliveryLastName;

    @FindBy(name = "DELIVERADDRESS1")
    public WebElement inputDeliveryAddress;

    @FindBy(name = "DELIVERADDRESS3")
    public WebElement inputDeliveryCity;

    @FindBy(name = "LocationDeliveryCountry")
    public WebElement selectDeliveryCountry;

    @FindBy(name = "DELIVERPOSTALCODE")
    public WebElement inputDeliveryPostCode;

    @FindBy(name = "DELIVERPHONE")
    public WebElement inputDeliveryPhoneNumber;

    @FindBy(name = "DELIVEREMAIL")
    public WebElement inputDeliveryEmailAddress;

    @FindBy(name = "DELIVEREMAIL_CONFIRM")
    public WebElement inputDeliveryConfirmEmailAddress;

    public void enterInvoiceAddress(
            String salutation, String firstName, String lastName, String address, String city,
            String country, String postCode, String phoneNumber, String emailAddress, String confirmEmailAddress) {
        inputSalutation.sendKeys(salutation);
        inputInvoiceFirstName.sendKeys(firstName);
        inputInvoiceLastName.sendKeys(lastName);
        inputInvoiceAddress.sendKeys(address);
        inputInvoiceCity.sendKeys(city);
        new Select(selectInvoiceCountry).selectByVisibleText(country);
        inputInvoicePostCode.sendKeys(postCode);
        inputInvoicePhoneNumber.sendKeys(phoneNumber);
        inputInvoiceEmailAddress.sendKeys(emailAddress);
        inputInvoiceConfirmEmailAddress.sendKeys(confirmEmailAddress);
    }

    public void enterDeliveryAddress(
             String firstName, String lastName, String address, String city, String country,
             String postCode, String phoneNumber, String emailAddress, String confirmEmailAddress) {
        inputDeliveryFirstName.sendKeys(firstName);
        inputDeliveryLastName.sendKeys(lastName);
        inputDeliveryAddress.sendKeys(address);
        inputDeliveryCity.sendKeys(city);
        new Select(selectDeliveryCountry).selectByVisibleText(country);
        inputDeliveryPostCode.sendKeys(postCode);
        inputDeliveryPhoneNumber.sendKeys(phoneNumber);
        inputDeliveryEmailAddress.sendKeys(emailAddress);
        inputDeliveryConfirmEmailAddress.sendKeys(confirmEmailAddress);
    }

    public ClientData invoiceAddress() {
        String[] data = textInvoiceAddress.getText().split("\n");
        String[] names = data[0].split(" ");
        return new ClientData().withFirstName(names[0]).withLastName(names[1])
                .withAddress(data[1]).withCity(data[2]).withPostCode(data[3])
                .withCountry(data[4]).withPhoneNumber(data[5]).withEmailAddress(data[6]);
    }

    public ClientData deliveryAddress() {
        String[] data = textDeliveryAddress.getText().split("\n");
        String[] names = data[0].split(" ");
        return new ClientData().withFirstName(names[0]).withLastName(names[1])
                .withAddress(data[1]).withCity(data[2]).withPostCode(data[3])
                .withCountry(data[4]).withPhoneNumber(data[5]).withEmailAddress(data[6]);
    }

    public boolean textErrorMessageIsPresent() {
        return isElementPresent(By.xpath("//span[@class='actrequiredcolor']/blockquote"));
    }



}

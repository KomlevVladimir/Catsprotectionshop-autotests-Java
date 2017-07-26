package autotests.tests;

import autotests.model.ClientData;
import autotests.model.ItemData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckoutTests extends TestBase {

    @BeforeMethod
    public void itemIsAddedToCart() {
        ItemData item = new ItemData().inCategory("Sale").
                withName("Bah Humbug Tin with Mint Humbugs").withQuantity("1");
        app.chooseItem(item);
        app.addToCart();
    }

    @Test
    public void checkoutWithOnlyInvoiceAddressTests() {
        ClientData clientInvoiceAddress = new ClientData().withSalutation("Mr").withFirstName("John")
                .withLastName("Doe").withAddress("115 4th street").withCity("London")
                .withCountry("United Kingdom").withPostCode("10001").withPhoneNumber("3309875")
                .withEmailAddress("Johndoe@mailinator.com")
                .withConfirmEmailAddress("Johndoe@mailinator.com");
        app.enterInvoiceAddress(clientInvoiceAddress);
        app.acceptConditions();
        ClientData invoiceAddress = app.invoiceAddress();
        ClientData deliveryAddress = app.deliveryAddress();
        Assert.assertEquals(invoiceAddress, clientInvoiceAddress);
        Assert.assertEquals(invoiceAddress, deliveryAddress);
        app.clientConfirmOrder();
        Assert.assertTrue(app.isOnTheSagePayPage());
    }

    @Test
    public void checkoutWithDeliveryAddressTests() {
        ClientData clientInvoiceAddress = new ClientData().withSalutation("Mrs").withFirstName("Catherine")
                .withLastName("Johnson").withAddress("109 5th avenue").withCity("London")
                .withCountry("United Kingdom").withPostCode("10002").withPhoneNumber("904569382")
                .withEmailAddress("Cathy@mailinator.com")
                .withConfirmEmailAddress("Cathy@mailinator.com");
        ClientData clientDeliveryAddress = new ClientData().withFirstName("Ivan")
                .withLastName("Petrov").withAddress("Shaftesbury Avenue").withCity("London")
                .withCountry("United Kingdom").withPostCode("10003").withPhoneNumber("5559422")
                .withEmailAddress("Ivan@Petrov.com")
                .withConfirmEmailAddress("Ivan@Petrov.com");

        app.enterInvoiceAddress(clientInvoiceAddress);
        app.enterDeliveryAddress(clientDeliveryAddress);
        app.acceptConditions();
        ClientData invoiceAddress = app.invoiceAddress();
        ClientData deliveryAddress = app.deliveryAddress();

        Assert.assertEquals(invoiceAddress, clientInvoiceAddress);
        Assert.assertEquals(deliveryAddress, clientDeliveryAddress);
        app.clientConfirmOrder();
        Assert.assertTrue(app.isOnTheSagePayPage());

    }
}

package autotests.tests.cart;

import autotests.model.ClientData;
import autotests.model.ItemData;
import autotests.tests.DataProviders;
import autotests.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CheckoutTests extends TestBase {

    @BeforeMethod
    public void itemIsAddedToCart(Object[] testArgs) {
        ItemData item = (ItemData) testArgs[0];
        app.addItemToCart(item);
    }

    @Test(dataProvider = "checkoutInvoiceAddress", dataProviderClass = DataProviders.class)
    public void checkoutWithOnlyInvoiceAddressTests(ItemData item, ClientData clientInvoiceAddress) {
        app.enterInvoiceAddress(clientInvoiceAddress);
        app.acceptConditions();
        ClientData invoiceAddress = app.invoiceAddress();
        ClientData deliveryAddress = app.deliveryAddress();
        assertEquals(invoiceAddress, clientInvoiceAddress);
        assertEquals(invoiceAddress, deliveryAddress);
        app.clientConfirmOrder();
        assertTrue(app.isOnTheSagePayPage());
    }

    @Test(dataProvider = "checkoutDeliveryAddress", dataProviderClass = DataProviders.class)
    public void checkoutWithDeliveryAddressTests(
            ItemData item, ClientData clientInvoiceAddress, ClientData clientDeliveryAddress) {
        app.enterInvoiceAddress(clientInvoiceAddress);
        app.enterDeliveryAddress(clientDeliveryAddress);
        app.acceptConditions();
        ClientData invoiceAddress = app.invoiceAddress();
        ClientData deliveryAddress = app.deliveryAddress();
        assertEquals(invoiceAddress, clientInvoiceAddress);
        assertEquals(deliveryAddress, clientDeliveryAddress);
        app.clientConfirmOrder();
        assertTrue(app.isOnTheSagePayPage());
    }

    @Test(dataProvider = "invalidInvoiceAddress", dataProviderClass = DataProviders.class)
    public void checkoutWithInvalidDataTests(ItemData item, ClientData clientInvoiceAddress) {
        app.enterInvoiceAddress(clientInvoiceAddress);
        app.goToCheckoutSecondStep();
        assertTrue(app.isInvalidAddress());

    }
}

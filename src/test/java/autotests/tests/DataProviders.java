package autotests.tests;


import autotests.generators.ClientDataGenerator;
import autotests.generators.ItemDataGenerator;
import autotests.model.ClientData;
import autotests.model.ItemData;
import org.testng.annotations.DataProvider;

public class DataProviders {

    @DataProvider(name = "item")
    public static Object[][] itemToContinue() {
        ItemDataGenerator itemGenerator = new ItemDataGenerator();
        String category = itemGenerator.generateCategory();
        String item = itemGenerator.generateItem(category);
        String quantity = itemGenerator.generateQuantity();
        return new Object[][]{
                new Object[]{new ItemData().inCategory(category).withName(item).withQuantity(quantity)}
        };
    }

    @DataProvider(name = "items")
    public static Object[][] items() {
        ItemDataGenerator itemGenerator = new ItemDataGenerator();
        String categoryForFirstItem = itemGenerator.generateCategory();
        String firstItem = itemGenerator.generateItem(categoryForFirstItem);
        String firstQuantity = itemGenerator.generateQuantity();

        String categoryForSecondItem = itemGenerator.generateCategory();
        String secondItem = itemGenerator.generateItem(categoryForSecondItem);
        String secondQuantity = itemGenerator.generateQuantity();
        while (secondItem.equals(firstItem)) {
            secondItem = itemGenerator.generateItem(categoryForFirstItem);
        }
        String categoryForThirdItem = itemGenerator.generateCategory();
        String thirdItem = itemGenerator.generateItem(categoryForThirdItem);
        String thirdQuantity = itemGenerator.generateQuantity();

        while (thirdItem.equals(firstItem) || thirdItem.equals(secondItem)) {
            thirdItem = itemGenerator.generateItem(categoryForThirdItem);
        }
        return new Object[][]{
                {new ItemData().inCategory(categoryForFirstItem).withName(firstItem).withQuantity(firstQuantity),
                new ItemData().inCategory(categoryForSecondItem).withName(secondItem).withQuantity(secondQuantity),
                new ItemData().inCategory(categoryForThirdItem).withName(thirdItem).withQuantity(thirdQuantity)},
        };
    }

    @DataProvider(name = "update")
    public static Object[][] itemUpdate() {
        ItemDataGenerator itemGenerator = new ItemDataGenerator();
        String category = itemGenerator.generateCategory();
        String item = itemGenerator.generateItem(category);
        String quantity = itemGenerator.generateQuantity();
        String newQuantity = itemGenerator.generateQuantity();
        if (newQuantity.equals(quantity)) {
            while (!newQuantity.equals(quantity)) {
                newQuantity = itemGenerator.generateQuantity();
            }
        }
        return new Object[][]{
                new Object[]{new ItemData().inCategory(category).withName(item).withQuantity(quantity), newQuantity},

        };
    }

    @DataProvider(name = "checkoutInvoiceAddress")
    public static Object[][] invoiceAddress() {
        ItemDataGenerator itemGenerator = new ItemDataGenerator();
        ClientDataGenerator clientGenerator = new ClientDataGenerator();
        String category = itemGenerator.generateCategory();
        String item = itemGenerator.generateItem(category);
        String quantity = itemGenerator.generateQuantity();
        String salutation = clientGenerator.generateSalutation();
        String firstName = clientGenerator.generateFirstName();
        String lastName = clientGenerator.generateLastName();
        String address = clientGenerator.generateAddress();
        String city = clientGenerator.generateCity();
        String country = clientGenerator.generateCountry();
        String postCode = clientGenerator.generatePostCode();
        String phoneNumber = clientGenerator.generatePhoneNumber();
        String emailAddress = clientGenerator.generateEmailAddress();

        return new Object[][]{
                new Object[]{new ItemData().inCategory(category).withName(item).withQuantity(quantity),
                new ClientData().withSalutation(salutation).withFirstName(firstName).withLastName(lastName)
                        .withAddress(address).withCity(city).withCountry(country).withPostCode(postCode)
                        .withPhoneNumber(phoneNumber).withEmailAddress(emailAddress)
                        .withConfirmEmailAddress(emailAddress)}
        };
    }

    @DataProvider(name = "checkoutDeliveryAddress")
    public static Object[][] deliveryAddress() {
        ItemDataGenerator itemGenerator = new ItemDataGenerator();
        ClientDataGenerator clientGenerator = new ClientDataGenerator();
        String category = itemGenerator.generateCategory();
        String item = itemGenerator.generateItem(category);
        String quantity = itemGenerator.generateQuantity();
        String salutation = clientGenerator.generateSalutation();
        String invoiceFirstName = clientGenerator.generateFirstName();
        String invoiceLastName = clientGenerator.generateLastName();
        String invoiceAddress = clientGenerator.generateAddress();
        String invoiceCity = clientGenerator.generateCity();
        String invoiceCountry = clientGenerator.generateCountry();
        String invoicePostCode = clientGenerator.generatePostCode();
        String invoicePhoneNumber = clientGenerator.generatePhoneNumber();
        String invoiceEmailAddress = clientGenerator.generateEmailAddress();
        String deliveryFirstName = clientGenerator.generateFirstName();
        String deliveryLastName = clientGenerator.generateLastName();
        String deliveryAddress = clientGenerator.generateAddress();
        String deliveryCity = clientGenerator.generateCity();
        String deliveryCountry = clientGenerator.generateCountry();
        String deliveryPostCode = clientGenerator.generatePostCode();
        String deliveryPhoneNumber = clientGenerator.generatePhoneNumber();
        String deliveryEmailAddress = clientGenerator.generateEmailAddress();

        return new Object[][]{
                new Object[]{new ItemData().inCategory(category).withName(item).withQuantity(quantity),
                        new ClientData().withSalutation(salutation).withFirstName(invoiceFirstName)
                                .withLastName(invoiceLastName).withAddress(invoiceAddress).withCity(invoiceCity)
                                .withCountry(invoiceCountry).withPostCode(invoicePostCode)
                                .withPhoneNumber(invoicePhoneNumber).withEmailAddress(invoiceEmailAddress)
                                .withConfirmEmailAddress(invoiceEmailAddress),
                        new ClientData().withSalutation(salutation).withFirstName(deliveryFirstName)
                        .withLastName(deliveryLastName).withAddress(deliveryAddress).withCity(deliveryCity)
                        .withCountry(deliveryCountry).withPostCode(deliveryPostCode)
                        .withPhoneNumber(deliveryPhoneNumber).withEmailAddress(deliveryEmailAddress)
                        .withConfirmEmailAddress(deliveryEmailAddress)}
        };
    }

    @DataProvider(name = "invalidInvoiceAddress")
    public static Object[][] invalidInvoiceAddress() {
        ItemDataGenerator itemGenerator = new ItemDataGenerator();
        ClientDataGenerator clientGenerator = new ClientDataGenerator();
        String category = itemGenerator.generateCategory();
        String item = itemGenerator.generateItem(category);
        String quantity = itemGenerator.generateQuantity();
        String salutation = clientGenerator.generateSalutation();
        String firstName = " ";
        String lastName = " ";
        String address = clientGenerator.generateAddress();
        String city = clientGenerator.generateCity();
        String country = clientGenerator.generateCountry();
        String postCode = clientGenerator.generatePostCode();
        String phoneNumber = clientGenerator.generatePhoneNumber();
        String emailAddress = clientGenerator.generateEmailAddress();

        return new Object[][]{
                new Object[]{new ItemData().inCategory(category).withName(item).withQuantity(quantity),
                        new ClientData().withSalutation(salutation).withFirstName(firstName).withLastName(lastName)
                                .withAddress(address).withCity(city).withCountry(country).withPostCode(postCode)
                                .withPhoneNumber(phoneNumber).withEmailAddress(emailAddress)
                                .withConfirmEmailAddress(emailAddress)}
        };
    }



}




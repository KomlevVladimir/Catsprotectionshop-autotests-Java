package autotests.tests;


import autotests.generators.ClientDataGenerator;
import autotests.generators.ItemDataGenerator;
import autotests.model.ClientData;
import autotests.model.ItemData;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
            if (newQuantity.equals(quantity)) {
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

    @DataProvider(name = "category")
    public static Object[][] category() {
        ItemDataGenerator itemGenerator = new ItemDataGenerator();
        String category = itemGenerator.generateCategory();
        while (category.equals("Sale")) {
            category = itemGenerator.generateCategory();
        }
        return new Object[][]{
                new Object[]{category}
        };
    }

    @DataProvider(name = "leftSideLinks")
    public static Iterator<Object[]> leftSideLinks() {
        List<Object[]> list = new ArrayList<Object[]>();
        list.add(new Object[] {"Home", "https://www.catsprotectionshop.co.uk/index.html"});
        list.add(new Object[] {"About Cats Protection",
                "https://www.catsprotectionshop.co.uk/acatalog/About-Cats-Protection.html"});
        list.add(new Object[] {"Cookie Policy", "https://www.catsprotectionshop.co.uk/acatalog/Cookie-Policy.html"});
        list.add(new Object[] {"Delivery", "https://www.catsprotectionshop.co.uk/acatalog/Delivery.html"});
        list.add(new Object[] {"Contact Us", "https://www.catsprotectionshop.co.uk/acatalog/Contact-Us.html"});
        return  list.iterator();

    }

    @DataProvider(name = "footerLinks")
    public static Iterator<Object[]> footerLinks() {
        List<Object[]> list = new ArrayList<Object[]>();
        list.add(new Object[] {"Contact Us", "https://www.catsprotectionshop.co.uk/acatalog/Contact-Us.html"});
        list.add(new Object[] {"Terms & Conditions", "https://www.catsprotectionshop.co.uk/acatalog/info.html"});
        list.add(new Object[] {"Site Map", "https://www.catsprotectionshop.co.uk/acatalog/sitemap.html"});
        list.add(new Object[] {"Privacy & Security Information",
                "https://www.catsprotectionshop.co.uk/acatalog/info.html"});
        return  list.iterator();

    }

    @DataProvider(name = "categoryLinks")
    public static Iterator<Object[]> categoryLinks() {
        List<Object[]> list = new ArrayList<Object[]>();
        list.add(new Object[] {"Sale", "https://www.catsprotectionshop.co.uk/acatalog/Sale.html"});
        list.add(new Object[] {"Donate", "https://www.catsprotectionshop.co.uk/acatalog/Donate-1.html"});
        list.add(new Object[] {"Exclusives", "https://www.catsprotectionshop.co.uk/acatalog/Offers-p1.html"});
        list.add(new Object[] {"Black Cat Day", "https://www.catsprotectionshop.co.uk/acatalog/Black-Cat-Day-p1.html"});
        list.add(new Object[] {"Christmas", "https://www.catsprotectionshop.co.uk/acatalog/Gift-Wrap-Collection-p1.html"});
        list.add(new Object[] {"Gifts", "https://www.catsprotectionshop.co.uk/acatalog/Gifts-p1.html"});
        list.add(new Object[] {"Home & Kitchen", "https://www.catsprotectionshop.co.uk/acatalog/Home-p1.html"});
        list.add(new Object[] {"Cat Gifts", "https://www.catsprotectionshop.co.uk/acatalog/Pet-Gifts-p1.html"});
        return  list.iterator();

    }

    @DataProvider(name = "anyWord")
    public static Object[][] anySearchWord() {
        String itemName = "cat";

        return new Object[][]{
                new Object[]{itemName}
        };
    }

    @DataProvider(name = "allWords")
    public static Object[][] allSearchWord() {
        String itemName = "Black Cat Shopper";

        return new Object[][]{
                new Object[]{itemName}
        };
    }


    @DataProvider(name = "price")
    public static Object[][] price() {
        ItemDataGenerator itemGenerator = new ItemDataGenerator();
        String price = itemGenerator.generatePrice();
        String words = "";

        return new Object[][]{
                new Object[]{price, words}
        };
    }

    @DataProvider(name = "nonexistenItemName")
    public static Object[][] seatchNonexistenItem() {
        String itemName = "dog";

        return new Object[][]{
                new Object[]{itemName}
        };
    }

}




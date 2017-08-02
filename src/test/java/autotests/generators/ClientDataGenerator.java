package autotests.generators;


import com.github.javafaker.Faker;

public class ClientDataGenerator {

    public String  generateSalutation() {
        int number = 1 + (int) (Math.random() * ((2 - 1) + 1));
        String salutation = "";
        switch (number) {
            case 1:
                salutation = "Mr";
                break;
            case 2:
                salutation = "Mrs";
                break;
        }
        return salutation;
    }

    public String generateFirstName() {
        Faker faker = new Faker();
        return faker.name().firstName();

    }

    public String generateLastName() {
        Faker faker = new Faker();
        return faker.name().lastName();
    }

    public String generateAddress() {
        Faker faker = new Faker();
        return faker.address().streetAddress();
    }

    public String generateCity() {
        Faker faker = new Faker();
        return faker.address().cityName();
    }

    public String generateCountry() {
        return "United Kingdom";
    }

    public String generatePostCode() {
        Faker faker = new Faker();
        return faker.address().zipCode();
    }

    public String generatePhoneNumber() {
        Faker faker = new Faker();
        return faker.phoneNumber().phoneNumber();
    }

    public String generateEmailAddress() {
        Faker faker = new Faker();
        return faker.internet().emailAddress();
    }

}

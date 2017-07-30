package autotests.generators;


import com.github.javafaker.Faker;

import java.util.Random;

public class ClientDataGenerator {

    public String  generateSalutation() {
        Random rnd = new Random();
        int number = rnd.nextInt(1);
        String salutation = "";
        switch (number) {
            case 0:
                salutation = "Mr";
                break;
            case 1:
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

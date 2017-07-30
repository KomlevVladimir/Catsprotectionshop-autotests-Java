package autotests.generators;


import java.util.Random;

public class ItemDataGenerator {

    public String  generateCategory() {
        Random rnd = new Random();
        int number = rnd.nextInt(6);
        String category = "";
        switch (number) {
            case 0:
                category = "Sale";
                break;
            case 1:
                category = "Exclusives";
                break;
            case 2:
                category = "Black Cat Day";
                break;
            case 3:
                category = "Christmas";
                break;
            case 4:
                category = "Gifts";
                break;
            case 5:
                category = "Home & Kitchen";
                break;
            case 6:
                category = "Cat Gifts";
                break;
        }
        return category;
    }

    public String generateItem(String category) {
        Random rnd = new Random();
        int number = rnd.nextInt(6);
        String itemName = "";

        switch (category) {
            case "Sale":
                itemName = "Bah Humbug Tin with Mint Humbugs";
                break;
            case "Exclusives":
                switch (number) {
                    case 0:
                        itemName = "Cats Protection Funky Felines List Pad";
                        break;
                    case 1:
                        itemName = "Cats Protection A5 Notebook";
                        break;
                    case 2:
                        itemName = "Cats Protection A6 Notebook";
                        break;
                    case 3:
                        itemName = "Cats Protection Mini Magnetic Notepad";
                        break;
                    case 4:
                        itemName = "Cats Protection Beautiful Cat Notecards";
                        break;
                    case 5:
                        itemName = "Cats Protection Mini Notecard Pack - Tabby Kitten";
                        break;
                    case 6:
                        itemName = "Cats Protection Mini Notecard Pack - Sleeping Kitten";
                        break;
                }
                break;
            case "Black Cat Day":
                switch (number) {
                    case 0:
                        itemName = "Peeking Cat Treat Tin";
                        break;
                    case 1:
                        itemName = "Cat Chalkboard";
                        break;
                    case 2:
                        itemName = "Black Cat Tea Time Gift Set";
                        break;
                    case 3:
                        itemName = "Black Cat Cool Bag";
                        break;
                    case 4:
                        itemName = "Black Cat Tea Towel";
                        break;
                    case 5:
                        itemName = "Black Cat Shopper";
                        break;
                    case 6:
                        itemName = "Cats Protection Funky Felines List Pad";
                        break;
                }
                break;
            case "Christmas":
                switch (number) {
                    case 0:
                        itemName = "Ginger Cat Bauble";
                        break;
                    case 1:
                        itemName = "Santa and Friends Race Crackers";
                        break;
                    case 2:
                        itemName = "Tree of Baubles Decoration";
                        break;
                    case 3:
                        itemName = "Black Cat Bauble";
                        break;
                    case 4:
                        itemName = "Crystal Guardian Angels";
                        break;
                    case 5:
                        itemName = "Cat and Moon Spinning Tea Light Holder";
                        break;
                    case 6:
                        itemName = "Moon Cats Crystal Fantasy";
                        break;
                }
                break;
            case "Gifts":
                switch (number) {
                    case 0:
                        itemName = "Tipsy Selection";
                        break;
                    case 1:
                        itemName = "Marzipan Fruits";
                        break;
                    case 2:
                        itemName = "White Willow Gift Basket";
                        break;
                    case 3:
                        itemName = "Catitudes Compact Mirror";
                        break;
                    case 4:
                        itemName = "Bah Humbug Tin with Mint Humbugs";
                        break;
                    case 5:
                        itemName = "Kitten Mini Umbrella";
                        break;
                    case 6:
                        itemName = "Knitted Cat Microwavable Hottie";
                        break;
                }
                break;
            case "Home & Kitchen":
                switch (number) {
                    case 0:
                        itemName = "Cat Bag Tidy";
                        break;
                    case 1:
                        itemName = "Cats and Butterflies Mat";
                        break;
                    case 2:
                        itemName = "Cat Chalkboard";
                        break;
                    case 3:
                        itemName = "Black Cat Tea Time Gift Set";
                        break;
                    case 4:
                        itemName = "Cats in Waiting - Tea Towel";
                        break;
                    case 5:
                        itemName = "Cats in Waiting - Coasters";
                        break;
                    case 6:
                        itemName = "Cosy Cats Tea Cosy";
                        break;
                }
                break;
            case "Cat Gifts":
                switch (number) {
                    case 0:
                        itemName = "Catnip Sack";
                        break;
                    case 1:
                        itemName = "Morocco Cat Bed";
                        break;
                    case 2:
                        itemName = "Santa's Trouser Tunnel";
                        break;
                    case 3:
                        itemName = "Snuggle Plush Pyramid Cat Bed Grey/Cream";
                        break;
                    case 4:
                        itemName = "Spotty Pyramid Cat Bed";
                        break;
                    case 5:
                        itemName = "Kumfy Kradle";
                        break;
                    case 6:
                        itemName = "Gracie and Milly Catnip Cat Toys";
                        break;
                }
                break;
        }
        return itemName;
    }

    public String generateQuantity() {
        int quantity = 1 + (int) (Math.random() * ((10 - 1) + 1));
        return String.valueOf(quantity);
    }


}

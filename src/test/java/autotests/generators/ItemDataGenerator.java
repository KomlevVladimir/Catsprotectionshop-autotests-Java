package autotests.generators;


public class ItemDataGenerator {

    public String  generateCategory() {
        int number = 1 + (int) (Math.random() * ((7 - 1) + 1));
        String category = "";
        switch (number) {
            case 1:
                category = "Sale";
                break;
            case 2:
                category = "Exclusives";
                break;
            case 3:
                category = "Black Cat Day";
                break;
            case 4:
                category = "Christmas";
                break;
            case 5:
                category = "Gifts";
                break;
            case 6:
                category = "Home & Kitchen";
                break;
            case 7:
                category = "Cat Gifts";
                break;
        }
        return category;
    }

    public String generateItem(String category) {
        int number = 1 + (int) (Math.random() * ((7 - 1) + 1));
        String itemName = "";

        switch (category) {
            case "Sale":
                itemName = "Bah Humbug Tin with Mint Humbugs";
                break;
            case "Exclusives":
                switch (number) {
                    case 1:
                        itemName = "Cats Protection Funky Felines List Pad";
                        break;
                    case 2:
                        itemName = "Cats Protection A5 Notebook";
                        break;
                    case 3:
                        itemName = "Cats Protection A6 Notebook";
                        break;
                    case 4:
                        itemName = "Cats Protection Mini Magnetic Notepad";
                        break;
                    case 5:
                        itemName = "Cats Protection Beautiful Cat Notecards";
                        break;
                    case 6:
                        itemName = "Cats Protection Mini Notecard Pack - Tabby Kitten";
                        break;
                    case 7:
                        itemName = "Cats Protection Mini Notecard Pack - Sleeping Kitten";
                        break;
                }
                break;
            case "Black Cat Day":
                switch (number) {
                    case 1:
                        itemName = "Peeking Cat Treat Tin";
                        break;
                    case 2:
                        itemName = "Cat Chalkboard";
                        break;
                    case 3:
                        itemName = "Black Cat Tea Time Gift Set";
                        break;
                    case 4:
                        itemName = "Black Cat Cool Bag";
                        break;
                    case 5:
                        itemName = "Black Cat Tea Towel";
                        break;
                    case 6:
                        itemName = "Black Cat Shopper";
                        break;
                    case 7:
                        itemName = "Cats Protection Funky Felines List Pad";
                        break;
                }
                break;
            case "Christmas":
                switch (number) {
                    case 1:
                        itemName = "Ginger Cat Bauble";
                        break;
                    case 2:
                        itemName = "Santa and Friends Race Crackers";
                        break;
                    case 3:
                        itemName = "Tree of Baubles Decoration";
                        break;
                    case 4:
                        itemName = "Black Cat Bauble";
                        break;
                    case 5:
                        itemName = "Crystal Guardian Angels";
                        break;
                    case 6:
                        itemName = "Cat and Moon Spinning Tea Light Holder";
                        break;
                    case 7:
                        itemName = "Moon Cats Crystal Fantasy";
                        break;
                }
                break;
            case "Gifts":
                switch (number) {
                    case 1:
                        itemName = "Tipsy Selection";
                        break;
                    case 2:
                        itemName = "Marzipan Fruits";
                        break;
                    case 3:
                        itemName = "White Willow Gift Basket";
                        break;
                    case 4:
                        itemName = "Catitudes Compact Mirror";
                        break;
                    case 5:
                        itemName = "Bah Humbug Tin with Mint Humbugs";
                        break;
                    case 6:
                        itemName = "Kitten Mini Umbrella";
                        break;
                    case 7:
                        itemName = "Knitted Cat Microwavable Hottie";
                        break;
                }
                break;
            case "Home & Kitchen":
                switch (number) {
                    case 1:
                        itemName = "Cat Bag Tidy";
                        break;
                    case 2:
                        itemName = "Cats and Butterflies Mat";
                        break;
                    case 3:
                        itemName = "Cat Chalkboard";
                        break;
                    case 4:
                        itemName = "Black Cat Tea Time Gift Set";
                        break;
                    case 5:
                        itemName = "Cats in Waiting - Tea Towel";
                        break;
                    case 6:
                        itemName = "Cats in Waiting - Coasters";
                        break;
                    case 7:
                        itemName = "Cosy Cats Tea Cosy";
                        break;
                }
                break;
            case "Cat Gifts":
                switch (number) {
                    case 1:
                        itemName = "Catnip Sack";
                        break;
                    case 2:
                        itemName = "Morocco Cat Bed";
                        break;
                    case 3:
                        itemName = "Santa's Trouser Tunnel";
                        break;
                    case 4:
                        itemName = "Snuggle Plush Pyramid Cat Bed Grey/Cream";
                        break;
                    case 5:
                        itemName = "Spotty Pyramid Cat Bed";
                        break;
                    case 6:
                        itemName = "Festive Frenzies Reindeer Teaser";
                        break;
                    case 7:
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

    public String generatePrice() {
        int priceValue =  1 + (int) (Math.random() * ((5 - 1) + 1));
        return Integer.toString(priceValue);
    }


}

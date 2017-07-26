package autotests.model;

public class ItemData {
    private String itemName;
    private String itemCategory;
    private String quantity;
    private String price;
    private String ref;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ItemData itemData = (ItemData) o;

        if (itemName != null ? !itemName.equals(itemData.itemName) : itemData.itemName != null) return false;
        if (quantity != null ? !quantity.equals(itemData.quantity) : itemData.quantity != null) return false;
        if (price != null ? !price.equals(itemData.price) : itemData.price != null) return false;
        return ref != null ? ref.equals(itemData.ref) : itemData.ref == null;
    }

    @Override
    public int hashCode() {
        int result = itemName != null ? itemName.hashCode() : 0;
        result = 31 * result + (quantity != null ? quantity.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (ref != null ? ref.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ItemData{" +
                "itemName='" + itemName + '\'' +
                ", quantity='" + quantity + '\'' +
                ", price='" + price + '\'' +
                ", ref='" + ref + '\'' +
                '}';
    }

    public String getItemName()
    {
        return itemName;
    }

    public String getItemCategory()
    {
        return itemCategory;
    }

    public String getQuantity()
    {
        return quantity;
    }

    public String getPrice()
    {
        return price;
    }

    public String getRef() { return ref; }


    public ItemData withName(String itemName) {
        this.itemName = itemName;
        return this;
    }

    public ItemData inCategory(String itemCategory) {
        this.itemCategory = itemCategory;
        return this;
    }

    public ItemData withQuantity(String quantity) {
        this.quantity = quantity;
        return this;
    }

    public ItemData withPrice(String price) {
        this.price = price;
        return this;
    }

    public ItemData withRef(String ref) {
        this.ref = ref;
        return this;
    }
}

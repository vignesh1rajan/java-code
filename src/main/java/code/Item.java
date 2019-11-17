package code;

public class Item {

    private String name;
    private Double price;

    public Item(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public Item clone(){
        String iName = new String(this.name);
        Double iPrice = new Double(this.price);
        Item item = new Item(iName,iPrice);
        return item;
    }
}

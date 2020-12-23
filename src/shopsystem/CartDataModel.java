package shopsystem;

public class CartDataModel {

    public String name;

    public int quantity;

    public int price;

    public int pricesum;

    public  CartDataModel(String name, int quantity, int price) {

        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.pricesum = price * quantity;

    }

}



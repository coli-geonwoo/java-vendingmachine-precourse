package vendingmachine.domain;

import vendingmachine.validator.InputNumMoneyValidator;

public class Product {
    private static int MINIMUM_PRICE = 100;
    String productName;
    int price;
    int amount;

    public Product(String productName, int price, int amount) {
        this.productName = productName;
        this.price = price;
        this.amount = amount;
    }

    public String getName() {
        return productName;
    }

    public int getPrice() {
        return price;
    }

    public int getAmount() {
        return amount;
    }

    public boolean buy() {
        if (amount > 0) {
            amount--;
            return true;
        }
        return false;
    }

    public boolean canBuy() {

        if (amount > 0) {
            return true;
        }
        return false;
    }

}

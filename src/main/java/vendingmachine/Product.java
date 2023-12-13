package vendingmachine;

public class Product {
    private static int MINIMUM_PRICE=100;
    String productName;
    int price;
    int amount;
    Product(String productName, int price, int amount){
        this.productName=productName;
        validatePrice(price);
        this.price=price;
        this.amount=amount;
    }

    private void validatePrice(int money){
        if(money%10!=0 || money<MINIMUM_PRICE){
            throw new IllegalArgumentException("[ERROR] 입력하신 상품의 가격이 올바르지 않습니다.(100원 이상-10원 단위)");
        }
    }

}

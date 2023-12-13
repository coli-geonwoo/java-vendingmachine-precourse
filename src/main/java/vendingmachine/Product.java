package vendingmachine;

import View.Validator;

public class Product {
    private static int MINIMUM_PRICE=100;
    String productName;
    int price;
    int amount;
    Product(String productName, String price, String amount){
        this.productName=productName;
        validatePrice(price);
        validateAmount(amount);
        this.price=Integer.parseInt(price);
        this.amount=Integer.parseInt(amount);
    }

    private void validatePrice(String money){
        Validator.validateNonNumeric(money);
        int price= Integer.parseInt(money);
        if(price%10!=0 || price<MINIMUM_PRICE){
            throw new IllegalArgumentException("[ERROR] 입력하신 상품의 가격이 올바르지 않습니다.(100원 이상-10원 단위)");
        }
    }

    private void validateAmount(String amount){
        Validator.validateNonNumeric(amount);
        int amt=Integer.parseInt(amount);
        if(amt==0){
            throw new IllegalArgumentException("[ERROR] 입력하신 상품의 수량이 0개입니다.")
        }
    }

}

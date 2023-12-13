package View;

public class Validator {
    private static int MINIMUM_PRICE=100;
    public static void validateNonNumeric(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자가 아닌 값을 입력하셨습니다.");
        }
    }

    public static void validateNumericBase(String input){
        if(Integer.parseInt(input)%10 !=0){
            throw new IllegalArgumentException("[ERROR] 입력하신 숫자의 단위가 10이 아닙니다.");
        }
    }
    public static void validatePrice(int money){
        if(money%10!=0 || money<100){
            throw new IllegalArgumentException("[ERROR] 입력하신 상품의 가격이 올바르지 않습니다.(100원 이상-10원 단위)")
        }
    }
}

package vendingmachine.validator;

public class InputNumMoneyValidator {

    public static void validateInputMoney(String money) {
        int parsedMoney = validateNonNumeric(money);
        validateZeroAndNegative(parsedMoney);
        validateNumericBase(parsedMoney);
    }

    private static int MINIMUM_PRICE = 100;

    private static int validateNonNumeric(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자가 아닌 값을 입력하셨습니다.");
        }
    }

    private static void validateZeroAndNegative(int money) {
        if (money <= 0) {
            throw new IllegalArgumentException("[ERROR] 0 또는 음수를 입력하셨습니다.");
        }

    }

    public static void validateNumericBase(int money) {
        if (money % 10 != 0) {
            throw new IllegalArgumentException("[ERROR] 입력하신 숫자의 단위가 10이 아닙니다.");
        }
    }

}

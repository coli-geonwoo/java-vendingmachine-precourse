package View;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private final static String INPUT_MACHINE_MONEY_MESSAGE="자판기가 보유하고 있는 금액을 입력해 주세요.";
    private final static String INPUT_PRODUCT_INFO_MESSAGE="상품명과 가격, 수량을 입력해 주세요.";
    private final static String INPUT_MONEY_MESSAGE="투입 금액을 입력해 주세요.";
    private final static String INPUT_PRODUCT_NAME_MESSAGE="구매할 상품명을 입력해 주세요.";
    public static int inputMachineMoney(){
        System.out.println(INPUT_MACHINE_MONEY_MESSAGE);
        String machineMoney="";
        try{
            machineMoney= Console.readLine();
            Validator.validateNonNumeric(machineMoney);
            Validator.validateNumericBase(machineMoney);
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            return inputMachineMoney();
        }
        return Integer.parseInt(machineMoney);
    }

    public static void inputProdctInfo(){
        System.out.println(INPUT_PRODUCT_INFO_MESSAGE);
    }
    public static void inputMoney(){
        System.out.println(INPUT_MONEY_MESSAGE);
    }
    public static void inputProductName(){
        System.out.println(INPUT_PRODUCT_NAME_MESSAGE);
    }


}

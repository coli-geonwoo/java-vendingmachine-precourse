package vendingmachine.View;

import vendingmachine.View.constants.MachineMessage;
import camp.nextstep.edu.missionutils.Console;
import vendingmachine.View.constants.UserMessage;

import static vendingmachine.View.constants.UserMessage.INPUT_USER_PRODUCT;

public class InputView {

    //자판기가 보유하고 있는 금액을 입력해주세요
    public String inputMachineMoney() {
        System.out.println(MachineMessage.INPUT_MACHINE_MONEY.getMessage());
        return Console.readLine();
    }

    //상품, 가격, 개수를 입력해주세요
    public String inputMachineProduct() {
        System.out.println(MachineMessage.INPUT_MACHINE_PRODUCT.getMessage());
        return Console.readLine();
    }

    public String inputUserAmount() {
        System.out.println(UserMessage.INPUT_USER_AMOUNT.getMessage());
        return Console.readLine();
    }

    public String inputBuyProduct() {
        System.out.println(INPUT_USER_PRODUCT.getMessage());
        return Console.readLine();
    }


}

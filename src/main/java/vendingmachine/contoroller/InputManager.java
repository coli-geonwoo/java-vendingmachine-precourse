package vendingmachine.contoroller;

import vendingmachine.View.InputView;
import vendingmachine.View.OutputView;
import vendingmachine.domain.Product;
import vendingmachine.domain.VendingMachine;
import vendingmachine.utils.Parser;
import vendingmachine.validator.InputNumMoneyValidator;

import java.util.ArrayList;
import java.util.List;

public class InputManager {
    private final InputView inputView;
    private final OutputView outputView;

    public InputManager(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public int inputMachineMoney() {
        boolean flag = false;
        String money = "";
        while (!flag) {
            try {
                money = inputView.inputMachineMoney();
                InputNumMoneyValidator.validateInputMoney(money);
                flag = true;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e);
            }
        }
        return Parser.inputMoneyParser(money);
    }

    public List<Product> inputMachineProduct() {
        boolean flag = false;
        List<Product> machineProducts = new ArrayList<>();
        while (!flag) {
            try {
                String products = inputView.inputMachineProduct();
                machineProducts = Parser.productParser(products);
                flag = true;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e);
            }
        }
        return machineProducts;
    }

    public int inputUserAmount() {
        boolean flag = false;
        String money = "";
        while (!flag) {
            try {
                money = inputView.inputUserAmount();
                InputNumMoneyValidator.validateInputMoney(money);
                flag = true;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e);
            }
        }
        return Parser.inputMoneyParser(money);
    }

    public String inputBuyProduct(VendingMachine machine) {
        boolean flag = false;
        String product = "";
        while (!flag) {
            try {
                product = inputView.inputBuyProduct();
                machine.isExistProduct(product);
                machine.isExistsQunatity(product);
                flag = true;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e);
                ;
            }
        }
        return product;
    }


}

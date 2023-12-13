package vendingmachine.contoroller;

import vendingmachine.Coin;
import vendingmachine.View.OutputView;
import vendingmachine.domain.CoinGenerator;
import vendingmachine.domain.Product;
import vendingmachine.domain.VendingMachine;

import java.util.List;
import java.util.Map;

public class MachineController {
    private final OutputView outputView;
    private final InputManager inputManager;

    public MachineController(InputManager inputManager, OutputView outputView) {
        this.inputManager = inputManager;
        this.outputView = outputView;
    }

    public void run() {
        Map<Coin, Integer> coins = makeMachineCoins();
        outputView.printCoins(coins);
        List<Product> products = inputManager.inputMachineProduct();
        VendingMachine machine = new VendingMachine(coins, products);
        int userAmount = inputManager.inputUserAmount();
        buyProduct(machine, userAmount);

    }

    private void buyProduct(VendingMachine machine, int userAmount) {
        while (true) {
            outputView.printUserAmount(userAmount);
            if (!machine.canBuyWithMoney(userAmount) || !machine.canBuyWithQuantity()) {
                outputView.printChange(machine.calculateChange(userAmount));
                break;
            }
            String product = inputManager.inputBuyProduct(machine);
            int change = machine.buy(product);
            userAmount -= change;
        }
    }

    private Map<Coin, Integer> makeMachineCoins() {
        int money = inputManager.inputMachineMoney();
        CoinGenerator coinGenerator = new CoinGenerator(money);
        return coinGenerator.getCoins();
    }
}

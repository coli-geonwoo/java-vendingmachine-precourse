package vendingmachine;

import vendingmachine.View.InputView;
import vendingmachine.View.OutputView;
import vendingmachine.contoroller.InputManager;
import vendingmachine.contoroller.MachineController;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        InputManager inputManager = new InputManager(inputView, outputView);
        MachineController machineController = new MachineController(inputManager, outputView);
        machineController.run();

    }
}

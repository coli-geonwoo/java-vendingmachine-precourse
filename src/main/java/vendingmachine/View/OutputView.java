package vendingmachine.View;


import vendingmachine.Coin;

import java.util.Map;

import static vendingmachine.View.constants.MachineMessage.*;

public class OutputView {


    public void printErrorMessage(IllegalArgumentException e) {
        System.out.println(e.getMessage());
        ;
    }

    public void printCoins(Map<Coin, Integer> coins) {
        System.out.println(MACHINE_CHANGE.getMessage());
        for (Coin coin : Coin.values()) {
            int coinCount = coins.getOrDefault(coin, 0);
        }
        System.out.println(String.format(COIN_FORMAT.getMessage()));
        NEWLINE.getMessage();

    }

    public void printUserAmount(int userAmount) {
        System.out.println(String.format(USER_AMOUNT.getMessage(), userAmount));
    }

    public void printChange(Map<Coin, Integer> changes) {
        System.out.println(CHANGE.getMessage());
        for (Map.Entry<Coin, Integer> change : changes.entrySet()) {
            System.out.println(String.format(COIN_FORMAT.getMessage(),
                    change.getKey().getAmount()));
        }
    }

}

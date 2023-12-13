package vendingmachine.domain;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.Coin;

import java.util.*;

public class CoinGenerator {
    private final Map<Coin, Integer> coins;

    public CoinGenerator(int money) {
        this.coins = generate(money);
    }

    private static Map<Coin, Integer> generate(int money) {
        Map<Coin, Integer> coins = new HashMap<>();
        List<Integer> coinList = Arrays.asList(1, 2, 3, 4);
        while (money > 0) {
            Coin randomCoin = Coin.values()[Randoms.pickNumberInList(coinList) % 3];
            if (randomCoin.getAmount() <= money) {
                coins.put(randomCoin, coins.getOrDefault(randomCoin, 0) + 1);
                money -= randomCoin.getAmount();
            }
        }

        Map<Coin, Integer> sortedCoins = new TreeMap<>(Comparator.comparing(Coin::getAmount).reversed());
        sortedCoins.putAll(coins);
        return sortedCoins;
    }

    public Map<Coin, Integer> getCoins() {
        return coins;
    }
}

package vendingmachine.domain;

import vendingmachine.Coin;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class VendingMachine {
    private Map<Coin, Integer> coins;
    private List<Product> products;

    public VendingMachine(Map<Coin, Integer> coins, List<Product> products) {
        this.coins = coins;
        this.products = products;
    }

    public int buy(String productName) {
        for (Product product : products) {
            if (productName.equals(product.getName())) {
                product.buy();
                return product.getPrice();
            }
        }
        return 0;
    }

    public boolean canBuyWithMoney(int userAmount) {
        for (Product product : products) {
            if (product.getPrice() <= userAmount) {
                return true;
            }
        }
        return false;
    }

    public boolean canBuyWithQuantity() {
        for (Product product : products) {
            if (product.getAmount() > 0) {
                return true;
            }
        }
        return false;
    }

    public void isExistsQunatity(String productName) {
        boolean result = false;
        for (Product product : products) {
            Product p;
            if (productName.equals(product.getName())) {
                result = product.canBuy();
            }
        }

        if (!result) {
            throw new IllegalArgumentException("[ERROR] 주문하려는 상품이 모두 소진되었습니다. 다른 상품을 주문해주세요");
        }
    }

    public void isExistProduct(String productName) {
        boolean result = false;
        for (Product product : products) {
            if (productName.equals(product.getName())) {
                result = true;
                break;
            }
        }
        if (!result) {
            throw new IllegalArgumentException("[ERROR] 존재하지 않는 상품을 입력했습니다.");
        }
    }

    public Map<Coin, Integer> calculateChange(int userAmount) {
        Map<Coin, Integer> sortedCoins = new TreeMap<>(Comparator.comparing(Coin::getAmount).reversed());
        for (Map.Entry<Coin, Integer> entry : coins.entrySet()) {
            Coin change = entry.getKey();
            int count = entry.getValue();

            while (userAmount >= change.getAmount() && count > 0) {
                userAmount -= change.getAmount();
                count--;
                sortedCoins.merge(change, 1, Integer::sum);//하나씩 올림
            }
            coins.put(change, count);

        }
        return sortedCoins;
    }
}

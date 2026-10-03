package code.dynamic_programming.unbounded_knapsack;

public class CoinChange {
    public static void main(String[] args) {
        int[] coins = {1, 5, 10};
        int amount = 12;
        CoinChange coinChangeObj = new CoinChange();
        int minCoinsRequired = coinChangeObj.coinChange(coins, amount);
        System.out.println("Min coins required are : " + minCoinsRequired);
    }

    public int coinChange(int[] coins, int amount) {
        if (amount < 1) return 0;
        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;
            //try each coin
            for (int coin : coins) {
                if (coin <= i && dp[i - coin] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
                }
            }
        }
        if (dp[amount] == Integer.MAX_VALUE) return -1;
        return dp[amount];
    }


}

package code.dynamic_programming;

public class BuyAndSellStocksThree {
    public static void main(String[] args) {
        int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};
        BuyAndSellStocksThree buyAndSellStocksThree = new BuyAndSellStocksThree();
        int res = buyAndSellStocksThree.maxProfit(prices);
        System.out.println("The maximum profit from stocks is : " + res);
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] leftProfit = new int[n];
        int[] rightProfit = new int[n];
        populateLeftProfit(leftProfit, prices, n);
        populateRightProfit(rightProfit, prices, n);
        return findMaxTotal(leftProfit, rightProfit, n);
    }

    private int findMaxTotal(int[] leftProfit, int[] rightProfit, int n) {
        int maxi = 0;
        for (int i = 0; i < n; i++) {
            int total = leftProfit[i] + rightProfit[i];
            maxi = Math.max(total, maxi);
        }
        return maxi;
    }

    private void populateRightProfit(int[] rightProfit, int[] prices, int n) {
        int maxi = prices[n - 1];
        int profit = 0;
        for (int i = n - 1; i >= 0; i--) {
            maxi = Math.max(maxi, prices[i]);
            int cost = maxi - prices[i];
            profit = Math.max(cost, profit);
            rightProfit[i] = profit;
        }
    }

    private void populateLeftProfit(int[] leftProfit, int[] prices, int n) {
        int mini = prices[0];
        int profit = 0;
        for (int i = 1; i < n; i++) {
            mini = Math.min(mini, prices[i]);
            int cost = prices[i] - mini;
            profit = Math.max(cost, profit);
            leftProfit[i] = profit;
        }
    }
}

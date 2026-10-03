package code.arrays;

public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        BestTimeToBuyAndSellStock bestTimeToBuyAndSellStock = new BestTimeToBuyAndSellStock();
        int maxProfitValue = bestTimeToBuyAndSellStock.maxProfit(prices);
        System.out.println("The max profit achieved is : " + maxProfitValue);
    }

    public int maxProfit(int[] prices) {
        int mini = prices[0];
        int maxProf = 0;
        int n = prices.length;
        for (int i = 0; i < n; i++) {
            mini = Math.min(mini, prices[i]);
            maxProf = Math.max(maxProf, prices[i] - mini);
        }
        return maxProf;
    }

}

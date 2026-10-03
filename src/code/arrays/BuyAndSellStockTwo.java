package code.arrays;

public class BuyAndSellStockTwo {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        BuyAndSellStockTwo buyAndSellStockTwo = new BuyAndSellStockTwo();
        int maximumProfit = buyAndSellStockTwo.maxProfit(prices);
        System.out.println("The maximum profit is : " + maximumProfit);
    }

    public int maxProfit(int[] prices) {
        return solve(0, 0, prices);
    }

    public int solve(int idx, int holding, int[] prices) {
        //base case
        if (idx == prices.length) {
            return 0;
        }
        if (holding == 1) {
            int skip = solve(idx + 1, 1, prices);
            int sell = prices[idx] + solve(idx + 1, 0, prices);
            return Math.max(skip, sell);
        } else {
            int skip = solve(idx + 1, 0, prices);
            int buy = -prices[idx] + solve(idx + 1, 1, prices);
            return Math.max(skip, buy);
        }

    }


}

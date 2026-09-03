package trees;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class StockPriceTest {


    static class StockPrice {
        private Map<Integer, Integer> priceMap;
        private TreeMap<Integer, Integer> priceCount;
        private int latestTimestamp;

        public StockPrice() {
            priceMap = new HashMap<>();
            priceCount = new TreeMap<>();
            latestTimestamp = 0;
        }

        public void update(int timestamp, int price) {
            //if correcting an existing ts then remove the old price from count
            if (priceMap.containsKey(timestamp)) {
                int oldPrice = priceMap.get(timestamp);
                int count = priceCount.get(oldPrice);
                if (count == 1) {
                    priceCount.remove(oldPrice);
                } else {
                    priceCount.put(oldPrice, count - 1);
                }
            }

            //update the price and add new count
            priceMap.put(timestamp, price);
            priceCount.merge(timestamp, 1, Integer::sum);
            latestTimestamp = Math.max(latestTimestamp, timestamp);
        }

        public int current() {
            return priceMap.get(latestTimestamp);
        }

        public int maximum() {
            return priceCount.lastKey();
        }

        public int minimum() {
            return priceCount.firstKey();
        }
    }


    public static void main(String[] args) {
        StockPrice sp = new StockPrice();
        sp.update(1, 10);
        sp.update(2, 5);
        System.out.println(sp.current());
        System.out.println(sp.maximum());
        sp.update(1, 3);
        System.out.println(sp.maximum());
        sp.update(4, 2);
        System.out.println(sp.minimum());

    }
}

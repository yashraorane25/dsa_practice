package code.binary_search;

public class KokoEatingBananas {
    public static void main(String[] args) {
        int[] piles = {3, 6, 7, 11};
        int h = 8;
        KokoEatingBananas koko = new KokoEatingBananas();
        int minSpeed = koko.minEatingSpeed(piles, h);
        System.out.println("Min speed of koko eating bananas is: " + minSpeed);

    }

    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = 0;
        for (int pile : piles) {
            high = Math.max(high, pile);
        }
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int totalHrs = findTotalHrs(piles, mid);
            if (totalHrs > h) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;

    }

    private int findTotalHrs(int[] piles, int mid) {

        int total = 0;
        int n = piles.length;
        for (int num : piles) {

            total += (num + mid - 1) / mid;


        }
        return total;
    }
}

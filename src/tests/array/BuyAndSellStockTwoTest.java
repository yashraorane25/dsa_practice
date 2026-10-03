package tests.array;

import code.arrays.BuyAndSellStockTwo;

import java.util.Arrays;

public class BuyAndSellStockTwoTest {

    public static void main(String[] args) {
        BuyAndSellStockTwo solver = new BuyAndSellStockTwo();

        int passed = 0;
        int total = 0;

        // Test 1: Fluctuating prices
        total++;
        if (runTest(solver, "Fluctuating prices", new int[]{7, 1, 5, 3, 6, 4}, 7)) passed++;

        // Test 2: Strictly increasing prices
        total++;
        if (runTest(solver, "Strictly increasing prices", new int[]{1, 2, 3, 4, 5}, 4)) passed++;

        // Test 3: Strictly decreasing prices
        total++;
        if (runTest(solver, "Strictly decreasing prices", new int[]{7, 6, 4, 3, 1}, 0)) passed++;

        System.out.printf("%nResult: %d/%d tests passed.%n", passed, total);
        if (passed != total) {
            System.exit(1);
        }
    }

    private static boolean runTest(BuyAndSellStockTwo solver, String testName, int[] input, int expected) {
        int actual = solver.maxProfit(input.clone());
        if (expected == actual) {
            System.out.printf("PASS: %s (Input: %s -> %d)%n", testName, Arrays.toString(input), actual);
            return true;
        } else {
            System.err.printf("FAIL: %s (Input: %s)%n  Expected: %d%n  Actual:   %d%n",
                    testName, Arrays.toString(input), expected, actual);
            return false;
        }
    }

    // Overload to allow calling runTest without a test name
    private static boolean runTest(BuyAndSellStockTwo solver, int[] input, int expected) {
        return runTest(solver, Arrays.toString(input), input, expected);
    }
}


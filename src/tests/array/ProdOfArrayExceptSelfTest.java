package tests.array;

import code.arrays.ProdOfArrayExceptSelf;

import java.util.Arrays;

public class ProdOfArrayExceptSelfTest {

    public static void main(String[] args) {
        ProdOfArrayExceptSelf solver = new ProdOfArrayExceptSelf();

        int passed = 0;
        int total = 0;

        // Test 1: Standard positive numbers
        total++;
        if (runTest(solver, "Standard positive numbers",
                new int[]{1, 2, 3, 4},
                new int[]{24, 12, 8, 6})) passed++;

        // Test 2: Contains a single zero
        total++;
        if (runTest(solver, "Contains single zero",
                new int[]{-1, 1, 0, -3, 3},
                new int[]{0, 0, 9, 0, 0})) passed++;

        // Test 3: Contains multiple zeros
        total++;
        if (runTest(solver, "Contains multiple zeros",
                new int[]{0, 4, 0},
                new int[]{0, 0, 0})) passed++;

        // Test 4: Negative numbers
        total++;
        if (runTest(solver, "Negative numbers",
                new int[]{-2, -3, -4},
                new int[]{12, 8, 6})) passed++;

        // Test 5: Two elements (minimum constraint)
        total++;
        if (runTest(solver, "Minimum length (2 elements)",
                new int[]{5, 10},
                new int[]{10, 5})) passed++;

        // Test 6: All ones
        total++;
        if (runTest(solver, "All ones",
                new int[]{1, 1, 1, 1},
                new int[]{1, 1, 1, 1})) passed++;

        System.out.printf("%nResult: %d/%d tests passed.%n", passed, total);
        if (passed != total) {
            System.exit(1);
        }
    }

    private static boolean runTest(ProdOfArrayExceptSelf solver, String testName, int[] input, int[] expected) {
        int[] actual = solver.productExceptSelf(input.clone());
        if (Arrays.equals(actual, expected)) {
            System.out.printf("PASS: %s%n", testName);
            return true;
        } else {
            System.err.printf("FAIL: %s%n  Expected: %s%n  Actual:   %s%n",
                    testName, Arrays.toString(expected), Arrays.toString(actual));
            return false;
        }
    }
}

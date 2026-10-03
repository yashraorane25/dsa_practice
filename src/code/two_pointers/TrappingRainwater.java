package code.two_pointers;

public class TrappingRainwater {
    public static void main(String[] args) {
        TrappingRainwater tr = new TrappingRainwater();
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int maxWaaterTrapped = tr.trap(height);
        System.out.println("Max rainwater trapped: " + maxWaaterTrapped);
    }

    // The below apprach is using prefix max arrays
    /*public int trap(int[] height) {
        int n = height.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        int totalWater = 0;
        leftMax[0] = 0;
        rightMax[n - 1] = 0;
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(height[i - 1], leftMax[i - 1]);

        }
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(height[i + 1], rightMax[i + 1]);
        }
        for (int i = 0; i < n; i++) {
            int val = Math.min(leftMax[i], rightMax[i]) - height[i];
            if (val > 0) {
                totalWater += val;
            }
        }
        return totalWater;
    }*/

    //optimal apprach. Using two pointer apprach
    public int trap(int[] height) {
        int n = height.length;
        int totalWater = 0;
        int leftMax = 0;
        int rightMax = 0;
        int left = 0;
        int right = n - 1;
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];

                } else {
                    totalWater += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    totalWater += rightMax - height[right];
                }
                right--;
            }
        }
        return totalWater;
    }

}

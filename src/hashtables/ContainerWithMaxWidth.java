package hashtables;

public class ContainerWithMaxWidth {
    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        ContainerWithMaxWidth cmw = new ContainerWithMaxWidth();
        int maxContainerArea = cmw.maxArea(height);
        System.out.println(maxContainerArea);
    }

    public int maxArea(int[] height) {
        int n = height.length;
        int left = 0;
        int right = n-1;
        int maxi = 0;
        while (left < right) {
            int maxAreaVal = Math.min(height[left], height[right]) * (right - left);
            maxi = Math.max(maxi, maxAreaVal);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxi;
    }
}

package main;

/***
 * You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
 *
 * Find two lines that together with the x-axis form a container, such that the container contains the most water.
 *
 * Return the maximum amount of water a container can store.
 *
 * Notice that you may not slant the container.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: height = [1,8,6,2,5,4,8,3,7]
 * Output: 49
 * Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
 *
 */
public class ContainerWithMostWaterSolution {

    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(solution(height));
    }

    static int solution(int[] height) {
        // combination of index and element should have maximum value
        int maxCapacity = Integer.MIN_VALUE;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            int ca = Math.min(height[left], height[right]) * (right - left);
            maxCapacity = Math.max(maxCapacity, ca);
            if (height[left]<height[right])
                left+=1;
            else
                right-=1;
        }
        return maxCapacity;
    }
}

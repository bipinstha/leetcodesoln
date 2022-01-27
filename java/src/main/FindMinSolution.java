package main;

public class FindMinSolution {

    public static void main(String[] args) {
        int[] testA = {3,4,5,1,2};

        System.out.println(solution(testA));
    }

    public static int solution(int[] nums) {
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
        }
        return min;
    }
}

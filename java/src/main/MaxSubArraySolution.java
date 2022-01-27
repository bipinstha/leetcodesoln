package main;

public class MaxSubArraySolution {

    public static void main(String[] args) {
        int[] testA = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(solution(testA));
    }

    static int solution(int[] nums) {
        int max_sum = 0;
        int cur=0;
        for(int x:nums) {
            if(cur<0) cur=0;
            cur += x;
            max_sum =  Math.max(max_sum , cur);
        }
        return max_sum;
    }
}

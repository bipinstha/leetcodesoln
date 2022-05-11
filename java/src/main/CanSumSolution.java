package main;

public class CanSumSolution {

    public static void main(String[] args) {


        int[] a= {2,3,4,6,2};
        int[] b= {3,4,6};
        int[] c= {2,3,4,6,2};
        int[] d= {2,3,4,6,2};
        System.out.println(solution(8, a));
        System.out.println(solution(5, b));
        System.out.println(solution(6, c));
        System.out.println(solution(9, d));
    }

    static boolean solution(int target, int[] nums) {
        if(target == 0) return true;
        if(target < 0) return false;
        for (int i = 0; i < nums.length; i++) {
            int reminder = target - nums[i];
            if(solution(reminder, nums) == true) return true;
        }
        return false;

    }

    static boolean solutionMemo(int target, int[] nums) {
        if(target == 0) return true;
        if(target < 0) return false;
        for (int i = 0; i < nums.length; i++) {
            int reminder = target - nums[i];
            if(solution(reminder, nums) == true) return true;
        }
        return false;

    }
}

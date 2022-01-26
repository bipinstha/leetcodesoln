package main;

public class ArrayProductExceptSelf {

    public static void main(String[] args) {
        int[] textA = {1,2,3,4};
        int[] textB = {-1,1,0,-3,3};

        for(int num : solution(textA)) {
            System.out.print(num + "\t");
        }
        System.out.println();
        for(int num : solution(textB)) {
            System.out.print(num + "\t");
        }
    }

    static int[] solution(int[] nums) {
        int[] resp = new int[nums.length];

        // add 1 on each resp element
        int accumulated = 1;
        for (int i = 0; i < resp.length; i++) {
            resp[i] = accumulated;
        }
        // Accumulate from left to right.
        for (int i = 0; i < resp.length; i++) {
            resp[i] *= accumulated;
            accumulated *= nums[i]; // Accumulate the current value nums[i] for the next iteration
        }
        // Accumulate everything from the right of left till ith
        accumulated = 1;
        for (int i = resp.length - 1; i >= 0; i--) { // This time go from right to left
            resp[i] *= accumulated;
            accumulated *= nums[i];
        }
        return resp;
    }

    // solution not soo efficient
    static int[] solutionA(int[] nums) {
        int[] resp = new int[nums.length];

        for(int i = 0 ; i < nums.length; i++) {
            resp[i] = prod(nums, 0, i);
        }
        return resp;
    }

    // iterative call to self
    static int prod(int[] nums, int index, int self) {
        if(index == nums.length) {
            return 1;
        }
        return ((index == self )? 1 : nums[index]) * prod(nums, index + 1, self);
    }
}

package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSumSolution {

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        System.out.println(solution(nums));
    }

    static List<List<Integer>> solution(int[] nums){
        // Container for list of list [[][][]]
        List<List<Integer>> lists = new ArrayList<>();
        // sort given array in ascending order
        Arrays.sort(nums);
        // initialize sum as -1
        int sum = -1;
        // start loop through sorted array
        for(int i = 0; i < nums.length; i++) {
            // If i and i + 1 are same just continue the loop, i.e. to avoid duplicate
            if(i > 0) {
                if(nums[i] == nums[i-1]) {
                    continue;
                }
            }
            // initialize left and right
            int l = i + 1, r = nums.length - 1;
            // while left index is smaller than right index
            while(l < r){
                // compute sum using current, left and right index
                sum = nums[i] + nums[l] + nums[r];
                if(sum > 0) {
                    // if sum is greater than 0, i.e. reduce right index by 1, because our array is in ascending order, reducing right index gives us smaller number
                    r = r - 1;
                } else if(sum < 0) {
                    // if sum is less then 0, i.e. increase right index by 1, because our array is in ascending order, increasing left index gives us greater number
                    l = l+1;
                } else  {
                    // else sum is zero, store the number in three indexes in array container i.e. lists
                    List<Integer> intList = new ArrayList<>();
                    intList.add(nums[i]);
                    intList.add(nums[l]);
                    intList.add(nums[r]);
                    lists.add(intList);
                    // increase left by index 1 and start searching for another 3 sum combination
                    l = l + 1;
                    // If left and (left - 1) are same increase left by 1 index, i.e. to avoid duplicate
                    while(nums[l] == nums[l-1] && (l < r)) {
                        l = l + 1;
                    }
                }
            }
        }
        // contains final 3 sum combination list
        return lists;
    }
}

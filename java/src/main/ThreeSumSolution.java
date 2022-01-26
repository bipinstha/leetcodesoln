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
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);
        int sum = -1;
        for(int i = 0; i < nums.length; i++) {
            if(i > 0) {
                if(nums[i] == nums[i-1]) {
                    continue;
                }
            }
            int l = i+1, r = nums.length-1;
            while(l < r){
                sum = nums[i] + nums[l] + nums[r];
                if(sum > 0) {
                    r = r-1;
                } else if(sum < 0) {
                    l = l+1;
                } else  {
                    List<Integer> intList = new ArrayList<>();
                    intList.add(nums[i]);
                    intList.add(nums[l]);
                    intList.add(nums[r]);
                    lists.add(intList);
                    l =l+1;
                    while(nums[l] == nums[l-1] && (l < r)) {
                        l =l+1;
                    }
                }
            }
        }
        return lists;
    }
}

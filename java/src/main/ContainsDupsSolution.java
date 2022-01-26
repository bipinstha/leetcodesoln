package main;

import java.util.HashSet;
import java.util.Set;

public class ContainsDupsSolution {

    public static void main(String[] args) {
        int[] testA = {1,2,3,1};
        System.out.println(solution(testA));
        int[] textB = {1,2,3,4};
        System.out.println(solution(textB));
        int[] textC = {1,1,1,3,3,4,3,2,4,2};
        System.out.println(solution(textC));
    }

    static boolean solution(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for(int num : nums) {
            if(!numSet.add(num)) {
                return true;
            }
        }
        return false;
    }
}

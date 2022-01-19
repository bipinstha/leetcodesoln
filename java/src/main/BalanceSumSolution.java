package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BalanceSumSolution {


    public static void main(String[] args) {
        int[] A = {1,1,4,1,1};
        int[] B = {2,0,0,0};
        int[] C = {0,0,2,0};

        List<Integer> arrayListA = new ArrayList<>();
        for (int item : A) {
            arrayListA.add(item);
        }

        System.out.println(balancedSums(arrayListA));
//        System.out.println(balancedSums(Arrays.asList(B)));
//        System.out.println(balancedSums(Arrays.asList(C)));
    }

    public static String balancedSums(List<Integer> arr) {
        // Write your code here
        int l = -1, r = arr.size() - 1;
        while(l < r) {
            int leftSum = 0, rightSum = 0;
            for(int i = 0; i < l; i++) {
                leftSum += arr.get(i);
            }
            for(int j = r; j < arr.size(); j++) {
                rightSum += arr.get(j);
            }
            if(leftSum < rightSum) {
                l++;
            } else if(leftSum > rightSum) {
                r--;
            } else if(leftSum == rightSum) {
                if(l + (arr.size() - r) + 1 == arr.size()) {
                    return "YES";
                } else {
                    l++; r--;
                }
            } else {
                return "NO";
            }
        }

        return "NO";

    }
}

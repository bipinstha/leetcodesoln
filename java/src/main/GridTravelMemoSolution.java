package main;

import java.util.HashMap;
import java.util.Map;

public class GridTravelMemoSolution {

    public static void main(String[] args) {
        System.out.println(solution(2,3));
        System.out.println(solution(3,3));
        System.out.println(solution(4,3));
        long startTime = System.currentTimeMillis();
        System.out.println(solution(14,14));
        long endTime = System.currentTimeMillis();
        System.out.println("Time Period: " + (endTime - startTime));
    }

    static int solution(int m, int n) {
        Map<String, Integer> memo = new HashMap<>();
        return recursive(m, n, memo);
    }

    static int recursive(int m, int n,  Map<String, Integer> memo) {
        String key = m + "," + n;
        if (memo.containsKey(key)) return memo.get(key);
        if (m==0 || n==0) return  0;
        if(m==1 || n==1) return 1;
        memo.put(key, recursive(m-1, n, memo) + recursive(m, n-1, memo));
        return memo.get(key);
    }
}

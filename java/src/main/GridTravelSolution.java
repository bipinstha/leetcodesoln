package main;

import java.util.HashMap;
import java.util.Map;

public class GridTravelSolution {

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
        return recursive(m, n);
    }

    static int recursive(int m, int n) {
        if (m==0 || n==0) return  0;
        if(m==1 || n==1) return 1;
        return recursive(m-1, n) + recursive(m, n-1);

    }
}

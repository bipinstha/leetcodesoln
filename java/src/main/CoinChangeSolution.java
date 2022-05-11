package main;

import java.util.Arrays;

public class CoinChangeSolution {

    public static void main(String[] args) {
        int[] coins = {1,2,5};
        System.out.println(solution(coins, 18));
        int[] coinsX = {186,419,83,408};
        System.out.println(solution(coinsX, 6249));
    }
    static int solution(int[] coins, int amount) {
        int numOfCoin = 0;
        int reminder = Integer.MIN_VALUE;
        //Arrays.sort(corns);
        int index = coins.length - 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount+1);
        dp[0] = 0;
        for (int a = 1; a < amount + 1; a++) {
            for (int c : coins) {
                if(a - c >= 0) {
                    dp[a] = Math.min(dp[a], 1 + dp[a - c]);
                }
            }
        }
        if(dp[amount] != amount + 1)
            return dp[amount];
        else
            return -1;
    }

    static int solutionDP(int[] coins, int amount, int index, int[][] dp) {
        int numOfCoin = 0;
        int reminder = Integer.MIN_VALUE;
        for(int i = coins.length - 1; i >=0; i--) {
            float div = amount / coins[i];
            if(div >= 1) {
                int divident = amount / coins[i];
                numOfCoin += divident;
                reminder = amount % coins[i];
                amount = amount - coins[i] * divident;
                if(reminder == 0) {
                    return numOfCoin;
                }
            }
        }
        return solutionDP(coins, amount, index - 1, dp);
    }
}

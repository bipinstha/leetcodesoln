package main;


import com.sun.tools.javac.util.Assert;

import java.util.Arrays;

/***
 * In a Icecream parlor there are different flavor or Icecream with different price tag on it.
 * Given $X, now you need to find the maximum flavor of Icecream for me.
 */
public class IceCreamParlorSolution {

    public static void main(String[] args) {
        int[] parlorAPrice = {2,4,1,8,6,15,9,3};
        int[] parlorBPrice = {6,2,4,9,1,4,6};
        int[] parlorCPrice = {7,5,5,9,11,13,8};
        int[] parlorDPrice = {3,2,5,7,3,4,5,5};
        Assert.check(4 == solution(parlorAPrice, 15));
        Assert.check(3 == solution(parlorBPrice, 10));
        Assert.check(2 == solution(parlorCPrice, 10));
        Assert.check(4 == solution(parlorDPrice, 15));
    }

    /***
     *
     * @param prices prices of different flavor of icecream
     * @param amount $X in my pocket
     * @return number of different flavor
     */
    public static int solution(int[] prices, int amount) {
        int noOfItem = 0;
        int[] sortedPrice = prices.clone();
        Arrays.sort(sortedPrice);
        for(int i = 0; i < sortedPrice.length; i++) {
            if(amount - sortedPrice[i] >= 0) {
                amount -= sortedPrice[i];
                noOfItem++;
            }
        }
        return noOfItem;
    }
}

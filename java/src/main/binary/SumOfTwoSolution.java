package main.binary;

public class SumOfTwoSolution {

    public static void main(String[] args) {
        System.out.println("ans: "+solution(2,3));
    }
    static int solution(int a, int b){ //0010  , 0011

        while(b!=0){
            int temp = (a&b)<<1; // 2 & 3 << 1
            System.out.println("temp: "+temp);
            a = a^b; // 0010 ^ 0011 = 0001
            System.out.println("a: "+a);
            b=temp;
            System.out.println("b: "+b);
        }
        return a;
    }
}

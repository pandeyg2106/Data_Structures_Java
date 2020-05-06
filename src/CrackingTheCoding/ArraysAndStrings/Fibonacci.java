package CrackingTheCoding.ArraysAndStrings;

import java.util.ArrayList;
import java.util.Arrays;

public class Fibonacci {

    public static int[] generateFibonacci(int n){
        int[] result = new int[n];
        result[0] = 1;
        result[1] = 1;
        for(int i = 2; i < result.length; i++){
            result[i] = result[i-2] + result[i-1];
        }
        return result;
    }

    public static ArrayList fibonacciRecursion(int n){
      ArrayList result = new ArrayList();
        int first = 1;
        int second = 1;
        int count = 1;
        int sum = 0;
        sum = first + second;
        result.add(sum);
        while(count<=n){
            fibonacciRecursion(n-2);
            count++;
        }
        return result;
    }

    public static void main(String[] args){
        System.out.println(fibonacciRecursion(6));
    }
}

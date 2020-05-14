package CrackingTheCoding;

import Algorithms.SmallestDifference;
import Algorithms.ThreeNumberSum;
import Codility.Palladium;
import Codility.Ruthenium2019;

import java.util.*;

public class Main {

    public static void main(String[] args){
        var obj = new SmallestDifference();
        int[] A1 = {-1, 5, 10, 20, 28, 3};
        int[] A2 = {26, 134, 135, 15, 17};
        System.out.println(Arrays.toString(obj.smallestDifference(A1,A2)));

    }

    public static int isTriangular(int[] A){
        int len = A.length;
        Arrays.sort(A);
        for(int i = 0; i<=len-3; i++){
 //           System.out.println((long)A[i] + (long)A[i+1]);
            if((long)A[i] + (long)A[i+1] > A[i+2]){
                return 1;
            }
        }
        return 0;
    }

    public static int maxProduct(int[] A){
        Arrays.sort(A);
        int len = A.length;
        int count = 0;
        int product = 1;
        for(int i = 0; i<len-1;i++){
            if(A[i] < 0){
                count++;
                product = product * A[i];
                if(count == 2){
                    break;
                }
            }
        }
        return Math.max(A[len-1]*A[len-2]*A[len-3], A[len-1]*product);
    }

    public int solution(int N) {
        // write your code in Java SE 8
        ArrayList<Integer> binaryList= getBinary(N);
        ArrayList<Integer> allOnes = new ArrayList();
        var result = 0;
        for(int i = 0; i<binaryList.size(); i++){
            if(binaryList.get(i) > 0){
                allOnes.add(i);
            }
        }
        if(allOnes.size() <= 1){
            return 0;
        }
        for(int j = 0; j<allOnes.size()-1; j++){
            if((allOnes.get(j + 1) - allOnes.get(j)) -1 > result){
                result = (allOnes.get(j + 1) - allOnes.get(j)) -1;
            }
        }
        return result;

    }

    public ArrayList<Integer> getBinary(int num){

        var binary = new ArrayList();
        int index = 0;
        while(num > 0){
            int rem = num%2;
            binary.add(rem);
            num = num/2;
        }
        return binary;
    }

    public static int test(int[] A) {

        Map<Integer, Integer> map = new HashMap<>();
        for(int i : A){
            if(!map.containsKey(i)){
                map.put(i, 1);
            }
            else{
                map.put(i, map.get(i)+1);
            }
        }

        ArrayList<Integer> keys = new ArrayList();

        for(var k : map.entrySet())
            keys.add(k.getKey());
        return keys.size();
    }

    public int getPatternCount(String input, String pattern){
        //111213548741112239211145586
        //111
        int result = 0;
        for(int i = 0; i<input.length()-3;i++){
            int count = 0;
            for(int j = 0; j<pattern.length();j++){
                if(pattern.charAt(j) == input.charAt(i+j)){
                    count++;
                }
            }
            if(count == pattern.length())
                result++;
        }
        return result;
    }

    public class Solution {
        public int solution(int[] H) {
            // write your code in Java SE 8
            int len = H.length;
            int[] maxValues = getMaxValues(H, 0, len - 1);
            int area1;
            int area2;
            int leftMax = getMaxValues(H, 0, maxValues[1] - 1)[0];
            int rightMax = getMaxValues(H, maxValues[1] + 1, len - 1)[0];
            Map<Integer, Integer> hashMap = new HashMap<>();
            for (int i : H) {
                hashMap.put(i, (hashMap.getOrDefault(i, 0)) + 1);
            }
            int frequencyOfMax = hashMap.get(maxValues[0]);

            if (frequencyOfMax == 1) {
                if (maxValues[1] == 0) {
                    area1 = maxValues[0];
                    area2 = rightMax * (len - 1);
                } else if (maxValues[1] == len - 1) {
                    area2 = maxValues[0];
                    area1 = leftMax * (len - 1);
                } else if (leftMax > rightMax) {
                    area1 = maxValues[0] * (maxValues[1]);
                    area2 = rightMax * (len - 1 - maxValues[1]);
                } else {
                    area2 = maxValues[0] * (len - maxValues[1]);
                    area1 = leftMax * maxValues[1];
                }
            } else {
                int temp = maxValues.length;
                if (maxValues[1] == 0 && maxValues[temp - 1] == len - 1) {
                    area1 = maxValues[0] * (maxValues[temp - 1] + 1);
                    area2 = 0;
                } else if (maxValues[1] == 0 && maxValues[temp - 1] < len - 1) {
                    area1 = maxValues[0] * (maxValues[temp - 1] + 1);
                    int secondMax = getMaxValues(H, maxValues[temp - 1] + 1, len - 1)[0];
                    area2 = secondMax * (len - 1 - maxValues[temp - 1]);
                } else if (maxValues[temp - 1] == len - 1 && maxValues[1] > 0) {
                    area2 = maxValues[0] * (len - maxValues[1]);
                    int secondMax = getMaxValues(H, 0, maxValues[1] - 1)[0];
                    area1 = secondMax * (maxValues[1]);
                } else {
                    if (leftMax > rightMax) {
                        area1 = maxValues[0] * maxValues[temp - 1];
                        int secondMax = getMaxValues(H, maxValues[temp - 1] + 1, len - 1)[0];
                        area2 = secondMax * (len - 1 - maxValues[temp - 1]);
                    } else {
                        area2 = maxValues[0] * (len - maxValues[1]);
                        area1 = leftMax * (maxValues[1] - 1);
                    }
                }
            }
            return area1 + area2;
        }

        private int[] getMaxValues(int[] Array, int start, int end) {
            int tempMax = 0;
            ArrayList<Integer> result = new ArrayList<Integer>();
            for (int i = start; i <= end; i++) {
                if (Array[i] > tempMax) {
                    tempMax = Array[i];
                }
            }
            result.add(tempMax);
            for (int j = start; j <= end; j++) {
                if (Array[j] == tempMax) {
                    result.add(j);
                }
            }
            return result.stream().mapToInt(Integer::intValue).toArray();
        }
    }

    //{5, -7, 3, 5, -2, 4, -1}
    public static int maxSliceON3(int[] A){
        int len  = A.length;
        int result = 0;
        for(int p = 0; p < len; p++){
           for(int q = p; q < len;q++){
                int  sum = 0;
               for(int i = p; i < q+1; i++){
                   sum += A[i];
                   result = Math.max(sum,result);
               }
           }
        }
        return result;
    }

    public static int MaxSliceON2(int[] A){
        //start with p and q as 0, then
        int len = A.length;
        int result = 0;
        for(int p = 0; p < len; p++){
            int sum = 0;
            for(int q = p;q < len; q++){
                sum = sum + A[q];
                result = Math.max(sum,result);
            }
        }
        return result;
    }
    //{-5, -7, -3, -5, -2, 4, -1}
    public static int maxSliceOn1(int[] A){
        int maxCurrent = 0;
        int maxGlobal = Integer.MIN_VALUE;
        for(int a : A){
            maxCurrent = Math.max(a, maxCurrent + a);
            maxGlobal = Math.max(maxGlobal,maxCurrent);
        }
        return maxGlobal;
    }

}

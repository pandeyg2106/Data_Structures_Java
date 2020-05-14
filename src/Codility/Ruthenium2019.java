package Codility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Ruthenium2019 {

    public int solution(int[] A, int K) {
        //1. Given A = [1, 1, 3, 4, 3, 3, 4] and K = 2, the function should return 5.
        // Teachers can replace books from age 4 with books from age 3.

        //2. Given A = [4, 5, 5, 4, 2, 2, 4] and K = 0, the function should return 2.
        // Teachers are not allowed to replace any books.

        //3. Given A = [1, 3, 3, 2] and K = 2, the function should return 4.
        // Teachers can replace all the books from other ages with books from age 3.

        // Implementation:
        //Create a hash table and store each number and it's frequency.
        //If K = 0, return the max frequency.
        // Find the key with max frequency, maxKey.
        // Set a counter to 0, iterate the original array, incrementing counter by 1, whenever it sees a number other
        //than maxKey after the first occurrence of maxKey.
        Map<Integer, Integer> inputMap = new HashMap<>();
        Map<Integer, Integer> testMap = new HashMap<>();
        Map<Integer, Integer> lastIndex = new HashMap<>();
        int maxKey = 1;
        int maxFreq = 1;
        int len = A.length;
        for (int i : A) {
            inputMap.put(i, (inputMap.getOrDefault(i, 0)) + 1);
        }
        for (int i = 0; i < len - 1; i++) {
            if(A[i] == A[i + 1]){
                if(!testMap.containsKey(A[i])){
                    testMap.put(A[i],2);
                    lastIndex.put(A[i], i + 1);
                }
                else{
                    testMap.put(A[i],Math.max(testMap.get(A[i]),2));
                    lastIndex.put(A[i], i + 1);
                }
                if (testMap.get(A[i]) > maxKey) {
                    maxKey = testMap.get(A[i]);
                }
            }
//            testMap.replace(A[i],0);
        }

        if (K == 0) {      //No replacements allowed.
            return maxKey;
        }

        if (maxKey == 1 & K>0) { // No repeating ages
            return K+1;
        }
        long max = 0;
        for (Map.Entry<Integer, Integer> k : testMap.entrySet()) {
            if (testMap.get(k.getKey()) == inputMap.get(k.getKey())) {
                int index = lastIndex.get(k.getKey());
                int count = 0;
                while (index < len - 1 && count < K) {
                    testMap.replace(k.getKey(), k.getValue() + 1);
                    index++;
                    count++;
                }
                index = lastIndex.get(k.getKey());
                while (index-2 >= 0 && count < K) {
                    if (A[index - 2] != k.getKey()) {
                        testMap.replace(k.getKey(), k.getValue() + 1);
                        count++;
                    }
                    index--;
                }
                max = testMap.get(k.getKey());
            } else {
                int index = lastIndex.get(k.getKey());
                int count = 0;
                while (index < len - 1 && count < K) {
                    testMap.replace(k.getKey(), k.getValue() + 1);
                    index++;
                    count++;
                }
                index = lastIndex.get(k.getKey());
                while (index-2 >= 0 && count < K) {
                    if (A[index - 2] != k.getKey()) {
                        testMap.replace(k.getKey(), k.getValue() + 1);
                        count++;
                    }
                    index--;
                }
                max = Math.max((long)testMap.get(k.getKey()), (long)inputMap.get(k.getKey()) + K);
            }
        }
        return (int) max;
    }
}

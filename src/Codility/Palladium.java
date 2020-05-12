package Algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Palladium {
    public int palladiumChallenge(int[] H) {
        // write your code in Java SE 8
        int len = H.length;
        int[] maxValues = getMaxValues(H, 0, len - 1);
        int area1;
        int area2;
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int i : H) {
            hashMap.put(i, (hashMap.getOrDefault(i, 0)) + 1);
        }
        int frequencyOfMax = hashMap.get(maxValues[0]);

        if (frequencyOfMax == 1) {
            if (maxValues[1] == 0) {
                area1 = maxValues[0];
                int secondMax = getMaxValues(H, maxValues[1] + 1, len - 1)[0];
                area2 = secondMax * (len - 1);
            } else if (maxValues[1] == len - 1) {
                area2 = maxValues[0];
                int secondMax = getMaxValues(H, 0, len - 2)[0];
                area1 = secondMax * (len - 1);
            } else if (getMaxValues(H, 0, maxValues[1] - 1)[0] >
                       getMaxValues(H, maxValues[1] + 1, len - 1)[0]) {
                area1 = maxValues[0] * (maxValues[1] + 1);
                int secondMax = getMaxValues(H, maxValues[1] + 1, len - 1)[0];
                area2 = secondMax * (len - 1 - maxValues[1]);
            } else {
                area2 = maxValues[0] * (len - maxValues[1]);
                int secondMax = getMaxValues(H, 0, maxValues[1] - 1)[0];
                area1 = secondMax * maxValues[1];
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
            }
            else {
                if (H[maxValues[1] - 1] > H[maxValues[temp - 1] + 1]) {
                    area1 = maxValues[0] * maxValues[temp - 1];
                    int secondMax = getMaxValues(H, maxValues[temp - 1] + 1, len - 1)[0];
                    area2 = secondMax * (len - 1 - maxValues[temp - 1]);
                } else {
                    area2 = maxValues[0] * (len - maxValues[1]);
                    int secondMax = getMaxValues(H, 0, maxValues[1] - 1)[0];
                    area1 = secondMax * (maxValues[1] - 1);
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

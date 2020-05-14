package Algorithms;

public class SlidingWindow {

    public static int getMaxSum(int[] A, int k){
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;

        for(int i = 0; i < A.length; i++){
            sum += A[i];
            if(i >= k-1) {
                maxSum = Math.max(sum, maxSum);
                sum -= A[i - (k-1)];
            }
        }
        return maxSum;
    }

    public static int getMaxProfit(int[] A){
        int start = 0;
        int end = 0;
        int profit = Integer.MIN_VALUE;
        int len = A.length;
        int maxProfit = Integer.MIN_VALUE;
        for(int i = start; i < len-1;i++){
            profit = Math.max(maxProfit,A[end] - A[start]);
            if(end <= len-1){

            }
        }

        while(start < len-1){
            profit = A[end] - A[start];
            maxProfit = Math.max(profit, maxProfit);
            if(end < len-1){
                end++;
            }
            else{
                start++;
                end = start;
            }
        }
        return Math.max(0,maxProfit);
    }

    public static void main(String[] args){
        int[] A = new int[]{23171, 21011, 21123, 21366, 21013, 21367};
        System.out.println(getMaxProfit(A));
    }


}

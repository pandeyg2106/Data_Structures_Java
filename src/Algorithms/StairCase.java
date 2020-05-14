package Algorithms;

public class StairCase {

    public static int solution(int N, int[]X){
        if(N==0)
            return 1;
        var nums = new int[N+1];
        nums[0] = 1;
        for(int i = 1; i <= N; i++){
            int total = 0;
            for(int j : X){
                if(i - j >= 0){
                    total += nums[i-j];
                }
            }
            nums[i] = total;
        }
        return nums[N];
    }

    public static void main(String[] args){
        int[] X = {1,3,5};
        System.out.println(solution(6,X));
    }
}

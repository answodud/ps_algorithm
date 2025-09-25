import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int n = triangle.length;
        
        int[][] dp = new int[n+1][n+1];
        
        dp[0][0] = triangle[0][0];
        
        for(int i = 1; i < n; i++){
            for(int j = 0; j <= i; j++){
                if(j == 0){
                    dp[i][j] = dp[i - 1][j] + triangle[i][j];
                } else if(i == j){
                    dp[i][j] = dp[i - 1][j - 1] + triangle[i][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + triangle[i][j];
                }
            }
        }
        
        for(int x : dp[n - 1]){
            answer = Math.max(answer, x);
        }
        
        return answer;
    }
}
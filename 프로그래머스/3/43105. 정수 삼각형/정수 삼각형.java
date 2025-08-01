class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int x = triangle.length;
        int[][] dp = new int[x + 1][x + 1];
        
        dp[0][0] = triangle[0][0];
        
        for(int i = 1; i < x; i++){
            for(int j = 0; j <= i; j++){
                if(j == 0){
                    dp[i][j] = dp[i - 1][j] + triangle[i][j];
                } else if(j == i){
                    dp[i][j] = dp[i - 1][j - 1] + triangle[i][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + triangle[i][j];
                }
            }
        }
        
        for(int m : dp[x - 1]){
            answer = Math.max(answer, m);    
        }
        
        return answer;
    }
}
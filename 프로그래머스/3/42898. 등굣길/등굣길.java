class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        
        int[][] dp = new int[m+1][n+1];
        
        dp[1][1] = 1;
        boolean isPuddle = false;
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(i == 1 && j == 1){
                    continue;
                }
                isPuddle = false;
                for(int[] puddle : puddles){
                    if(puddle[0] == i && puddle[1] == j){
                        isPuddle = true;
                        continue;
                    }
                }
                
                if(isPuddle){
                    dp[i][j] = 0;
                    continue;
                }
                
                int x = 0;
                if(i > 1){
                    x += dp[i - 1][j];
                }
                if(j > 1){
                    x += dp[i][j - 1];
                }
                dp[i][j] = x % 1000000007;
                
            }
        }
        
        return dp[m][n];
    }
}
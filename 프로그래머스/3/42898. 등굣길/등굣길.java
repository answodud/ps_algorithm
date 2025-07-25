class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        
        int[][] dp = new int[m+1][n+1];
        
        dp[1][1] = 1;
        
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(i == 1 && j == 1){
                    continue;
                }
                
                boolean p = false;
                for(int[] pu : puddles){
                    if(pu[0] == i && pu[1] == j){
                        p = true;
                    }
                }
                
                if(p){
                    dp[i][j] = 0;
                    continue;
                }
                
                int way = 0;
                if(i > 1){
                    way += dp[i - 1][j];
                }
                
                if(j > 1){
                    way += dp[i][j - 1];
                }
                
                dp[i][j] = way % 1000000007;
            }
        }
        
        return dp[m][n];
    }
}
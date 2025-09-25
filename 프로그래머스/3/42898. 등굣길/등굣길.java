class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        
        int[][] dp = new int[m+1][n+1];
        dp[1][1] = 1;
        
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                
                boolean isPu = false;
                for(int[] pu : puddles){
                    if(i == pu[0] && j == pu[1]){
                        isPu = true;
                    }
                }
                
                int ways = 0;
                
                if(i == 1 && j == 1){
                    continue;
                }
                
                if(isPu == true){
                    dp[i][j] = 0;
                } else {
                    ways += dp[i - 1][j];
                    ways += dp[i][j - 1];
                }
                dp[i][j] = ways % 1000000007;
            }
        }
        
        return dp[m][n];
    }
}
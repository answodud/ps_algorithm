class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        
        // a가 b를 이기고, b가 c를 이기면, a가 c도 이김
        
        int[][] arr = new int[n+1][n+1];
        
        for(int i = 0; i < results.length; i++){
            int win = results[i][0];
            int lose = results[i][1];
            arr[win][lose] = 1;
            arr[lose][win] = -1;
        }
        
        for(int k = 1; k <= n; k++){
            for(int i = 1; i <= n; i++){
                for(int j = 1; j <= n; j++){
                    if(arr[i][k] == 1 && arr[k][j] == 1){
                        arr[i][j] = 1;
                        arr[j][i] = -1;
                    }
                }
            }
        }
        
        for(int i = 1; i < arr.length; i++){
            int cnt = 0;
            for(int j = 1; j < arr[i].length; j++){
                if(arr[i][j] != 0){
                    cnt++;
                }
            }
            if(cnt == n - 1){
                answer++;
            }
        }
        
        return answer;
    }
}
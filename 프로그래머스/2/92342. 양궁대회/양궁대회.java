class Solution {
    
    int n;
    int[] info;
    int[] lion = new int[11];
    int max = 0;
    int[] answer = new int[11];
    
    public int[] solution(int n, int[] info) {
        
        this.n = n;
        this.info = info;
        
        dfs(0, 0);
        
        if(max == 0){
            return new int[] {-1};
        }
        
        return answer;
    }
    
    public void dfs(int idx, int cnt){
        // 쏜 화살 개수가 n개면
        if(cnt == n || idx == 10){
            if(cnt < n){
                lion[10] = n - cnt;
            }
            int lscore = 0;
            int pscore = 0;
            // 점수계산
            for(int i = 0; i <= 10; i++){
                if(lion[i] > info[i]){
                    lscore += 10 - i;
                } else if(lion[i] <= info[i]) {
                    if(lion[i] == 0 && info[i] == 0){
                        continue;   
                    }
                    pscore += 10 - i;
                }
            }
            
            if(max < (lscore - pscore)){
                answer = lion.clone();
                max = lscore - pscore;
            } else if (max == (lscore - pscore)){
                for(int i = 10; i >= 0; i--){
                    if(answer[i] < lion[i]){
                        answer = lion.clone();
                    } else if(answer[i] > lion[i]){
                        break;
                    }
                }
            }
            
            if (cnt < n) lion[10] = 0; 
            return;
            
        }
        
        for(int i = 0; i <= n - cnt; i++){
            lion[idx] = i; // idx 점에 i번 쐈음
            dfs(idx + 1, cnt + i);
            lion[idx] = 0;
        }
        
    }
}
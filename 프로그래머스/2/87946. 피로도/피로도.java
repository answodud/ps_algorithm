import java.util.*;

class Solution {
    boolean[] visited;
    int max = -1;
    public int solution(int k, int[][] dungeons) {
        
        visited = new boolean[dungeons.length];
        dfs(dungeons, k, 0);
        
        return max;
    }
    
    public void dfs(int[][] dungeons, int piro, int cnt){
        if(cnt > dungeons.length){
            return;
        }
        for(int i = 0; i < dungeons.length; i++){
            if(!visited[i]){
                if(dungeons[i][0] > piro){
                    continue;
                }
                visited[i] = true;
                dfs(dungeons, piro - dungeons[i][1], cnt + 1);
                visited[i] = false;
            }
            
        }
        max = Math.max(max, cnt);
    }
}
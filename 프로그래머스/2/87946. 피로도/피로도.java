import java.util.*;

class Solution {
    
    public static boolean[] visited;
    public static int answer = 0;
    
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        dfs(dungeons, k, 0);
        return answer;
    }
    
    public void dfs(int[][] dungeons, int piro, int depth){
        if(depth > dungeons.length){
            return;
        }
        for(int i = 0; i < dungeons.length; i++){
            if(!visited[i]){
                if(dungeons[i][0] > piro){
                    continue;
                } else {
                    visited[i] = true;
                    dfs(dungeons, piro - dungeons[i][1], depth + 1);
                    visited[i] = false;
                }
            }
        }
        
        answer = Math.max(answer, depth);
    }
}
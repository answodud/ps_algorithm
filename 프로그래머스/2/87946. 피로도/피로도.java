class Solution {
    int k;
    int[][] dungeons;
    boolean[] visited;
    int max_cnt = 0;
    
    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        this.k = k;
        this.dungeons = dungeons;
        visited = new boolean[dungeons.length];
        
        dfs(k, 0, 0);
        
        return max_cnt;
    }
    
    public void dfs(int piro, int depth, int cnt){
        
        if(depth >= dungeons.length){
            max_cnt = Math.max(max_cnt, cnt);
            return;
        }
        
        for(int i = 0; i < dungeons.length; i++){
            if(!visited[i]){
                visited[i] = true;
                if(dungeons[i][0] <= piro){
                    dfs(piro - dungeons[i][1], depth + 1, cnt + 1);
                } else {
                    dfs(piro, depth + 1, cnt);
                }
                visited[i] = false;
            }
        }
    }
}
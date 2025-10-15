import java.util.*;

class Solution {
    
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    boolean[][] visited;
    int n, m;
    int[][] land;
    HashSet<Integer> cols;
    
    public int solution(int[][] land) {
        int answer = 0;
        
        // n이 세로, m이 가로
        n = land.length;
        m = land[0].length;
        
        this.land = land;
        int[] total = new int[m];
        visited = new boolean[n][m];
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(!visited[j][i] && land[j][i] == 1){
                    cols = new HashSet<>();
                    int cnt = bfs(j, i);
                    for(int y : cols){
                        total[y] += cnt;
                    }
                }
            }
        }
        
        for(int x : total){
            answer = Math.max(answer, x);
        }
        
        return answer;
    }
    
    public int bfs(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        int cnt = 0;
        visited[x][y] = true;
        q.offer(new int[]{x, y});
        cols.add(y);
        
        while(!q.isEmpty()){
            cnt++;
            int[] cur = q.poll();
            for(int i = 0; i < 4; i++){
            int nx = cur[0] + dx[i];
            int ny = cur[1] + dy[i];
            if(nx >= 0 && ny >= 0 && nx < n && ny < m){
                if(!visited[nx][ny] && land[nx][ny] == 1){
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx, ny});
                    cols.add(ny);
                }
            }
        }
        }
        return cnt;
    }
}
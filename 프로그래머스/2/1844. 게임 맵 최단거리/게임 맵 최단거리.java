import java.util.*;

class Solution {
    
    int[] dx = {-1,1,0,0};
    int[] dy = {0,0,-1,1};
    int[][] maps;
    boolean[][] visited;
    int n, m;
    
    public int solution(int[][] maps) {
        this.maps = maps;
        n = maps.length;
        m = maps[0].length;
        visited = new boolean[n][m];
        
        bfs(0, 0);
        
        if(!visited[n - 1][m - 1]){
            return -1;
        }
        
        return maps[n - 1][m - 1];
    }
    
    public void bfs(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        visited[x][y] = true;
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];
            for(int i = 0; i < 4; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if(nx >= 0 && ny >= 0 && nx < n && ny < m){
                    if(!visited[nx][ny] && maps[nx][ny] != 0){
                        visited[nx][ny] = true;
                        maps[nx][ny] = maps[cx][cy] + 1;
                        q.offer(new int[]{nx,ny});
                    }
                }
            }
        }
        
    }
}
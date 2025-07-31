import java.util.*;

class Solution {
    
    boolean[][] visited;   
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    int N, M;
    
    public int solution(int[][] maps) {
        N = maps.length;
        M = maps[0].length;
        visited = new boolean[N][M];
        int answer = bfs(0, 0, maps);
        
        if(!visited[N-1][M-1]){
            return -1;
        }
        
        return answer;
    }
    
    public int bfs(int x, int y, int[][] maps){
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
                
                if(nx >= 0 && ny >= 0 && nx < N && ny < M){
                    if(!visited[nx][ny] && maps[nx][ny] == 1){
                        visited[nx][ny] = true;
                        maps[nx][ny] = maps[cx][cy] + 1;
                        q.offer(new int[]{nx, ny});
                    }
                }
            }
        }
        
        return maps[N - 1][M - 1];
    }
}
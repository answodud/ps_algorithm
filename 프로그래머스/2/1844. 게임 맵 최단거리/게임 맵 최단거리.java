import java.util.*;

class Solution {
    class Map {
        int x;
        int y;
        Map(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    boolean[][] visited;
    int N, M;
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    
    public int solution(int[][] maps) {
        int answer = 0;
        N = maps.length;
        M = maps[0].length;
        visited = new boolean[N][M];
        
        answer = bfs(0, 0, maps);
        if(!visited[N-1][M-1]){
            return -1;
        }
        
        return answer;
    }
    
    public int bfs(int x, int y, int[][] maps){
        Queue<Map> q = new LinkedList<>();
        q.offer(new Map(x, y));
        visited[x][y] = true;
        
        while(!q.isEmpty()){
            Map cur = q.poll();
            for(int i = 0; i < 4; i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if(nx >= 0 && ny >= 0 && nx < N && ny < M){
                    if(!visited[nx][ny] && maps[nx][ny] != 0){
                        q.offer(new Map(nx, ny));
                        visited[nx][ny] = true;
                        maps[nx][ny] = maps[cur.x][cur.y] + 1;
                    }
                }
            }
        }
        
        return maps[N-1][M-1];
        
    }
}
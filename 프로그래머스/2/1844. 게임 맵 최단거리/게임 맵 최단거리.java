import java.util.*;

class Solution {
    boolean[][] visited;
    int N, M;
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    
    class Map {
        int x;
        int y;
        
        Map(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
    public int solution(int[][] maps) {
        int answer = 0;
        N = maps.length;
        M = maps[0].length;
        
        visited = new boolean[N][M];
        answer = bfs(0,0,maps);
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
            int cx = cur.x;
            int cy = cur.y;
            
            for(int i = 0; i < 4; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                
                if(nx >= 0 && ny >= 0 && nx < N && ny < M){
                    if(maps[nx][ny] != 0 && !visited[nx][ny]){
                        visited[nx][ny] = true;
                        maps[nx][ny] = maps[cx][cy] + 1;
                        q.offer(new Map(nx, ny));
                    }
                        
                    }
                }
            }
        return maps[N-1][M-1];
        }
    
    }

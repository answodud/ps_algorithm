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
    
    int[] ax = {-1, 1, 0, 0};
    int[] ay = {0, 0, -1, 1};
    
    boolean[][] maps;
    int[][] visited;
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        
        maps = new boolean[102][102]; // 경로 구분 용도
        visited = new int[102][102]; // 방문 여부 확인 + 경로 길이 저장
        
        int chX = characterX * 2;
        int chY = characterY * 2;
        itemX = itemX * 2;
        itemY = itemY * 2;
        
        
        for(int i = 0; i < rectangle.length; i++){
            int[] cur = rectangle[i];
            int x1 = cur[0] * 2;
            int x2 = cur[2] * 2;
            int y1 = cur[1] * 2;
            int y2 = cur[3] * 2;
            // 사각형 테두리 + 내부 포함 전부 true로 채우기
            for(int j = x1; j <= x2; j++){
                for(int k = y1; k <= y2; k++){
                    maps[j][k] = true;
                }
            }
        }
        
        for(int i = 0; i < rectangle.length; i++){
            int[] cur = rectangle[i];
            int x1 = cur[0] * 2;
            int x2 = cur[2] * 2;
            int y1 = cur[1] * 2;
            int y2 = cur[3] * 2;
            // 사각형 내부 false로 변경
            for(int l = x1 + 1; l < x2; l++){
                for(int m = y1 + 1; m < y2; m++){
                    maps[l][m] = false;
                }
            }
        }
        
        
        bfs(chX, chY);
        
        return visited[itemX][itemY] / 2;
    }
    
    public void bfs(int x, int y){
        Queue<Map> q = new LinkedList<>();
        q.offer(new Map(x, y));
        visited[x][y] = 1;
        
        while(!q.isEmpty()){
            Map cur = q.poll();
            for(int i = 0; i < 4; i++){
                int nx = cur.x + ax[i];
                int ny = cur.y + ay[i];
                if(nx > 1 && ny > 1 && nx < 101 && ny < 101){
                    if(maps[nx][ny] == true && visited[nx][ny] == 0){
                        q.offer(new Map(nx, ny));
                        visited[nx][ny] = visited[cur.x][cur.y] + 1;
                    }
                }
            }
        }
        
    }
    
}
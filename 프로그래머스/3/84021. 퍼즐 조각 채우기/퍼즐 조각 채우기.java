import java.util.*;

class Solution {
    
    int[] dx = {-1,1,0,0};
    int[] dy = {0,0,-1,1};
    int[][] game_board;
    int[][] table;
    boolean[][] visited;
    int N;
    List<List<int[]>> blank = new ArrayList<>();
    List<List<int[]>> puzzle = new ArrayList<>();
    
    public int solution(int[][] game_board, int[][] table) {

        this.game_board = game_board;
        this.table = table;
        N = table.length;
        visited = new boolean[N][N];
  
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(!visited[i][j] && game_board[i][j] == 0){
                    List<int[]> b = bfs(i, j, 0);
                    blank.add(normalize(b));
                }
            }
        }
        
        visited = new boolean[N][N];
        
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(!visited[i][j] && table[i][j] == 1){
                    List<int[]> p = bfs(i, j, 1);
                    puzzle.add(normalize(p));
                }
            }
        }
        int answer = 0;
boolean[] used = new boolean[puzzle.size()];

for (List<int[]> b : blank) {
    for (int i = 0; i < puzzle.size(); i++) {
        if (used[i]) continue;
        List<int[]> p = puzzle.get(i);
        for (int r = 0; r < 4; r++) {
            if (match(b, p)) {
                answer += b.size();
                used[i] = true;
                break;
            }
            p = rotate(p);
        }
        if (used[i]) break;
    }
}

        
        return answer;
    }
    
    // 빈칸 또는 퍼즐 찾아주는 로직
    public List<int[]> bfs(int x, int y, int type){
        Queue<int[]> q = new LinkedList<>();
        List<int[]> puzzle = new ArrayList<>();
        q.offer(new int[]{x,y});
        visited[x][y] = true;
        puzzle.add(new int[]{x,y});
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];
            for(int i = 0; i < 4; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if(nx >= 0 && ny >= 0 && nx < N && ny < N){
                    if(type == 0){
                        if(!visited[nx][ny] && game_board[nx][ny] == 0){
                            q.offer(new int[]{nx, ny});
                            visited[nx][ny] = true;
                            puzzle.add(new int[]{nx, ny});
                        }
                    } else {
                        if(!visited[nx][ny] && table[nx][ny] == 1){
                            q.offer(new int[]{nx, ny});
                            visited[nx][ny] = true;
                            puzzle.add(new int[]{nx, ny});
                        }
                    }
                    
                }
            }
        }
        
        return puzzle;
    }
    
    // 정규화
    public List<int[]> normalize(List<int[]> puzzle){
        List<int[]> norm = new ArrayList<>();
        int min_x = 51;
        int min_y = 51;
        for(int[] p : puzzle){
            min_x = Math.min(min_x, p[0]);
            min_y = Math.min(min_y, p[1]);
        }
        for(int[] p : puzzle){
            int new_x = p[0] - min_x;
            int new_y = p[1] - min_y;
            norm.add(new int[]{new_x, new_y});
        }
        
        return norm;
    }
    
    // 서명만들기
    public String makeSign(List<int[]> norm){
        StringBuilder sb = new StringBuilder();
        for(int[] n : norm){
            sb.append(n[0]).append(",").append(n[1]).append(";");
        }
        return sb.toString();
    }
    
    public List<int[]> rotate(List<int[]> shape) {
    int maxX = 0, maxY = 0;
    for (int[] p : shape) {
        maxX = Math.max(maxX, p[0]);
        maxY = Math.max(maxY, p[1]);
    }
    List<int[]> rotated = new ArrayList<>();
    for (int[] p : shape) {
        rotated.add(new int[]{p[1], maxX - p[0]});
    }
    return normalize(rotated);
}
    
    public boolean match(List<int[]> a, List<int[]> b) {
    if (a.size() != b.size()) return false;
    a.sort(Comparator.comparingInt((int[] p) -> p[0] * 100 + p[1]));
    b.sort(Comparator.comparingInt((int[] p) -> p[0] * 100 + p[1]));
    for (int i = 0; i < a.size(); i++) {
        if (a.get(i)[0] != b.get(i)[0] || a.get(i)[1] != b.get(i)[1]) return false;
    }
    return true;
}


}
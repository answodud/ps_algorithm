import java.util.*;

class Solution {
    
    class Pos {
        int x;
        int y;
        Pos(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
    public int solution(int[][] game_board, int[][] table) {
        int answer = -1;
        
        List<List<Pos>> pieces = extractRegions(table, 1);
        List<List<Pos>> holes  = extractRegions(game_board, 0);
        
        // (b) 조각: 크기별 + 대표서명별 개수 관리
        Map<Integer, Map<String, Integer>> pieceMap = new HashMap<>();
        for(List<Pos> p: pieces){
            int size = p.size();
            String key = canonicalSignature(p);
            pieceMap.computeIfAbsent(size, k->new HashMap<>())
                    .merge(key, 1, Integer::sum);
        }

        // (c) 빈칸 돌며 매칭
        int filled = 0;
        for(List<Pos> h: holes){
            int size = h.size();
            Map<String,Integer> bySig = pieceMap.get(size);
            if(bySig==null) continue;

            String hKey = canonicalSignature(h); // 빈칸도 대표서명
            Integer cnt = bySig.get(hKey);
            if(cnt!=null && cnt>0){
                bySig.put(hKey, cnt-1); // 조각 소모
                filled += size;
            }
        }
        
        return filled;
    }
    
    // 영역 추출: DFS로 target(조각=1, 빈칸=0) 모양 좌표 뭉텅이 =====
    List<List<Pos>> extractRegions(int[][] grid, int target){
        int n = grid.length;
        boolean[][] vis = new boolean[n][n];
        int[] dx = {1,-1,0,0}, dy = {0,0,1,-1};
        List<List<Pos>> regions = new ArrayList<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(!vis[i][j] && grid[i][j]==target){
                    List<Pos> cells = new ArrayList<>();
                    Deque<Pos> st = new ArrayDeque<>();
                    st.push(new Pos(i,j));
                    vis[i][j]=true;

                    while(!st.isEmpty()){
                        Pos cur = st.pop();
                        cells.add(cur);
                        for(int k=0;k<4;k++){
                            int nx = cur.x+dx[k], ny = cur.y+dy[k];
                            if(0<=nx && nx<n && 0<=ny && ny<n && !vis[nx][ny] && grid[nx][ny]==target){
                                vis[nx][ny]=true;
                                st.push(new Pos(nx,ny));
                            }
                        }
                    }
                    regions.add(cells);
                }
            }
        }
        return regions;
    }
    
    String normalize(List<Pos> cells){
        int minX=Integer.MAX_VALUE, minY=Integer.MAX_VALUE;
        for(Pos p: cells){ minX=Math.min(minX,p.x); minY=Math.min(minY,p.y); }
        List<String> moved = new ArrayList<>(cells.size());
        for(Pos p: cells) moved.add((p.x-minX)+","+(p.y-minY));
        Collections.sort(moved);
        return String.join("|", moved);
    }

    List<Pos> rotate(List<Pos> cells, int deg){
        List<Pos> out = new ArrayList<>(cells.size());
        for(Pos p: cells){
            int x=p.x, y=p.y;
            switch(deg){
                case 0 -> out.add(new Pos(x,y));
                case 90 -> out.add(new Pos(y,-x));
                case 180 -> out.add(new Pos(-x,-y));
                case 270 -> out.add(new Pos(-y,x));
            }
        }
        return out;
    }

    String canonicalSignature(List<Pos> cells){
        int[] degs = {0,90,180,270};
        String best = null;
        for(int d: degs){
            String sig = normalize(rotate(cells, d));
            if(best==null || sig.compareTo(best)<0) best = sig;
        }
        return best; // 회전과 무관한 대표 서명
    }
    
    
}
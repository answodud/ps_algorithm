import java.util.*;

class Solution {
    
    class Point {
        int x;
        int y;
        Point parent; // 그 전 좌표를 저장
        
        Point(int x, int y, Point parent){
            this.x = x;
            this.y = y;
            this.parent = parent;
        }
    }
    
    int[][] points;
    int[][] routes;
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    boolean[][] visited;
    
    public int solution(int[][] points, int[][] routes) {
        int answer = 0;
        this.points = points;
        this.routes = routes;
        
        List<Point>[] arr = new ArrayList[routes.length];
        
        int cnt = 0;
        for(int[] route : routes){
            List<Point> allPath = new ArrayList<>();
            for(int i = 1; i < route.length; i++){
                int start_idx = route[i - 1];
                int end_idx = route[i];
                int[] start = points[start_idx - 1];
                int[] end = points[end_idx - 1];
                
                List<Point> path = bfs(start, end);
                if(allPath.isEmpty()){
                   allPath.addAll(path); 
                } else {
                    path.remove(0);
                    allPath.addAll(path);
                }
                
            }
            arr[cnt] = allPath;
            cnt++;
        }

        int maxT = 0;
        
        for(List<Point> p : arr){
            maxT = Math.max(p.size(), maxT);
        }
        
        for(int t = 0; t < maxT; t++){
            HashMap<String, Integer> map = new HashMap<>();
            for(int i = 0; i < routes.length; i++){
                List<Point> a = arr[i];
                if(t >= a.size()){
                    continue;
                }
                Point p = a.get(t);
                if(map.containsKey(p.x+","+p.y)){
                    map.replace(p.x+","+p.y, map.get(p.x+","+p.y) + 1);
                } else {
                    map.put(p.x+","+p.y, 1);
                }
            }
            for(String x : map.keySet()){
                if(map.get(x) >= 2){
                    answer++;
                }
            }
        }
        
        return answer;
    }
    
    
    public List<Point> bfs(int start[], int end[]){
        Queue<Point> q = new LinkedList<>();
        visited = new boolean[101][101];
        Point[][] parent = new Point[101][101];
        Point s = new Point(start[0], start[1], null);
        Point endPoint = null;
        q.offer(s);
        visited[s.x][s.y] = true;
        while(!q.isEmpty()){

            Point cur = q.poll();
            
            
            if(cur.x == end[0] && cur.y == end[1]){
                endPoint = cur;
                break;
            }
            
            for(int i = 0; i < 4; i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if(nx >= 1 && nx <= 100 && ny >= 1 && ny <= 100){
                    if(visited[nx][ny] == false){
                        visited[nx][ny] = true;
                        parent[nx][ny] = cur;
                        q.offer(new Point(nx, ny, cur));
                    }
                }
            }
        }
        
        List<Point> path = new ArrayList<>();
        
        while(endPoint != null){
            path.add(endPoint);
            endPoint = endPoint.parent;
        }
        Collections.reverse(path);
        return path;
    }
    
}